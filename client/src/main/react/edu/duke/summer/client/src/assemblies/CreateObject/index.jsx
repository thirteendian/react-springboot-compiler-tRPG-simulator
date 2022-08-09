import React, {Component} from 'react';
import"./index.css";
import Header from "../../components/Header";

class Index extends Component {
    objectRollwithmod = async () => {
        const url = "http://localhost:12345/test/rollwithmod";
        const response = await axios(url);
        const axiosValue = response.data;
        console.log(axiosValue);
    }
    objectNewType = async () => {
        const url = "http://localhost:12345/test/newtype";
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
    objectTest = async () => {
        const url = "http://localhost:12345/test/testtype";
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
    render() {
        return (
            <div>
                <Header className={"header_dice_rolling_game"}>Dice Rolling Game</Header>
                <button className={"createObject_A"} onClick={this.objectRollwithmod}>rollwithmod</button>
                <button className={"createObject_B"} onClick={this.objectNewType}>newType</button>
                <button className={"createObject_C"} onClick={this.objectTest}>test</button>

                <div className="objectGenerateBackground">

                </div>
            </div>
        );
    }
}

export default Index;