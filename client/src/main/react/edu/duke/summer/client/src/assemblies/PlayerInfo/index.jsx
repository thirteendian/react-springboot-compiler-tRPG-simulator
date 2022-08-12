import React, {Component} from 'react';
import Header from "../../components/Header";
import MyNavLink from "../../components/MyNavLink";
import "./index.css";

class Index extends Component {
    state = {unfold: false};
    unFoldPlayerInfo = () => {
        this.setState({unfold: !this.state.unfold})
    }

    render() {
        const {unfold} = this.state;
        return (
            <div onClick={this.unFoldPlayerInfo}>
                {unfold && (
                    <div className={"playerInfo_unfold"}>
                        <Header className={"header_playerInfo_firstName"}>First Name: Yuxuan</Header>
                        <Header className={"header_playerInfo_lastName"}>Last Name: Yang</Header>
                        <Header className={"header_playerInfo_Email"}>Email: yy340@duke.edu</Header>
                        <MyNavLink className={"myNavLink_playerInfo_edit"} to={"/"}>Edit</MyNavLink>
                        <MyNavLink className={"myNavLink_playerInfo_logout"} to={"/"}>Logout</MyNavLink>
                    </div>
                )}
                {!unfold &&(
                    <div className={"playerInfo_default"}>

                    </div>
                )}

                <Header className={"header_playerInfo"}>Yuxuan Yang</Header>
            </div>
        );
    }
}

export default Index;