import React, {Component, Fragment, useCallback, useEffect, useState} from 'react';
import "./index.css";
import Header from "../../components/Header";
import ObjectButton from "../../components/ObjectButton";
import OnClickButton from "../../components/OnClickButton";
import {nanoid} from "nanoid";
import {useNavigate} from "react-router-dom";
import InputCheckBox from "../../components/InputCheckBox";

export default function Index() {
    const [objectInfo, setObjectInfo] = useState(JSON.parse(localStorage.getItem("objectInfo")));
    const [message, setMessage] = useState("");
    const [currentField, setCurrectField] = useState([]);
    const navigate = useNavigate();
    useEffect(() => {
        //set each object with id={uuid}
        objectInfo.map((each) => {
            each.id = nanoid().toString()
        })
    }, [])


    const objectButtonOnClick = (fields) => {
        return () => {
            setCurrectField(fields);
            console.log(fields);
        }
    }

    const listItems = objectInfo.map((each) =>
        <li key={nanoid()}>
            <ObjectButton onClick={objectButtonOnClick(each.fields)}>{each.objectName}</ObjectButton>
        </li>
    );

    const createNestedStructure = (each,nestedStructure) => {
        const k = each.objectFieldTypeDto.k;
        if (k==="option"){
            nestedStructure.push(<InputCheckBox className={"inputCheckBox_objectCreate"}/>)
        }
       return nestedStructure
    }
    const listFields = currentField.map((each) => {
            let nestedStructure = [<Header className={"header_fieldName"}>{each.fieldName}: </Header>];
            nestedStructure = createNestedStructure(each,nestedStructure);
            nestedStructure.push(<hr/>)
            return <li key={each.id}>
                {nestedStructure}
            </li>
        }
    )

    const onClickBack = () => {
        navigate("/user/gameCenter");
    }
    const onClickCreate = () => {

    }

    return (
        <div>
            <Header className={"header_dice_rolling_game"}>Create Object</Header>

            <div className={"objectMenuBackground"}>
                <ul>
                    {listItems}
                </ul>
            </div>

            <div className="objectGenerateBackground">
                <ul>
                    {listFields}
                </ul>
            </div>

            <OnClickButton className={"onClickButton_game_right"} onClick={onClickCreate}>Create</OnClickButton>
            <OnClickButton className={"onClickButton_game_left"} onClick={onClickBack}>Back</OnClickButton>

        </div>

    )
}
