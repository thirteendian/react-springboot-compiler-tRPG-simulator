//This is a service to get page infomation
//(only a test)
import axios from 'axios';
import authHeader from './auth-header';
const API_URL = "http://localhost:12345/user/";

export default class UserService {
    getPublicContent() {
        return axios.get(API_URL + 'all');
    }
    getUserBoard() {
        return axios.get(API_URL + 'user', { headers: authHeader() });
    }
    getModeratorBoard() {
        return axios.get(API_URL + 'mod', { headers: authHeader() });
    }
    getAdminBoard() {
        return axios.get(API_URL + 'admin', { headers: authHeader() });
    }

    static getAllGames(){
        return axios.get(API_URL+'getallgame',{headers: authHeader()});
    }

    static getAllJoinedGame(){
        return axios.get(API_URL+'getmyjoinedgame',{headers:authHeader()});
    }


    static createGame(code,gameName,playerNum){
        const user = JSON.parse(localStorage.getItem('user'));
        const hostUuid = user.uuid;
        return axios.post(API_URL+'creategame',{
            headers: authHeader(),
            hostUuid,
            gameName,
            playerNum,
            code
        });
    }

    static startGame(gameId){
        return axios.post(API_URL+'startgame',{
            gameId
        })
    }

    static getObjectInfo(){
        return axios.get(API_URL+'objectInfo');
    }
}