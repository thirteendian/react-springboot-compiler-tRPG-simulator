import React, {Component} from 'react';
import Header from "../Header";
import InputText from "../InputText";

class Index extends Component {
    render() {
        return (
            <li>
                <Header className={"header_createObject_a"}>Test Field</Header>
                <InputText className={"input_createObject_Rollwithmod"} placeholder={"Enter..."}/>
            </li>
        );
    }
}

export default Index;