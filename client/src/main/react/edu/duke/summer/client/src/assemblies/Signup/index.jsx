import React, {useCallback, useEffect, useState} from 'react';
import Header from "../../components/Header";
import InputText from "../../components/InputText";
import MyNavLink from "../../components/MyNavLink";
import InputPassword from "../../components/InputPassword";
import OnClickButton from "../../components/OnClickButton";
import AuthService from "../../services/auth.service";
import {useNavigate} from "react-router-dom";

export default function Index(props) {
    const [state_email, setstate_email] = useState("");
    const [state_firstname, setstate_firstname] = useState("");
    const [state_surname, setstate_surname] = useState("");
    const [state_username, setstate_username] = useState("");
    const [state_password, setstate_password] = useState("");
    const [state_reenter, setstate_reenter] = useState("");
    const [loading, setloading] = useState(false);
    const [message, setmessage] = useState("");
    const [successful, setsuccessful] = useState(false);
    let navigate = useNavigate();
    const mountRedirect = useCallback(
        () => {
            navigate("/")
        }, [navigate]
    )
    const onSuccessRedirect = useCallback(() => {
        navigate("/")
    }, [navigate]);

    useEffect(() => {
        if (AuthService.getUserDetails() != null) {
            mountRedirect();
        }
    })
    useEffect(() => {
        if (successful) {
            const timeoutID = setTimeout(onSuccessRedirect, 1000);
            return () => {
                clearTimeout(timeoutID);
            }
        }
    })
    const onEmailChange = (event) => {
        setstate_email(event.target.value)
    };
    const onFirstNameChange = (event) => {
        setstate_firstname(event.target.value)
    };
    const onSurnameChange = (event) => {
        setstate_surname(event.target.value)
    };
    const onUsernameChange = (event) => {
        setstate_username(event.target.value)
    };
    const onPasswordChange = (event) => {
        setstate_password(event.target.value)
    };
    const onReEnterPasswordChange = (event) => {
        setstate_reenter(event.target.value)
    };
    const onSubmit = () => {
        // const {state_email, state_firstname, state_surname, state_username, state_password, state_reenter} = this.state;
        setmessage("");
        setloading(true);
        if (state_surname && state_surname && state_firstname && state_username && state_password && state_reenter) {
            if (state_password === state_reenter) {
                AuthService.signup(state_username, state_email, state_firstname, state_surname, state_password).then(
                    response => {
                        setmessage(response.data.message);
                        setsuccessful(true);
                    },
                    error => {
                        const resMessage = (error.response && error.response.data && error.response.data.message) || error.message || error.toString();
                        setmessage(resMessage);
                        setsuccessful(false);
                    }
                );
            } else {
                setmessage("The Re-Enter Password is not paired!");
                setsuccessful(false);
            }
        } else {
            setmessage("All fields must be filled!");
            setsuccessful(false);
        }
        setloading(false);
    };


    return (
        <div>
            <Header className={"header_dice_rolling_game"}>Dice Rolling Game</Header>

            <Header className={"header_signup"}>Signup</Header>

            <Header className={"header_signup_email"}>Email:</Header>
            <InputText className={"input_signup_email"} onChange={onEmailChange}
                       placeholder={"Enter..."}/>

            <Header className={"header_signup_firstname"}>FirstName:</Header>
            <InputText className={"input_signup_firstname"} onChange={onFirstNameChange}
                       placeholder={"Enter..."}/>

            <Header className={"header_signup_surname"}>Surname:</Header>
            <InputText className={"input_signup_surname"} onChange={onSurnameChange}
                       placeholder={"Enter..."}/>

            <Header className={"header_signup_username"}>Username:</Header>
            <InputText className={"input_signup_username"} onChange={onUsernameChange}
                       placeholder={"Enter..."}/>

            <Header className={"header_signup_password"}>Password:</Header>
            <InputPassword className={"input_signup_password"} onChange={onPasswordChange}
                           placeholder={"Enter..."}/>

            <Header className={"header_signup_reEnterPassword"}>Re-Enter:</Header>
            <InputPassword className={"input_signup_reEnter"} onChange={onReEnterPasswordChange}
                           placeholder={"Enter..."}/>

            <Header className={"header_signup_upload_your_profile"}>Upload Profile:</Header>
            {
                message && (
                    <Header className={"header_signup_error"}>{message}</Header>
                )
            }
            <OnClickButton className={"onClickButton_signup_signup"}
                           onClick={onSubmit}
                           disabled={loading}>
                Sign up
            </OnClickButton>
            <MyNavLink className={"myNavLink_signup_back"} to={"/"}>Back</MyNavLink>

        </div>
    );

}

// export default withRouter(Index);