const routers = [{
    path: '/',
    meta: {
        title: ''
    },
    component: (resolve) => require(['./pages/Index.vue'], resolve)
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
    ,
    {
        path: '/login',
        name: '/login',
        meta: {
            title: ''
        },
        component: (resolve) => require(['./pages/login.vue'], resolve)
    }
];
export default routers;
