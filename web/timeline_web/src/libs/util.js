import axios from 'axios';
import env from '../config/env';

let util = {};
util.title = function (title) {
    title = title ? title + ' - Home' : 'iView project';
    window.document.title = title;
};

const ajaxUrl = env === 'development' ? 'http://127.0.0.1:8088' : env === 'production' ? 'https://www.url.com' : 'https://debug.url.com';

util.ajax = axios.create();

// axios start
util.ajax.defaults.baseURL = ajaxUrl;
util.ajax.defaults.timeout = 50000;
util.ajax.defaults.headers.post['Content-Type'] = 'application/text; charset=UTF-8';
util.ajax.defaults.withCredentials = false;

/*util.ajax.interceptors.request.use((config) => {
    if (config.method === 'post') {
        config.data = qs.stringify(config.data);
    }
    return config;
}, (error) => {
    return Promise.reject(error);
});*/

//interceptors
util.ajax.interceptors.response.use((res) => {

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
});

util.getParams = (params) => {
    let param = new URLSearchParams();
    for(let key in params) {

        param.append(key, params[key]);
    }
    return param;
};

export default util