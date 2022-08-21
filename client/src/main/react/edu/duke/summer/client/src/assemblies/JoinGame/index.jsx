import React, {useEffect, useState} from 'react';
import UserService from "../../services/user.service";

const Index = () => {
    const [listOfGame, setListOfGame] = useState();
    const [message, setMessage] = useState();
    const listItems = listOfGame.map((each) =>
        <li>

        </li>
    )
    useEffect(() => {
        UserService.getAllGames().then(
            response => {
                if (response.data) {
                    setListOfGame(response.data);
                }
                return response.data;
            },
            error => {
                const resMessasge = (error.response && error.response.data && error.response.data.message) || error.message || error.toString();
                setMessage(resMessasge);
            }
        )
    })
    return (
        <div>
            <ul>

            </ul>
        </div>
    );
};

export default Index;