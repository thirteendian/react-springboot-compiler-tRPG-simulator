import React, {Component} from 'react';
import HeaderDiceRollingGame from "../../components/HeaderDiceRollingGame";
import ButtonNavigation from "../../components/ButtonNavigation";
import "./index.css";
import {NavLink,Route,Routes} from "react-router-dom";
import FormLogin from "../../components/FormLogin";


class Index extends Component {
    render() {
        return (
            <div>
                <div className="bg_chapel">
                    <HeaderDiceRollingGame content={"Dice Rolling Game"}/>
                    <NavLink className="index_before_login_login_button_container" to={"/login"} >
                        Login
                    </NavLink>
                    <Routes>
                        <Route path="/login" element={<FormLogin/>}/>
                    </Routes>
                </div>
            </div>
        );
    }
}

export default Index;