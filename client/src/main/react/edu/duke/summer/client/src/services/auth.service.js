import axios from "axios";

const API_URL = "http://localhost:12345/api/auth/";

class AuthService {

    //helper method
    postToServer(url,object){
        return axios.post(url,object)
            .then(response=>{
                return response.data;
            })
    }

    //Login method
    login(username, password) {
        return axios
            .post(API_URL + "signin", {
                username,
                password
            })
            .then(response => {
                if (response.data.accessToken) {
                    localStorage.setItem("user", JSON.stringify(response.data));
                }
                return response.data;
            });
    }

    //Logout method
    logout() {
        localStorage.removeItem("user");
    }


    // private String username;
    // private String email;
    // private Set<String> role;
    // private String firstname;
    // private String lastname;
    // private String password;
    //Signup method
    signup(username, email, password) {
        return axios.post(API_URL + "signup", {
            username,
            email,
            password
        });
    }

    //Signin method
    getUserDetails() {
        return JSON.parse(localStorage.getItem('user'));
    }
}

export default AuthService;