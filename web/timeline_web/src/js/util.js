import axios from 'axios';
import env from '../config/env';

let util = {};

const WEB_TITLE = "Backtrack--事件回溯";

const Dev_Api_Url = "http://127.0.0.1:8088";
const Prod_Api_Url = "http://www.keep-on.top:8080/api-server";
const Debug_Api_Url = 'https://debug.url.com';

util.title = function (title) {
    title = title ? title + ' - Home' : WEB_TITLE;
    window.document.title = title;
};

util.getWebTitle = function () {
    return WEB_TITLE;
}

const ajaxUrl = env === 'development' ? Dev_Api_Url : env === 'production' ? Prod_Api_Url : Debug_Api_Url;

util.ajax = axios.create();

// axios config
util.ajax.defaults.timeout = 50000;
util.ajax.defaults.baseURL = ajaxUrl;
util.ajax.defaults.withCredentials = true;
util.ajax.defaults.headers.post['Content-Type'] = 'application/text; charset=UTF-8';


/*util.ajax.interceptors.request.use((config) => {
    if (config.method === 'post') {
        config.data = qs.stringify(config.data);
    }
    return config;
}, (error) => {
    return Promise.reject(error);
});*/

//interceptors
/*util.ajax.interceptors.response.use((res) => {

    if (res.status == 200) {

        var data = res.data;
        if (data != null && data != '' && 'status' in data && 'data' in data) {

            data = data.data;
        }

        res.data = data;
    }
    return res;
}, (error) => {

    return Promise.reject(error);
});*/

util.getParams = (params) => {
    let param = new URLSearchParams();
    for(let key in params) {

        param.append(key, params[key]);
    }
    return param;
};

export default util