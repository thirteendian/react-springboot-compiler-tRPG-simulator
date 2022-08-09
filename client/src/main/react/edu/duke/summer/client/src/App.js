import React, {Component} from 'react';
// import axios from "axios";
import {BrowserRouter as Router} from 'react-router-dom';
import "./App.css"
import PageIndexBeforeLogin from "./pages/PageIndexBeforeLogin";

class App extends Component {


    // getUserInformation = () => {
    //     axios.get('http://localhost:12345/')
    //         .then(
    //             response => {
    //                 console.log("success", response.data);
    //             },
    //             error => {
    //                 console.log("error", error);
    //             }
    //         )
    // }
    state={sessionID:""};

    componentDidMount() {
        if (this.state.sessionID==="") {
            const reqBody = {
                username: "admin@duke.edu",
                password: "pass"
            };
            fetch("http://localhost:12345/login", {
                headers: {"Content-Type": "application/json"},
                method: "post",
                body: JSON.stringify(reqBody)
            }).then(
                (response) => Promise.all([response.json(), response.headers]))
                .then(
                    ([body, headers]) => {
                        this.setState({sessionID:headers.get("authorization")})
                    }
                )
        }

    }

    componentDidUpdate(prevProps, prevState, snapshot) {
    }

    render() {
        console.log(this.state.sessionID);
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
