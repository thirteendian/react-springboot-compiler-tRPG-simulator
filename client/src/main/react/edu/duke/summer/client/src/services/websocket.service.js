import * as SockJS from "sockjs-client";
const ENDPOINT_URL = "http://localhost:12345/player-endpoint";
const GAME_ACTION_URL = "http://localhost:12345/gameServerReceiver/gameAction";

let stompClient = null;



export default class WebsocketService{
    // static connect(){
    //     const user = JSON.parse(localStorage.getItem("user"));
    //     let socket = new SockJS(ENDPOINT_URL);
    //     stompClient =Stomp.over(socket);
    //     stompClient.connect({},
    //         ()=>{
    //             stompClient.subscribe("/gameServerCommunicator/"+user.username);
    //             })
    //
    // }
    // static send(){
    //     stompClient.send(GAME_ACTION_URL,{}, {})
    // }
}