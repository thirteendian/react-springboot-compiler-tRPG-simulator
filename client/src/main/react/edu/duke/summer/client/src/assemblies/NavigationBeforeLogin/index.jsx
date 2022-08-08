import React, {Component} from 'react';
import MyNavLink from "../../components/MyNavLink";

class Index extends Component {
    render() {
        return (
            <div>

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