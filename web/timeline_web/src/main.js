import Vue from 'vue';
import iView from 'iview';
import VueRouter from 'vue-router';
import Routers from './router';
import Vuex from 'vuex';
import Util from './js/util';
import Index from './pages/Main.vue';
import 'iview/dist/styles/iview.css';

import VueI18n from 'vue-i18n';
import Locales from './locale';
import zhLocale from 'iview/src/locale/lang/zh-CN';
import enLocale from 'iview/src/locale/lang/en-US';

import VueAxios from 'vue-axios';

Vue.use(VueRouter);
Vue.use(Vuex);
Vue.use(VueI18n);
Vue.use(iView);

// 设置Vue请求默认使用 axios
Vue.use(VueAxios, Util.ajax);

// 自动设置语言
const navLang = navigator.language;
const localLang = (navLang === 'zh-CN' || navLang === 'en-US') ? navLang : false;
const lang = window.localStorage.getItem('language') || localLang || 'zh-CN';

Vue.config.lang = lang;

// 多语言配置
const locales = Locales;
const mergeZH = Object.assign(zhLocale, locales['zh-CN']);
const mergeEN = Object.assign(enLocale, locales['en-US']);
Vue.locale('zh-CN', mergeZH);
Vue.locale('en-US', mergeEN);

export const USER_SIGNIN = 'USER_SIGNIN' ;//登录成功
export const USER_SIGNOUT = 'USER_SIGNOUT' ;//退出登录

const store = new Vuex.Store({
    state: { user: JSON.parse(sessionStorage.getItem('user')) || {} },
    mutations: {
        [USER_SIGNIN](state, user) {
            user['isLogin'] = true;
            sessionStorage.setItem('user', JSON.stringify(user));
            Object.assign(state, user);
        },
        [USER_SIGNOUT](state) {
            sessionStorage.removeItem('user');
            Object.keys(state).forEach(k => Vue.delete(state, k));
        }
    },
    actions: {
        [USER_SIGNIN]({commit}, user) {
            commit(USER_SIGNIN, user);
        },
        [USER_SIGNOUT]({commit}) {
            commit(USER_SIGNOUT);
        }
    }
});

// 路由配置
const RouterConfig = {
    mode: 'history',
    routes: Routers
};
const router = new VueRouter(RouterConfig);

router.beforeEach((to, from, next) => {
    iView.LoadingBar.start();
    Util.title(to.meta.title);
    if (to.meta.requireAuth) {
        if (store.state.sessionid) {
            next();
        }
        else {
            next({
                path: '/login',
                query: {redirect: to.fullPath}
            });
        }
    } else if (to.path == '/login') {
        if(store.state.user.isLogin === true) {
            return;
        }
        next();
    } else {
        next();
    }
});

router.afterEach(() => {
    iView.LoadingBar.finish();
    window.scrollTo(0, 0);
});

const MainVue = new Vue({
    el: '#app',
    router: router,
    store: store,
    render: h => h(Index)
});
