import React, {Fragment, useState} from 'react';
import "./index.css";
import Header from "../../components/Header";
import InputText from "../../components/InputText";
import OnClickButton from "../../components/OnClickButton";
import MyNavLink from "../../components/MyNavLink";
import UserService from "../../services/user.service";
import {useNavigate} from "react-router-dom";

export default function Index() {
    const [selectedFile, setSelectedFile] = useState("");
    const [gameName, setGameName] = useState("");
    const [numPlayer, setNumPlayer] = useState("");
    const [isPage2, setIsPage2] = useState(false);
    const [message,setMessage] = useState("");

    const onChangeFileText=(event)=>{
        setSelectedFile(event.target.value)
    }

    const onGameNameChange = (event) => {
        setGameName(event.target.value);
    }
    const onnumberOfPlayerChange = (event) => {
        setNumPlayer(event.target.value);
    }
    const onClickLeftArrow = () => {
        setIsPage2(false);
    }
    const onClickRightArrow = () => {
        setIsPage2(true);
    }

    let navigate = useNavigate();
    const onCreate = () => {
        console.log(selectedFile)
        UserService.createGame(selectedFile,gameName,numPlayer).then(
            response=>{
                if(response.data){
                    localStorage.setItem("game",JSON.stringify(response.data))
                    console.log(response.data)
                }
                navigate("/user/gameCenter")//Her
                return response.data;
            },
            error=>{
                const resMessasge = (error.response && error.response.data && error.response.data.message) || error.message || error.toString();
                setMessage(resMessasge);
            }
        )
    }
    return (
        <div>
            <Header className={"header_dice_rolling_game"}>Dice Rolling Game</Header>
            <Header className={"header_signup"}>Create Game</Header>
            {
                message && (
                    <Header className={"header_createGame_error"}>{message}</Header>
                )
            }

            {!isPage2 && (
                <Fragment>
                    <Header className={"header_signup_email"}>Game Name:</Header>
                    <InputText className={"input_signup_email"} onChange={onGameNameChange}
                               placeholder={"Enter..."}/>
                    <Header className={"header_signup_firstname"}>Number Of Player:</Header>
                    <InputText className={"input_createGame_numberOfPlayer"} onChange={onnumberOfPlayerChange}
                               placeholder={"Enter..."}/>
                </Fragment>
            )
            }

            {isPage2 && (
                <Fragment>
                    {/*<InputFile classNameInput={"inputFile_createGame"}*/}
                    {/*           onChange={onSelectedFileChange}/>*/}
                    <InputText className={"input_createGame_text"} value={selectedFile} onChange={onChangeFileText}/>
                </Fragment>
            )
            }


            <MyNavLink className={"myNavLink_createGame_back"} to={"/"}>Back To Main</MyNavLink>
            <OnClickButton key={"createGame_left"} className={"onClickButton_createGame_prev"}
                           onClick={onClickLeftArrow} disabled={!isPage2}>←</OnClickButton>
            <OnClickButton key={"createGame_right"} className={"onClickButton_createGame_next"}
                           onClick={onClickRightArrow} disabled={isPage2}>→</OnClickButton>
            <OnClickButton className={"onClickButton_createGame_create"} onClick={onCreate}
                           disabled={!isPage2}>Create</OnClickButton>

        </div>
    );
}
