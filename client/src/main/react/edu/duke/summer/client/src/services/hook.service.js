//This is a helper collections of hooks to be used in Class Component
//When these functions are imported to the Component,
//the following hooks will be added to it's props

import {useNavigate} from "react-router-dom";
import {Component} from "react";

export const withRouter = (Component) => {
    const Wrapper = (props) => {
        const navigate = useNavigate();
        return (
            <Component navigate={navigate} {...props}/>
        );
    }
    return Wrapper;
}