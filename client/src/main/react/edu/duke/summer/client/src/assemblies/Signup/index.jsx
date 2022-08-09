import React, {Component} from 'react';
import Header from "../../components/Header";
import InputText from "../../components/InputText";
import MyNavLink from "../../components/MyNavLink";
import InputPassword from "../../components/InputPassword";

class Index extends Component {
    state = {
        state_email: "",
        state_firstname: "",
        state_surname: "",
        state_username: "",
        state_password: "",
        state_reenter: "",
    }

    onEmailChange=(event)=>{
        this.setState({state_email: event.target.value})

    };
    onFirstNameChange=(event)=>{
        this.setState({state_firstname: event.target.value})

    };
    onSurnameChange=(event)=>{
        this.setState({state_surname: event.target.value})

    };
    onUsernameChange=(event)=>{
        this.setState({state_username: event.target.value})

    };
    onPasswordChange=(event)=>{
        this.setState({state_password: event.target.value})

    };
    onReEnterPasswordChange=(event)=>{
        this.setState({state_reenter: event.target.value})

    };
    onSubmit=()=>{

    };
    render() {
        return (
            <div>
                <Header className={"header_dice_rolling_game"}>Dice Rolling Game</Header>

                <Header className={"header_signup"}>Signup</Header>

                <Header className={"header_signup_email"}>Email:</Header>
                <InputText className={"input_signup_email"} onChange={this.onEmailChange}
                           placeholder={"Enter..."}/>

                <Header className={"header_signup_firstname"}>FirstName:</Header>
                <InputText className={"input_signup_firstname"} onChange={this.onFirstNameChange}
                           placeholder={"Enter..."}/>

                <Header className={"header_signup_surname"}>Surname:</Header>
                <InputText className={"input_signup_surname"} onChange={this.onSurnameChange}
                           placeholder={"Enter..."}/>

                <Header className={"header_signup_username"}>Username:</Header>
                <InputText className={"input_signup_username"} onChange={this.onUsernameChange}
                           placeholder={"Enter..."}/>

                <Header className={"header_signup_password"}>Password:</Header>
                <InputPassword className={"input_signup_password"} onChange={this.onPasswordChange}
                           placeholder={"Enter..."}/>

                <Header className={"header_signup_reEnterPassword"}>Re-Enter:</Header>
                <InputPassword className={"input_signup_reEnter"} onChange={this.onReEnterPasswordChange}
                           placeholder={"Enter..."}/>

                <Header className={"header_signup_upload_your_profile"}>Upload Profile:</Header>

                <MyNavLink className={"myNavLink_signup_signup"} onClick={this.onSubmit} to={"/"}>Sign up</MyNavLink>
                <MyNavLink className={"myNavLink_signup_back"} to={"/"}>Back</MyNavLink>

            </div>
        );
    }
}
export default Index;