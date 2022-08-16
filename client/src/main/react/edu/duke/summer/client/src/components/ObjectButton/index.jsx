import React, {Component} from 'react';
import "./index.css";

export default function Index(props) {
    return (
        <button className={"objectButton"}
                onClick={props.onClick}>{props.children}</button>
    );
}
