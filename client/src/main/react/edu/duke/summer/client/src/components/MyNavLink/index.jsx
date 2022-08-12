import React, {Component} from 'react';
import {NavLink} from "react-router-dom";
import "./index.css";


class Index extends Component {

    render() {
        return (
            <NavLink className={this.props.className} to={this.props.to} onClick={this.props.onClick}>
                {this.props.children}
            </NavLink>
        );
    }
}

export default Index;