const routers = [{
    path: '/',
    meta: {
        title: ''
    },
    component: (resolve) => require(['./pages/index.vue'], resolve)
    },
    {
        path: '/search/:value',
        name: '/search',
        meta: {
            title: ''
        },
        component: (resolve) => require(['./pages/searchResult.vue'], resolve)
    },
    {
        path: '/subject/:value',
        name: '/subject',
        meta: {
            title: ''
        },
        component: (resolve) => require(['./pages/subject.vue'], resolve)
    },
    {
        path: '/home',
        name: '/home',
        meta: {
            title: '',
            requireAuth: true
        },
        component: (resolve) => require(['./pages/home.vue'], resolve)
    }
];
export default routers;
