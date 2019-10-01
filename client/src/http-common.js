import axios from "axios";

export default axios.create({
    baseURL: "http://localhost:9000/",
    headers: {
        'Access-Control-Allow-Origin': '*',
       // 'Access-Control-Allow-Methods' : 'POST ,GET,OPTIONS ,PUT ,DELETE' ,
        "Content-type": "application/json",
    }
});