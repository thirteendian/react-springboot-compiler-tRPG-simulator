import React, {Component} from 'react';
import "./index.css";
import Header from "../../components/Header";
import List from "../../components/List";
import InputText from "../../components/InputText";

class Index extends Component {
    state = {
        rollwithmod: false,
        newtype: false,
        test: false,
        toarray: [
            {id: "001", name: "At Moment"},
            {id: "002", name: "Yesterday"},
            {id: "003", name: "Tomorrow"},
        ]
    }

    objectRollwithmod = () => {
        this.setState({rollwithmod: true})
        this.setState({newtype: false})
        this.setState({test: false})

        console.log(this.state.rollwithmod);
    }
    objectNewType = () => {
        this.setState({rollwithmod: false})
        this.setState({newtype: true})
        this.setState({test: false})
    }
    objectTest = () => {
        this.setState({rollwithmod: false})
        this.setState({newtype: false})
        this.setState({test: true})
    }

    render() {
        const {rollwithmod, newtype, test,toarray} = this.state;
        return (
            <div>
                <Header className={"header_dice_rolling_game"}>Dice Rolling Game</Header>
                <button className={"createObject_A"} onClick={this.objectRollwithmod}>rollwithmod</button>
                <button className={"createObject_B"} onClick={this.objectNewType}>newType</button>
                <button className={"createObject_C"} onClick={this.objectTest}>test</button>

                <div className="objectGenerateBackground">
                    {
                        rollwithmod && (
                            <div>
                                <List toarray={toarray}/>

                            </div>
                        )
                    }
                    {
                        newtype && (
                            <div>

                            </div>
                        )
                    }
                    {
                        test && (
                            <div>

                            </div>
                        )
                    }
                </div>

            </div>

        )
    }
}

export default Index;