import React from 'react';
import "./index.css";
import MyNavLink from "../../components/MyNavLink";

export default function Index()
{

    return (
        <div  className={"myObjectInfo"}>
            <MyNavLink className={"myNavLink_gameCenter_createObject"} to={"/user/createObject"}>
                create
            </MyNavLink>
        </div>
    );
}

