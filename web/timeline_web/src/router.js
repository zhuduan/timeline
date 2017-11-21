const routers = [{
    path: '/',
    meta: {
        title: ''
    },
    component: (resolve) => require(['./pages/Index.vue'], resolve)
    },
    {
        path: '/search',
        meta: {
            title: ''
        },
        component: (resolve) => require(['./pages/searchResult.vue'], resolve)
    }
];
export default routers;
