import React, {Component} from 'react';
import MyNavLink from "../../components/MyNavLink";
import Header from "../../components/Header";

class Index extends Component {
    render() {
        return (
            <div>
                <Header className={"header_dice_rolling_game"}>Dice Rolling Game</Header>

                <MyNavLink className={"myNavLink_login"} to={"/login"}>
                    Login
                </MyNavLink>

                <MyNavLink className={"myNavLink_signup"} to={"/signup"}>
                    Sign Up
                </MyNavLink>

            </div>
        );
    }
}

export default Index;