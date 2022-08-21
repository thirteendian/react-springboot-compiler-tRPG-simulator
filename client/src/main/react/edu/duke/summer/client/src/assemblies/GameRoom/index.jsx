import React, {useEffect, useState} from 'react';
import "./index.css"
import {Client} from "@stomp/stompjs";
import authHeader from "../../services/auth-header";

export default function Index() {
//Received from server, pass to all following game Component
    //gameID,{String}
    //NumPlayer,{Integer}
    //playerList,[playerInfoObject:{
    //  identity: GameMaster/Player
    //  isReady:boolean(if gameMaster, null)
    //  isStart:boolean
    //
    // }]
    //
    const [gameState, setGameState] = useState("");

    const client = new Client({
        headers:authHeader(),
        brokerURL:"ws://localhost:12345/player_endpoint",
        debug:function(str){
            console.log(str);
        },
        reconnectDelay:5000,
        heartbeatIncoming:4000,
        heartbeatOutgoing:4000
    });
    client.onConnect = (frame)=>{
        client.activate();
        console.log("connected: "+frame);
    }

    return (
        <div>
            <ul>

            </ul>
        </div>
    );
}

