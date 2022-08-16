import React, {Component, Fragment, useEffect, useState} from 'react';
import "./index.css";
import Header from "../../components/Header";
import ObjectButton from "../../components/ObjectButton";
import MyNavLink from "../../components/MyNavLink";
import OnClickButton from "../../components/OnClickButton";
import List from "../../components/List";
import InputText from "../../components/InputText";
import UserService from "../../services/user.service";

export default function Index() {

    const [objectInfo, setObjectInfo] = useState(JSON.parse(localStorage.getItem("objectInfo")));
    const [message, setMessage] = useState("");
    const [which,setWhich] = useState(0);
    const [one,setone]=useState(false);
    const [two,settwo]=useState(false);
    const [three,setthree]=useState(false);

    // useEffect(()=>{
    //
    //     console.log(objectInformation)
    // })
    const test= ()=>{
        console.log(objectInfo)
    }
    const listItems = objectInfo.map((each)=>
        <li>
            <ObjectButton>{each.objectName}</ObjectButton>
        </li>
    );
    const onOne=()=>{
        setone(true);
        settwo(false);
        setthree(false)
    }
    const onTwo=()=>{
        setone(false);
        settwo(true);
        setthree(false)
    }
    const onThree=()=>{
        setone(false);
        settwo(false);
        setthree(true)
    }

    return (
        <div>
            <Header className={"header_dice_rolling_game"}>Create Object</Header>
            {/*<div>*/}
            {/*    <ul>*/}
            {/*        {listItems}*/}
            {/*    </ul>*/}
            {/*</div>*/}

            <OnClickButton className={"onClickButton_createObject1"} onClick={onOne}>newType</OnClickButton>
            <OnClickButton className={"onClickButton_createObject2"} onClick={onTwo}>test</OnClickButton>
            <OnClickButton className={"onClickButton_createObject3"} onClick={onThree}>rollwithmod</OnClickButton>
            {/*<div className="objectGenerateBackground">*/}
                {one && (
                    <Fragment>
                        <Header className={"header_newType1"}>a: </Header>
                        <Header className={"header_newType2"}>b: </Header>
                        <Header className={"header_newType3"}>c: </Header>
                        <InputText className={""} placeholder={"Insert A"}/>
                    </Fragment>
                )}
            {/*</div>*/}


        </div>

    )
}
