import React, {Component} from 'react';
import {NavLink, Route} from "react-router-dom";
import "./index.css";

export  default class Index extends Component {
    render() {
        return (
            <div>

                {/*<div className="index_before_login_dukeshibboleth_button_container">*/}
                {/*    <form th:action="@{/signup}" method="get">*/}
                {/*        <input type="submit" className="index_before_login_button_font" value="Duke Shibboleth"/>*/}
                {/*    </form>*/}
                {/*</div>*/}

                {/*<div className="index_before_login_google_button_container">*/}
                {/*    <form th:action="@{/signup}" method="get">*/}
                {/*        <input type="submit" className="index_before_login_button_font" value="Google Login"/>*/}
                {/*    </form>*/}
                {/*</div>*/}

                {/*<div className="index_before_login_createyourcount_button_container">*/}
                {/*    <form th:action="@{/signup}" method="get">*/}
                {/*        <input type="submit" className="index_before_login_button_font" value="Create Account"/>*/}
                {/*    </form>*/}
                {/*</div>*/}
            </div>
        );
    }
}