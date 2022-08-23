import React, {Fragment, useState} from 'react';
import "./index.css";
import MyNavLink from "../MyNavLink";
import PlayerInfo from "../PlayerInfo";
import Header from "../Header";
import OnClickButton from "../OnClickButton";

export default function Index() {
    const [showObjectDetail, setShowObjectDetail] = useState(false);
    const [showObjectList, setShowObjectList] = useState(false);
    const myObject = JSON.parse(localStorage.getItem("myobject"))
    const myObjectList = myObject.objectList;

    const handleExtendObjectInfo = () => {
        setShowObjectDetail(!showObjectDetail)
    }
    const handleExtendObjectList = () => {
        setShowObjectList(!showObjectList)
    }

    const listObject = myObjectList.map((each) =>
        <li className={showObjectDetail ? "listObject_extend" : "listObject_each"} onClick={handleExtendObjectInfo}>
            {each.objectName}
            <p/>
            {
                showObjectDetail && each.objectValue
            }
        </li>
    )

    return (
        <div>
            <PlayerInfo/>
            <OnClickButton className={showObjectList?"onClickButton_gameCenter_foldButton":"onClickButton_gameCenter_extendButton"} onClick={handleExtendObjectList}>
                {!showObjectList && <Header>⬆</Header>}
                {showObjectList && <Header>⬇</Header>}
            </OnClickButton>
            <div className={showObjectList ? "myObjectInfo_extend" : "myObjectInfo_hide"}>
                {
                    showObjectList &&
                    <Fragment>
                        <ul>
                            {listObject}
                        </ul>
                        <MyNavLink className={"myNavLink_gameCenter_createObject"} to={"/user/createObject"}>
                            create
                        </MyNavLink>
                    </Fragment>
                }
                {!showObjectList &&
                    <Header className={"header_gameCenter_MyObject"}>My Object</Header>}

            </div>
        </div>
    );
}

