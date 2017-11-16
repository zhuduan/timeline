const routers = [{
    path: '/',
    meta: {
        title: ''
    },
    component: (resolve) => require(['./views/Index.vue'], resolve)
}];
export default routers;