# DiceRolling Client Server Design Note

by Yuxuan Yang

Table of Contents

1. [1. Communication Mode](#1-communication-mode)
2. [2. Websocket SocketJS and STOMP](#2-websocket-socketjs-and-stomp)
    1. [2.1 Websocket](#21-websocket)
    2. [2.2 SocketJS](#22-socketjs)
    3. [2.3 STOMP](#23-stomp)
    4. [2.4 broadcast](#24-broadcast-way)
3. [3. (Server)Websocket with Java SpringBoot](#3-websocket-with-java-springboot)
    1. [3.0 Message, Server, Servlet, Request, Response](#30-message-server-servlet-request-response)
        1. [3.0.1 JavaEE Servlets](#301-javaee-servlets)
        2. [3.0.2 Apache Http Components Library](#302-apache-http-components-library)
    2. [3.1 configureMessageBroker](#31-configuremessagebroker)
    3. [3.2 registerStompEndpoints](#32-registerstompendpoints)
    4. [3.3 EventListener and HeadAccessor](#33-eventlistener-and-headaccessor)
    5. [3.4 Scheduling](#34-scheduling)
    6. [3.5 Interceptor](#35-interceptor)
        1. [3.5.1 Channel Interceptor](#351-channel-interceptor)
        2. [3.5.2 Handshake Interceptor](#352-handshake-interceptor)
4. [4. (Server)Game Server Design](#4-game-server-design)

## 1. Communication Mode

A very essential part in designing webgame is to keep information synchronized between both "Server and Client" and "
Client and Client". For game that requires strong dynamic time control will choose **frame sync**, while turn-based game
will prefer **state sync**.

> Frame Sync Structure:
> Server defined sequence in time,
> within a time sequence,
> client must submit current state to server,
> then server broadcast new state to all connected client

> State Sync:
> Client send one state to Server,
> and Server broadcast to other client while Client do something.
> No serious time sequence control.

In this game, we choose the approach of State Sync since the player will only do action one by one in their turn.

## 2. Websocket SocketJS and STOMP

HTTP only allows client to send requirement, server only waiting for response. To achieve dual communication, **
Websocket protocal** must be introduced. Websocket protocol was defined by RFC as a *full duplex* communication channels
at layer 7 by HTML5.

### 2.1 Websocket

To debug websocket request, developerTools use network and filter WS.

To open a websocket connection:

```js
var Socket = new WebSocket(url, [protocol]);
//url: must use 'wss://' format to encrypted the data
//otherwise, if 'ws://' is used, old browser might not recognize it.
```

To check connection states:

```js
Socket.readyState
//0 connecting(not yet)
//1 open
//2 closing
//4 closed
```

To listen to 4 events:

```js
Socket.onopen//while established
Socket.onmessage//while received
Socket.onclose//while closed
Socket.onerror//while error
```

To transfer data

```js
Socket.send(body)//send string or binary
//Note: if binary, Blob or Arraybuffer.
Socket.binaryType
//Set by, and default as "blob"
```

To show buffer bytes remain to be sent

```js
Socket.bufferedAmount
//Example:
// every 100ms examine the socket and send more data
// only if all the existing data was sent out
setInterval(() => {
    if (socket.bufferedAmount == 0) {
        socket.send(moreData());
    }
}, 100);
```

To Close Socket

```js
// closing party:
socket.close(1000, "Work complete");

// the other party while on closing 1000 party
socket.onclose = event => {
    // event.code === 1000
    // event.reason === "Work complete"
    // event.wasClean === true (clean close)
};
//other code will be checked at 
// https://www.rfc-editor.org/rfc/rfc6455.html#section-7.4.1
```

### 2.2 SocketJS

Old version of browser might not support HTML5 newly introduced method to create WebSocket object. Thus **SocketJS**
provided a "fallback" version library to create object that is similar to Websocket object.

To use SocketJS

```js
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
```

To open a SocketJS connection:

```js
var sockjs = new SockJS(url, _reserved, options);
//option 1: server(string) default 4 numbers
//option 2: transports: list of fallback
//option 3: sessionID: a random session ID
```

The others are similar to Websocket

### 2.3 STOMP

Specifically, while using Socket to transfer text
(STOMP: Simple/Streaming text-orientated messaging protocol), a protocol was provided, used to communicate with STOMP
message agent(broker). Of course, we can use STOMP over HTML5's Websocket by library API `stomp.js`. It's also possible
to use SocketJS as a fallback way.

To use Websocket:

```js
var StompClient = Stomp.over(WebSocket)//or SocketJS
//create STOMP over exist WebSocket object(or SocketJS object)
```

To Connect:

```js
var connectCallback = function () {
//connectCallback: when connect is successfully done,
}

var headers = {
    login: '',
    passcode: '',
    // additional header
    'client-id': 'my-client-id'
    //to include map of login and passcode
};

StompClient.connect(headers, connectCallback)
//header: map(can be empty if server not required)
//call connectCallback function
```

To Send Message:

```js
client.send("/queue/test", {priority: 9}, "Hello, STOMP");

client.send("/topic/stocks", {}, JSON.stringify(quote));
//can send string from stringify JSON object 
```

To Receive Message from subscribed destination:

```js
var callback = function () {
}
var subscription1 = client.subscribe("/queue/test", callback);
var subscription2 = client.subscribe("queue/another", callback(message));
//To subscribe to multiple destination

var quote = JSON.parse(message.body)
//can parse String back to JSON object
```

To Disconnect:

```js
  client.disconnect(function () {
    alert("See you next time!");
};
```

For more information referred to [Stomp over Websocket](http://jmesnil.net/stomp-websocket/doc/).

### 2.4 Broadcast Way

- Unicast: point to point
- Broadcast: everyone
- Multicast: point to Groups

## 3. Websocket With Java Springboot

Websocket has two Functionalities that can be use:

* **Event Methods**, that trigger event within Websocket, such as :
  CONNECT, SEND, CLOSE...
* **Listener Methods**, that listen for events that has been triggered, such as : OnOpen, OnConnect, OnClose...

The supportive document: [WebSockets API Document](https://developer.mozilla.org/en-US/docs/Web/API/WebSockets_API)

Springboot has `WebSocketMessageBrokerConfigurer`
to provide the method of Endpoint and broker configuration, as well as Interceptor and EventListener for Websocket.

* The annotation `@EnableWebSocketMessageBroker`defined **class** of configuration.
* `configureMessageBroker(MessageBrokerRegistry config)` function configure broker
* `registerStompEndpoints(StompEndpointRegistry registry)` function configure message Endpoint
* `HandshakeInterceptor` and `ChannelInterceptor` define before and after handshake interceptor
* `EventListener` after handshake on four events.

### 3.0 Message, Server, Servlet, Request, Response

Historically, there're two parallel package to hold HTTP Request/Response:

* JavaEE Servlets(comes first)
* Apache Http Components Library

The JavaEE Servlets contains `HttpServletRequest` and `HttpServletResponse`, comparably Apache has `HttpRequest`
and `HttpResponse`.

#### 3.0.1 JavaEE Servlets

_Servlets_ run in a servlet container, which the well known one might be **Tomcat**. It is a Java object to handle Http
Request.

`HttpServletRequest` and `HttpServletResponse` are server-side class, extended from `ServletRequest`
and `ServletResponse` respectively. When implementing servlets, one must use JavaEE's rather than
Apache's.  `ServletRequest` and `ServletResponse` provide three part:
_HTTP Servlet_, _Body_ and _Headers_.

> `HttpServletRequest`<--(extends)--`ServletRequest`

> `HttpServletResponse`<--(extends)--`ServletResponse`

Similary, two other things `HttpInputMessage` and `HttpOutputMessage` only has _Body_ and _Headers_,
while `HttpInputMessage` need extra **METHOD** in it's header.
`HttpMessage` defines the commonly used getHeader() method to get HTTP header except METHOD, and the Body is got
respectively by their own methods, as shown below:
> `HttpMessage`<---`HttpHeaders getHeader()`<---`MultiValueMap`<---`Map`

> `HttpInputMessage`<--(extends)--`HttpMessage`

> `HttpOutputMessage`<--(extends)--`HttpMessage`

#### 3.0.2 Apache Http Components Library

For the request header,`HttpRequest`need extra **METHOD**
thus `getHeader()` extends from `HttpMessage` as usual, while `getMethod()` defined by itself.

> `HttpRequest`<--(extends)--`HttpMessage`

A Server side representation is `ServerHttpRequest` and based on both JavaEE's `HttpInputMessage` and
Apache's `HttpRequest`.

A Whole combination of them is `ServletServerHttpRequest`, which is server-side, contains both
JavaEE's `ServletRequest` `HttpInputMessage` and Apache's `HttpRequest`.
![](11334c891bce53db804563c4a1d9a744.png)

### 3.1 configureMessageBroker

To config Broker prefix

```java
config.enableSimpleBroker("/prefix_url");
//config the prefix of Client subscription
//Client will subscribe to "/prefix_url/**"

        config.setApplicationDestinationPrefixes("/prefix_url")
//config the prefix of Server received mapping destination
//Note that Client will send to "/prefix_url/**"
//while @MessageMapping will receive at "/**" without "/prefix_url"
```

To receive message in controller

```java
@MessageMapping('/url')
//url: the destination without prefix that configured in setApplicationDestinationPrefixes
```

To send message to Client from controller,

- two ways:
    - use `@SendTo` annotation programming
    - use `SimpMessagingTemplate` in a Service

`@SendTo` annotation will **Broadcast** to all user page that can access to the url, while `SimpMessagingTemplate`
provides more methods to support other **Unicast** to user or **Multicast** to groups.

For example, if one want to **Broadcast** information:
> JS: subscribe to single url

```js
stompClient.subscribe('/url

function (...) {...
```

> Spring: send object to all the url by @SendTo

```java
@SendTo('/url')
public myObject send(...){
        ...
        return myObject
        }
```

For example, if one want to **Unicast** to one's special channel.
> HTML: If we need to access model value from thymeleaf in JS, we must store it firstly in HTML, possibly with hidden value, shown below

```html
<input type="hidden" id="myid" th:value="${myid}"/>
<!--hidden way to store value in model-->
```

> JS: subscribe to my special channel use my id stored in HTML, shown below

```js
var my_id = ${#myid}
}.
val()
stompClient.subscribe('/url/' + my_id,
    function (...) {...
```

> Spring: using SimpMessagingTemplate(can be wrapped in Service) to send to special url

```java
SimpMessagingTemplate.convertAndSend("/url/"+myid,content);
```

### 3.2 registerStompEndpoints

Endpoint was used to create STOMP websocket. For example, we can create STOMP over SocketJS as below:

```java
//Java Spring @Override registerStompEndpoints
StompEndpointRegistry.addEndpoint("/endpoint_url").withSockJS();
//.withSockJS() will enable SocketJS way of Object
```

```js
//javascript
var socket = new SockJS('/endpoint_url');
stompClient = Stomp.over(socket);
```

### 3.3 EventListener and HeadAccessor

Springboot has `ApplicationListener<>` to provide the method of listen on 4 Websocket events. For example:

* `ApplicationListener<SessionConnectEvent>` provide connect event listener
* ...
* other's can check SessionEvent abstract class AbstractSubProtocolEvent

The event's header can be accessed by `StompHeaderAccessor`.
`StompHeaderAccessor` can access header's information such as:

* header type(connect, subscribe)
* sessionID
* ...

For example:

```java
StompHeaderAccessor headerAccessor=StompHeaderAccessor.wrap(sessionConnectEvent.getMessage());
//the event header sessionConnectEvent.getMessage()
//headerAccessor has information of headers
```

### 3.4 Scheduling

To regularly run we need to add annotation `@EnableScheduling`in front of Spring main function.

Note that If method was scheduled, it should not have any parameter.

### 3.5 Interceptor

After adding interceptor on Websocket, the message now is passing through the way as:
> `message`--->`HandshakeInterceptor`--->`ChannelInterceptor`

#### 3.5.1 Channel Interceptor

Spring use `Message` to represent information with header and payload, and it was sent through `MessageChannel`
. `ChannelInterceptor` provides a way to capture information before and after `Message` is sending through channel, and
we can configure it through it's inplementation(see `ChannelInterceptor` Interface).

Note that if messages are comming from Websocket, we also need to register interceptor in Websocket Configuration
through implementation of `WebSocketMessageBrokerConfigurer`
by override corresponding methods, as following:

```java
@Override
public void configureClientInboundChannel(ChannelRegistration registration){
        WebSocketMessageBrokerConfigurer.super.configureClientInboundChannel(registration);
        registration.interceptors(new SocketChannelInteceptor());
        }
@Override
public void configureClientOutboundChannel(ChannelRegistration registration){
        WebSocketMessageBrokerConfigurer.super.configureClientOutboundChannel(registration);
        registration.interceptors(new SocketChannelInteceptor());
        }
```

#### 3.5.2 Session

Http Session, is defined as a series of related browser requests that come from the same client during a certain time
period. Session tracking ties together a series of browser requests—think of these requests as pages—that may have some
meaning as a whole, such as a shopping cart application.

Session will be created by `HttpServletRequest` as following:
```java
public servletRequest(HttpServletRequest request){
        request.getSession();
        //Returns the current session associated with this request, 
        // or if the request does not have a session, creates one.
        request.getSession(false);
        //Returns the current session, if not, return Null
        request.getSession(true);
        //Returns the current session, if not, create one
        }
```

Session can be easily approached by `HttpSession` as controller parameter

```java
@GetMapping
public sessionController(HttpSession httpsession){
        httpsession.getID()
        //get sessionID
        httpsession.setAttributes("name",value);
        //add attributes in this session
        httpsession.getAttributes("name");
        //get pre-saved attributes from this session 
        }
```

#### 3.5.3 Handshake Interceptor

By adding HandshakeInterceptor,one can prevent user's entering from unauthorized condition, note that
HandshakeInterceptor can be registered directly with Endpoint.

```java
//Java Spring @Override registerStompEndpoints
StompEndpointRegistry
        .addEndpoint("/endpoint_url")
        .addInterceptors(new Interceptor())
        .withSockJS();
```

The HandshakeInterceptor, which has two method to override: `beforeHandshake` and `afterHandshake`. In `beforeHandshake`
, we can also fetch necessary information and put them into
`Map<String, Object> attributes`, and get the value at other position such as
`StompHeaderAccessor.getSessionAttribute().get()`.

For session id, as we mentioned in
[3.0.2 Apache Http Components Library](#302-apache-http-components-library), since only `ServletServerHttpRequest` has
method ".getServletRequest()", but the override handshake are using `ServerHttpRequest` which does not contain Servlet
information, as well as it's rather impossible to get `HttpServletRequest`
from `ServerHttpRequest`, we need to firstly convert `ServerHttpRequest` to `ServletServerHttpRequest`.

```java
@Override
public boolean beforeHandshake(ServerHttpRequest request,ServerHttpResponse response,WebSocketHandler wsHandler,Map<String, Object> attributes)throws Exception{
        if(request instanceof ServletServerHttpRequest){
        //if request exist
        ServletServerHttpRequest servletServerHttpRequest=(ServletServerHttpRequest)request;
        //get ServletServerHttpRequest from ServerHttpRequest
        HttpSession session=servletServerHttpRequest.getServletRequest().getSession();
        //get Session from ServletRequest
        String sessionId=session.getId();
        //Get Session id from Session
        attributes.put("sessionID",sessionId);
        //Add sessionID into attributes
        }
        return true;
        }
```

and at any four events, the listener can get SessionID from `StompHeaderAccessor` by

```java
StompHeaderAccessor headerAccessor=StompHeaderAccessor.wrap(event.getMessage());
        headerAccessor.getSessionAttributes().get("sessionID");
```

## 4. Game Server Design

There are normally two ways to design game server:

* **Local Player Hosted Gamer Servers**, server run client side, and game communication throw "server-to-server", for
  example, Minecraft. Each server holds a game session to allow other server as players to join in.
* **Cloud Game Servers**, server hold remotely

We choose Cloud Game server approaches since web game client as browsers, and connected to our Spring framework server.

There are two ways of connections between server and clients:

* **Non-Persistent Connections**, connection exists only if data need to be transfered, for example, send a email.
* **Persistent Connections**, server client will keep connected, unless it requires disconnect.

Obviously, web page use non-persistent connection, while `WebSocket` applications use **persistent connection** in a
game session. In multiplayer's game server, after user entering the game, we must continuously manage each player.

### 4.1 Create Game
Once client post create game, we'd create a unique GameID, add this game into database.
If client join his created game, then add this unique GameID to his session.
### 4.2 Join Game


### 4.3 In Game

A playerDataDTO must be provided to transfer player's data through json.

On Server Side:

1. After player is OnConnect, server should give player a player unique id to represent player in this game session,
   this unique id should be sent back to client for reference.
2. OnMessage to retrieves message through playerDataDTO
3. OnClose when client disconnects, cleanup and remove this player.

On Client Side:

1. Client request Websocket Connect to Server. Check connections and error response(not connected etc.).
2. provide onMessage method, get unique player ID dispatched by Server. Parse Server instruction
3. provide update methods, when any update happened on client side, send current state to Server.
4. provide OnClose method, when server side is disconnected


##5. Game Client Design
