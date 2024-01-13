import axios from "axios";

const config = {
    baseUrl : 'http://localhost:8080/tm6/app/',
    baseUrl2 : 'http://localhost:8080/selectThunder'
}

const data = {
    "step": 1,
    "searchColumn": '',
    "searchText": '',
    "start": 1,
    "limit":10
}

function massmailInfoList() {
    //return axios.get(`${config.baseUrl2}`);
    return axios.get('/selectThunder');
}

export {
    massmailInfoList,
}