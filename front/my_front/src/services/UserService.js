import axios from "axios";

const URL_GET_ALL_USERS = "http://localhost:8080/users"

class UserService {
    getUsers(){
        return axios.get(URL_GET_ALL_USERS);
    }
}

export default new UserService();