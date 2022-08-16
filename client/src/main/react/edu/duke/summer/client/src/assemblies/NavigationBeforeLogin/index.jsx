import React, {useCallback, useEffect} from 'react';
import MyNavLink from "../../components/MyNavLink";
import Header from "../../components/Header";
// import {withRouter} from "../../services/hook.service";
import AuthService from "../../services/auth.service";
import {useNavigate} from "react-router-dom";

export default function Index() {
    let navigate = useNavigate();
    const mountRedirect = useCallback(
        ()=>navigate("/user/index_after_login"),[navigate]
    );//callback if deps has changed, can use return()=>{} inside useCallback to cleanup functions
    //navigate will update while initial render, so this will be called once with useEffect
    useEffect(() => {
        if (AuthService.getUserDetails() != null) {
            mountRedirect()
        }
    })

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

// export default withRouter(Index);