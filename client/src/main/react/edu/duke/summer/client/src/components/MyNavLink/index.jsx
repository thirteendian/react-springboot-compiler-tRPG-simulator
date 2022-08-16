import React from 'react';
import {NavLink} from "react-router-dom";
import "./index.css";

export default function Index(props){
        return (
            <NavLink className={props.className} to={props.to} onClick={props.onClick} >
                {props.children}
            </NavLink>
        );
}
