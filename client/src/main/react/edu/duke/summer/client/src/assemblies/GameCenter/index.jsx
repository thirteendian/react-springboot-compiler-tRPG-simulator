import React, {useEffect, useState} from 'react';
import MyObjectInfo from "../../components/MyObjectInfo";
import OnClickButton from "../../components/OnClickButton"
import UserService from "../../services/user.service";
import {Client} from "@stomp/stompjs";
import authHeader from "../../services/auth-header";

export default function Index (){
    // const[gameInfo,setGameInfo] = useState('');
    const [message,setMessage] = useState("");


    useEffect(()=>{
        const game = JSON.parse(localStorage.getItem('game'))
        UserService.startGame(game.gameId).then(
            response=>{
                localStorage.setItem("objectInfo", JSON.stringify(response.data.objects));
                localStorage.setItem("functionInfo", JSON.stringify(response.data.functions));
                console.log(response.data)
            },
            error=>{
                const resMessasge = (error.response && error.response.data && error.response.data.message) || error.message || error.toString();
                setMessage(resMessasge);
            }
        )
    })
        return (
            <div>
                <MyObjectInfo/>
                {/*<OnClickButton className={"onClickButton_createObject3"} onClick={onSend}>test</OnClickButton>*/}
            </div>
        );

}
