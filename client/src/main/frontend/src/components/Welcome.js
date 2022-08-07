import React from "react";
import '../config.js'
import axios from 'axios';

class Welcome extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            welcome_list: ""
        };
    }

    componentDidMount() {
        let api = global.AppConfig.serverIP + "/react";
        const axios = require('axios').default;
        axios.get(api)
            .then((response) => {
                console.log(response.data);
                let tempData = response.data;
                this.setState({
                    welcome_list: tempData
                })
            })
            .catch(function (error) {
                    console.log(error);
            })
    }

    render() {
        return (
            <div>
                Welcome to page{this.state.welcome_list}
            </div>
        )
    }
}

export default Welcome;