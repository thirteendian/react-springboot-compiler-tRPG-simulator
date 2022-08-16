import axios from "axios";

const API_URL = "http://localhost:12345/api/auth/";

class AuthService {

    //helper method
    static postToServer(url, object) {
        return axios.post(url, object)
            .then(response => {
                return response.data;
            })
    }

    //Login method
    static login(username, password) {
        return axios
            .post(API_URL + "login", {
                username,
                password
            });
    }

    //Logout method
    static logout() {
        localStorage.removeItem("user");
    }


    // private String username;
    // private String email;
    // private Set<String> role;
    // private String firstname;
    // private String lastname;
    // private String password;
    //Signup method
    static signup(username, email, firstname, lastname, password) {
        return axios.post(API_URL + "signup", {
            username,
            email,
            firstname,
            lastname,
            password
        });
    }

    //Signin method
    static getUserDetails() {
        return JSON.parse(localStorage.getItem('user'));
    }
}

export default AuthService;