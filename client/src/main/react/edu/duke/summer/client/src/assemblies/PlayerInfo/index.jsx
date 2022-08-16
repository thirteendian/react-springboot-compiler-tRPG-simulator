import React, {useState} from 'react';
import Header from "../../components/Header";
import MyNavLink from "../../components/MyNavLink";
import "./index.css";
import AuthService from "../../services/auth.service";

export default function Index() {
    const [unfold, setunfold] = useState(false);
    const [userInfo]= useState(AuthService.getUserDetails());
    const unFoldPlayerInfo = () => {
        setunfold(!unfold);
    }

    return (
        <div onClick={unFoldPlayerInfo}>
            {unfold && (
                <div className={"playerInfo_unfold"}>
                    <Header className={"header_playerInfo_firstName"}>First Name: {userInfo.firstname}</Header>
                    <Header className={"header_playerInfo_lastName"}>Last Name: {userInfo.lastname}</Header>
                    <Header className={"header_playerInfo_Email"}>Email: {userInfo.email}</Header>
                    <MyNavLink className={"myNavLink_playerInfo_edit"} to={"/"}>Edit</MyNavLink>
                    <MyNavLink className={"myNavLink_playerInfo_logout"} to={"/"} onClick={AuthService.logout}>Logout</MyNavLink>
                </div>
            )}
            {!unfold && (
                <div className={"playerInfo_default"}>
                </div>
            )}

            <Header className={"header_playerInfo"}>{userInfo.firstname} {userInfo.lastname}</Header>
        </div>
    );
}
