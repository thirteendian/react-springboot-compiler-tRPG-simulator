import React, {useCallback, useEffect, useState} from 'react';
import Header from "../../components/Header";
import InputText from "../../components/InputText";
import InputCheckBox from "../../components/InputCheckBox";
import MyNavLink from "../../components/MyNavLink";
import InputPassword from "../../components/InputPassword";
import OnClickButton from "../../components/OnClickButton";
import AuthService from "../../services/auth.service";
import {useNavigate} from "react-router-dom";

export default function Index() {
    const [state_username, setstate_username] = useState("");
    const [state_password, setstate_password] = useState("");
    const [state_rememberme, setstate_rememberme] = useState(false);
    const [loading, setloading] = useState(false);
    const [message, setmessage] = useState("");

    const onUsernameChange = (event) => {
        setstate_username(event.target.value);
    }
    const onPasswordChange = (event) => {
        setstate_password(event.target.value);
    }
    const onRememberMeChange = () => {
        setstate_rememberme(!state_rememberme)
    }
    let navigate = useNavigate();
    const mountRedirect = useCallback(() => {
        navigate("/")
    }, [navigate])

    useEffect(() => {
        if (AuthService.getUserDetails() != null) {
            mountRedirect();
        }
    })
    const onSubmit = () => {
        setloading(true)
        AuthService.login(state_username, state_password)
            .then(
                response => {
                    console.log(response.data)
                    if (response.data.token) {
                        localStorage.setItem("user", JSON.stringify(response.data));
                    }
                    navigate("/user/index_after_login");
                    return response.data;
                },
                error => {
                    const resMessage = (error.response && error.response.data && error.response.data.message) || error.message || error.toString();
                    setloading(false);
                    setmessage(resMessage);
                }
            );
        setloading(false);
    }

    return (
        <div>
            <Header className={"header_dice_rolling_game"}>Dice Rolling Game</Header>

            <Header className={"header_login"}>Login</Header>
            {
                message && (
                    <Header className={"header_login_error"}>{message}</Header>
                )
            }

            <Header className={"header_login_username"}>USERNAME:</Header>
            <InputText className={"input_login_username"} onChange={onUsernameChange}
                       placeholder={"Enter Username"}/>

            <Header className={"header_login_password"}>PASSWORD:</Header>
            <InputPassword className={"input_login_password"} onChange={onPasswordChange}
                           placeholder={"Enter Password"}/>
            <Header className={"header_rememberme"}>Remember me:</Header>
            <InputCheckBox className={"inputCheckBox_login_rememberme"} onChange={onRememberMeChange}/>
            <OnClickButton className={"onClickButton_login_login"} onClick={onSubmit}
                           disabled={loading}>Login</OnClickButton>
            <MyNavLink className={"myNavLink_login_back"} to={"/"}>Back</MyNavLink>
        </div>
    );
}
