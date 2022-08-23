import React, {Component, Fragment, useCallback, useEffect, useState} from 'react';
import "./index.css";
import Header from "../../components/Header";
import ObjectButton from "../../components/ObjectButton";
import OnClickButton from "../../components/OnClickButton";
import {nanoid} from "nanoid";
import {useNavigate} from "react-router-dom";
import InputCheckBox from "../../components/InputCheckBox";
import InputText from "../../components/InputText";
import UserService from "../../services/user.service";


export default function Index() {
    const [objectInfo, setObjectInfo] = useState(JSON.parse(localStorage.getItem("objectInfo")));
    const [message, setMessage] = useState("");
    const [currentObjectName, setCurrentObjectName] = useState("");
    //list of fields of current object
    const [currentObjectField, setCurrectObjectField] = useState([]);
    //value of current object
    const [currentObjectFieldValue, setCurrentObjectFieldValue] = useState([]);
    const navigate = useNavigate();
    useEffect(() => {
        //set each object with id={uuid}
        objectInfo.map((each) => {
            each.id = nanoid().toString()
        })
    }, [])

    //each=one object{fields,id,objectName}
    const objectButtonOnClick = (each) => {

        //add extra field: {value:""} to current object
        const TempFields = each.fields;
        TempFields.map((eachField) => {
            eachField.value = ""
        })
        return () => {
            setCurrentObjectName(each.objectName);
            setCurrectObjectField(each.fields);
        }
    }

    //each= one object{fields,id,objectName}
    const listItems = objectInfo.map((each) =>
        //Refresh currentObject field {value:""} while onClicking
        <li key={nanoid()}>
            <ObjectButton onClick={objectButtonOnClick(each)}>{each.objectName}</ObjectButton>
        </li>
    );


    //array add button to add array
    //Add element in the pool that elemID = currentLayerElementId
    const handleOnClickArrayAdd = (currentLayerElementId) => {
        const elem = {
            entryId: nanoid(),//entryID is it's own ID
            elemId: currentLayerElementId,//elemID is each recursive structure's id
        }
        let tempCurrentObjectFieldValue = [...currentObjectFieldValue, elem]

        setCurrentObjectFieldValue(tempCurrentObjectFieldValue)
        return elem.entryId
    }
    //Delete the last element in the pool that elemID = currentLayerElementId
    const handleOnClickArrayDelete = (currentLayerElementId) => {
        let tempCurrentObjectFieldValueReverse = currentObjectFieldValue.reverse()
        //Must use >0 rather than !==0 ?
        if (tempCurrentObjectFieldValueReverse.length > 0) {
            // console.log(tempCurrentObjectFieldValueReverse.length)
            const theDeleteEntryId = tempCurrentObjectFieldValueReverse.find(x => x.elemId === currentLayerElementId).entryId
            setCurrentObjectFieldValue(tempCurrentObjectFieldValueReverse.filter(x => x.entryId !== theDeleteEntryId).reverse())
        }
    }


    //event = inputText
    //id = The input VirtualElement id should be  the same as value id
    const handleInputTextChange = (event, entryId) => {
        const tempCurrentObjectFieldValue = currentObjectFieldValue;
        //Set current value in the structure of currentObjectFieldValue
        tempCurrentObjectFieldValue.find(x => x.entryId === entryId).value = event.target.value;
        setCurrentObjectFieldValue(tempCurrentObjectFieldValue)
        console.log(tempCurrentObjectFieldValue)
    }


    //return List of Item with elemID = currentLayerElementId
    //currentLayerElemeneID = each.id
    //each = the recurrsive structure objectFieldTypeDto/elem(objectFieldTypeDto)
    const listArray = (each, currentLayerElementId) => {
        let classifiedCurrentObjectFieldValueSet = currentObjectFieldValue.reduce((classifiedCurrentObjectFieldValueSet, eachCurrentObjectFieldValue) => {
            //Select all belongs to currentElementID frame to display
            if (eachCurrentObjectFieldValue.elemId === currentLayerElementId) {
                //if k
                if (each.k === "array") {
                    currentLayerElementId = each.elem.id
                    //className={"flexbox-container"}
                    classifiedCurrentObjectFieldValueSet.push(
                        <li>
                            <div className={"flexbox-container"}>
                                <OnClickButton className={"onClickButton_game_addArray"}
                                               onClick={event => handleOnClickArrayAdd(currentLayerElementId)}>
                                    +
                                </OnClickButton>
                                <OnClickButton className={"onClickButton_game_addArray"}
                                               onClick={event => handleOnClickArrayDelete(currentLayerElementId)}>
                                    −
                                </OnClickButton>
                            </div>
                            <ul>
                                {listArray(each.elem, currentLayerElementId)}
                            </ul>
                        </li>
                    )
                } else if (each.k === "prim") {
                    classifiedCurrentObjectFieldValueSet.push(
                        <li>
                            {/*
                    Pass the value:{id} to
                     also, the input VirtualElement id is set to be the same as value id
                    */}
                            <InputText key={eachCurrentObjectFieldValue.entryId}
                                       className={"input_createObject_prim"}
                                       onChange={event => handleInputTextChange(event, eachCurrentObjectFieldValue.entryId)}/>
                        </li>
                    )
                } else if (each.k === "option") {
                    classifiedCurrentObjectFieldValueSet.push(
                        <li>
                            <InputCheckBox key={eachCurrentObjectFieldValue.entryId}
                                           className={"inputCheckBox_objectCreate"}/>
                            <ul>
                                {listArray(each.elem, each.elem.id)}
                            </ul>
                        </li>
                    )
                } else if (each.k === "user") {
                    classifiedCurrentObjectFieldValueSet.push(
                        <li>
                            {/*
                    Pass the value:{id} to
                     also, the input VirtualElement id is set to be the same as value id
                    */}
                            <InputText key={eachCurrentObjectFieldValue.entryId}
                                       className={"input_createObject_prim"}
                                       onChange={event => handleInputTextChange(event, eachCurrentObjectFieldValue.entryId)}
                                       placeholder={"user"}/>
                        </li>
                    )
                }

            }
            return classifiedCurrentObjectFieldValueSet;
        }, []);
        return classifiedCurrentObjectFieldValueSet;
    }


    const handlePrimChange = (event, objectTypeDtoID) => {
        const tempCurrentObjectField = currentObjectField;
        //Set current value in the structure of currentObjectFieldValue
        tempCurrentObjectField.find(x => x.objectFieldTypeDto.id === objectTypeDtoID).value = event.target.value;
        setCurrectObjectField(tempCurrentObjectField)
        console.log(tempCurrentObjectField)
    }


    //each = the recurrsive structure objectFieldTypeDto
    const createNestedStructure = (each, nestedStructure) => {
        if (each.k === "option") {//option depends, if prim, saved in the structure, if array, outside
            nestedStructure.push(
                <InputCheckBox key={nanoid()} className={"inputCheckBox_objectCreate"}/>
            )
            createNestedStructure(each.elem, nestedStructure)
        } else if (each.k === "prim") {//prim saved in the object structure
            nestedStructure.push(
                <InputText className={"input_createObject_prim"}
                           onChange={event => handlePrimChange(event, each.id)}/>
            )
        } else if (each.k === "array") {//array saved outside of structure
            const currentLayerElementId = each.id//objectFieldTypeDto's ID
            // console.log(each)
            nestedStructure.push(
                <Fragment>
                    <div className={"flexbox-container"}>
                        <OnClickButton className={"onClickButton_game_addArray"}
                                       onClick={event => handleOnClickArrayAdd(currentLayerElementId)}>
                            +
                        </OnClickButton>
                        <OnClickButton className={"onClickButton_game_addArray"}
                                       onClick={event => handleOnClickArrayDelete(currentLayerElementId)}>
                            −
                        </OnClickButton>
                    </div>
                    <ul className={"flexbox-container"}>
                        {listArray(each.elem, currentLayerElementId)}
                    </ul>
                </Fragment>
            )
        }

        return nestedStructure
    }
    //each = each field{fieldName,id,objectFieldTypeDto}
    const listFields = currentObjectField.map((each) => {
            let nestedStructure = [<Header className={"header_fieldName"}>{each.fieldName}: </Header>];
            nestedStructure = createNestedStructure(each.objectFieldTypeDto, nestedStructure);
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
        if (currentObjectName) {
            UserService.createObject(currentObjectName, JSON.stringify({
                    currentObjectField,
                    currentObjectFieldValue
                })
            ).then(
                response => {
                    localStorage.setItem("myobject", JSON.stringify(response.data));
                    console.log(response.data);
                    setMessage("Success!");
                },
                error => {
                    const resMessasge = (error.response && error.response.data && error.response.data.message) || error.message || error.toString();
                    setMessage(resMessasge);
                }
            )
        }else{
            setMessage("Error!: You must select one object to send");
        }
    }

    return (
        <div>
            <Header className={"header_dice_rolling_game"}>Create Object</Header>
            <Header className={"header_createObject_error"}>{message}</Header>
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
