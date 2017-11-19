const routers = [{
    path: '/',
    meta: {
        title: ''
    },
    component: (resolve) => require(['./pages/Index.vue'], resolve)
}];
export default routers;
