import React, {Component} from 'react';
import Header from "../../components/Header";
import MyNavLink from "../../components/MyNavLink";
import PlayerInfo from "../PlayerInfo";

class Index extends Component {
    render() {
        return (
            <div>
                <Header className={"header_dice_rolling_game"}>Dice Rolling Game</Header>

                    <MyNavLink className={"myNavLink_createGame"} to={"/user/createGame"}>
                        Create Game
                    </MyNavLink>

                    <MyNavLink className={"myNavLink_joinGame"} to={"/user/joinGame"}>
                        Join Game
                    </MyNavLink>

                    <MyNavLink className={"myNavLink_loadGame"} to={"/user/LoadGame"}>
                        Load Game
                    </MyNavLink>

                    <MyNavLink className={"myNavLink_logout"} to={"/user/logout"}>
                        Log Out
                    </MyNavLink>

                <PlayerInfo/>

            </div>
        );
    }
}

export default Index;