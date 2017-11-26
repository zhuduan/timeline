const routers = [{
    path: '/',
    meta: {
        title: ''
    },
    component: (resolve) => require(['./pages/Index.vue'], resolve)
    },
    {
        path: '/search',
        name: '/search',
        meta: {
            title: ''
        },
        component: (resolve) => require(['./pages/searchResult.vue'], resolve)
    },
    {
        path: '/subject',
        name: '/subject',
        meta: {
            title: ''
        },
        component: (resolve) => require(['./pages/subject.vue'], resolve)
    }
];
export default routers;
