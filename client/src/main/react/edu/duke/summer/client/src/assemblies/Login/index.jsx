import React, {Component} from 'react';
import Header from "../../components/Header";
import InputText from "../../components/InputText";
import InputCheckBox from "../../components/InputCheckBox";
import MyNavLink from "../../components/MyNavLink";
import InputPassword from "../../components/InputPassword";

class Index extends Component {
    state = {
        state_username: "",
        state_password: "",
        state_rememberme: false
    }

    onUsernameChange = (event) => {
        this.setState({state_username: event.target.value})
    }
    onPasswordChange = (event) => {
        this.setState({state_password: event.target.value})
    }
    onRememberMeChange = (event) => {
        this.setState({state_rememberme: !this.state.state_rememberme})
    }

    onSubmit = () => {
        const {state_username, state_password, state_rememberme} = this.state
        const pairUsernamePassword = JSON.stringify(
            {
                username: state_username,
                password: state_password,
                remember_me: state_rememberme
            })
        console.log(pairUsernamePassword);
    }


    render() {
        return (
            <div>
                <Header className={"header_login"}>Login</Header>

                <Header className={"header_login_username"}>Email:</Header>
                <InputText className={"input_login_username"} onChange={this.onUsernameChange}
                           placeholder={"Enter Email"}/>

                <Header className={"header_login_password"}>PASSWORD:</Header>
                <InputPassword className={"input_login_password"} onChange={this.onPasswordChange}
                           placeholder={"Enter Password"}/>

                <Header className={"header_rememberme"}>Remember me:</Header>
                <InputCheckBox className={"inputCheckBox_login_rememberme"} onChange={this.onRememberMeChange}/>
                <MyNavLink className={"myNavLink_login_login"} onClick={this.onSubmit} to={"/"}>Login</MyNavLink>
                <MyNavLink className={"myNavLink_login_back"} to={"/"}>Back</MyNavLink>
            </div>
        );
    }
}

export default Index;