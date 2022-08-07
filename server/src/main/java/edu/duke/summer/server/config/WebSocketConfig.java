package edu.duke.summer.server.config;

import edu.duke.summer.server.inteceptor.HttpHandShakeInteceptor;
import edu.duke.summer.server.inteceptor.SocketChannelInteceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
@EnableScheduling
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {


    /**
     * Config Message Agent
     * .enableSimpleBroker: Client subscribe destination prefix(Server send to destination prefix)
     * .setApplicationDestinationPrefixes: Client send to Server destination prefix
     *
     * @param config
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //Return OUTPUT message destination, example: "/topic" as socketJs subscribe to "/topic/greetings"
        config.enableSimpleBroker("/objectcreate", "/admin");
        //The prefix of @MessageMapping , example: /app/hello as @MessageMapping(/hello)
        config.setApplicationDestinationPrefixes("/app", "/admin");
    }

    //SockJS fallback Options, if WebSocket is not available

    /**
     * Regitration Endpoint
     * Connect to endpoint to send or receive information
     * StompWebSocketEndpointRegistration.setHandshakeHandler(...):
     * set to exist handler bean
     * StompWebSocketEndpointRegistration.setAllowedOrigins(String):
     * Set the origins for which cross-origin requests are allowed from a browser
     * By default, no origins are allowed.
     * Note when SockJS is enabled and origins are restricted,
     * transport types that do not allow to check request origin (Iframe based transports) are disabled.
     * As a consequence, IE 6 to 9 are not supported when origins are restricted.
     * StompWebSocketEndpointRegistration.addInterceptors:
     * Configure the HandshakeInterceptor's to use.
     * StompWebSocketEndpointRegistration.withSocketJS(): support SocketJS
     *
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket")
                .withSockJS();
        registry.addEndpoint("/admin_endpoint")
                .addInterceptors(new HttpHandShakeInteceptor())
                .withSockJS();
    }


    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        WebSocketMessageBrokerConfigurer.super.configureClientInboundChannel(registration);
        registration.interceptors(new SocketChannelInteceptor());
    }

    @Override
    public void configureClientOutboundChannel(ChannelRegistration registration) {
        WebSocketMessageBrokerConfigurer.super.configureClientOutboundChannel(registration);
        registration.interceptors(new SocketChannelInteceptor());
    }
}
