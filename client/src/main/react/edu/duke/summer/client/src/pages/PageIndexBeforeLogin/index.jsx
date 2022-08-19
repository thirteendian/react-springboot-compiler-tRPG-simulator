import React, {Component} from 'react';
import {Route, Routes} from "react-router-dom";
import "./index.css";
import Header from "../../components/Header";
import Login from "../../assemblies/Login";
import NavigationBeforeLogin from "../../assemblies/NavigationBeforeLogin";
import Signup from "../../assemblies/Signup";

class Index extends Component {

    render() {
        return (
            <div>
                <div className="bg_chapel">
                    <Header className={"header_dice_rolling_game"}>Dice Rolling Game</Header>
                    <Routes>
                        <Route path="/" element={<NavigationBeforeLogin/>}/>
                        <Route path="/login" element={<Login/>}/>
                        <Route path="/signup" element={<Signup/>}/>
                    </Routes>
                </div>
            </div>
        );
    }
}

export default Index;