//This is an helper function to create JWT Authentication Header
//JWT Authentication Header is required for each authenticated request
//If user exist, return user's jwt header
//If user not exist, return empty
export default function authHeader(){
    const user = JSON.parse(localStorage.getItem('user'));
    if (user && user.token) {//if user is logged in and have accessToken
        return {Authorization: 'Bearer ' + user.token};
    } else {
        return {};
    }
}