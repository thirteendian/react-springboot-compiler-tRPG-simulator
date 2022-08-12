import React, {Component} from 'react';
import "./index.css";
import Header from "../../components/Header";
import InputText from "../../components/InputText";
import InputFile from "../../components/InputFile";
import axios from "axios";
import MyNavLink from "../../components/MyNavLink";

class Index extends Component {
    state = {
        selectedFile:'',
        gamename: "",
        numplayer: "0",
    };

    onFileChange = (event) => {
        this.setState({selectedFile: event.target.files[0]});
    }

    onFileClick = async () => {
        const url = "http://localhost:12345/test/file";
        const object = JSON.stringify( {
            gamename: this.state.gamename,
            numplayer: this.state.numplayer,
        })
        console.log(object)
        const response = await axios.post(url, {});
        const axiosValue = response.data;
        // const fieldType = new Map(Object.entries(JSON.parse(axiosValue).fieldType));
        console.log(axiosValue);
    }

    onGameNameChange = (event) => {
        this.setState({gamename: event.target.value})
    }
    onnumberOfPlayerChange = (event) => {
        this.setState({numplayer: event.target.value})
    }
    onSubmit

    render() {
        return (
            <div>
                <Header className={"header_dice_rolling_game"}>Dice Rolling Game</Header>
                <Header className={"header_signup"}>Create Game</Header>
                <Header className={"header_signup_email"}>Game Name:</Header>
                <InputText className={"input_signup_email"} onChange={this.onGameNameChange}
                           placeholder={"Enter..."}/>
                <Header className={"header_signup_firstname"}>Number Of Player:</Header>
                <InputText className={"input_createGame_numberOfPlayer"} onChange={this.onnumberOfPlayerChange}
                           placeholder={"Enter..."}/>
                <InputFile classNameInput={"inputFile_createGame"} classNameButton={"inputFile_createGame_button"}/>
                <MyNavLink className={"myNavLink_createGame"} to={"/user/createObject"}>Create Game</MyNavLink>
            </div>
        );
    }
}

export default Index;