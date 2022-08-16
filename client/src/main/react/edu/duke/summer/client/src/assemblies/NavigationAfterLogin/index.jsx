import React, {useCallback, useEffect} from 'react';
import Header from "../../components/Header";
import MyNavLink from "../../components/MyNavLink";
import PlayerInfo from "../PlayerInfo";
import AuthService from "../../services/auth.service";
import {useNavigate} from "react-router-dom";

export default function Index() {
    let navigate = useNavigate();
    const mountRedirect = useCallback(()=>{
        navigate("/")
    },[navigate]);

    useEffect(()=>{
        if(AuthService.getUserDetails()===null){
            mountRedirect();
        }
    });

    return (
        <div>
            <Header className={"header_dice_rolling_game"}>Dice Rolling Game</Header>

            <MyNavLink className={"myNavLink_createGame1"} to={"/user/createGame"}>
                Create Game
            </MyNavLink>

            <MyNavLink className={"myNavLink_joinGame"} to={"/user/joinGame"}>
                Join Game
            </MyNavLink>

            <MyNavLink className={"myNavLink_loadGame"} to={"/user/LoadGame"}>
                Load Game
            </MyNavLink>

            <MyNavLink className={"myNavLink_logout"} onClick={AuthService.logout} to={"/"}>
                Log Out
            </MyNavLink>

            <PlayerInfo/>

        </div>
    );
}