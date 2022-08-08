import React, {Component} from 'react';
import axios from "axios";
import { BrowserRouter as Router} from 'react-router-dom';
import "./App.css"
import PageIndexBeforeLogin from "./pages/PageIndexBeforeLogin";

class App extends Component {


    getUserInformation = () => {
        axios.get('http://localhost:12345/')
            .then(
                response => {
                    console.log("success", response.data);
                },
                error => {
                    console.log("error", error);
                }
            )
    }

    render() {
        return (
            <Router>
                <div className="main_container">
                    <PageIndexBeforeLogin/>
                </div>
            </Router>
        );
    }
}

export default App;
