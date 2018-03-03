<template>
    <Row style="text-align: center;">
        <div class="">
            <!--未登录-->
            <div v-if="isLogin === false">
                <button class="btn white layout-login" @click="loginModal = true">登录</button>
                <button class="btn white layout-login" @click="registerModal = true">注册</button>
            </div>

            <!--已登录-->
            <div v-else>
                <img/>
                <span style="color: white;font-color:white"> {{userName}} </span>
                <button class="btn white layout-login" @click="logout()">退出登录</button>
            </div>

            <!--登录弹窗-->
            <Modal v-model="loginModal" title="登录" class-name="vertical-center-modal"
                   :loading="loginLoading" :mask-closable="false" :label-width="50" @on-ok="sendLogin()">
                <IForm ref="loginForm" :model="user">
                    <IRow type="flex" justify="center" class="code-row-bg">
                        <ICol>
                            <IFormItem prop="name">
                                <IInput type="text" v-model="user.name" placeholder="用户名">
                                    <Icon type="ios-person-outline" slot="prepend"></Icon>
                                </IInput>
                            </IFormItem>
                        </ICol>
                    </IRow>
                    <IRow type="flex" justify="center" class="code-row-bg">
                        <ICol>
                            <IFormItem prop="password">
                                <IInput type="password" v-model="user.password" placeholder="密码">
                                    <Icon type="ios-locked-outline" slot="prepend"></Icon>
                                </IInput>
                            </IFormItem>
                        </ICol>
                    </IRow>
                </IForm>

                <div slot="footer">
                    <Button type="primary" size="default" long :loading="loginLoading" @click="sendLogin()">登录</Button>
                </div>
            </Modal>

            <!--登录弹窗-->
            <Modal v-model="registerModal" title="注册" class-name="vertical-center-modal"
                   :loading="registerLoading" :mask-closable="false" :label-width="50" @on-ok="register()">
                <IForm ref="registerForm" :model="user">

                    <IRow type="flex" justify="center" class="code-row-bg">
                        <ICol>
                            <IFormItem prop="user">
                                <IInput type="text" v-model="user.name" placeholder="用户名">
                                    <Icon type="ios-person-outline" slot="prepend"></Icon>
                                </IInput>
                            </IFormItem>
                        </ICol>
                    </IRow>

                    <IRow type="flex" justify="center" class="code-row-bg">
                        <ICol>
                            <IFormItem prop="password">
                                <IInput type="password" v-model="user.password" placeholder="密码">
                                    <Icon type="ios-locked-outline" slot="prepend"></Icon>
                                </IInput>
                            </IFormItem>
                        </ICol>
                    </IRow>

                    <IRow type="flex" justify="center" class="code-row-bg">
                        <ICol>
                            <IFormItem prop="email">
                                <IInput type="email" v-model="user.email" placeholder="邮箱">
                                    <Icon type="ios-email-outline" slot="prepend"></Icon>
                                </IInput>
                            </IFormItem>
                        </ICol>
                    </IRow>

                    <IRow type="flex" justify="center" class="code-row-bg">
                        <ICol>
                            <IFormItem prop="phone">
                                <IInput type="text" v-model="user.phone" placeholder="电话">
                                    <Icon type="ios-person-outline" slot="prepend"></Icon>
                                </IInput>
                            </IFormItem>
                        </ICol>
                    </IRow>

                </IForm>

                <div slot="footer">
                    <Button type="primary" size="default" long :loading="registerLoading" @click="sendRegister()">注册
                    </Button>
                </div>
            </Modal>
        </div>
    </Row>
</template>

<script>
    import common from '../js/common';
    import util from '../libs/util';
    import IForm from "../../node_modules/iview/src/components/form/form.vue";
    import IFormItem from "../../node_modules/iview/src/components/form/form-item.vue";
    import IInput from "../../node_modules/iview/src/components/input/input.vue";
    import ICol from "../../node_modules/iview/src/components/grid/col.vue";
    import IRow from "../../node_modules/iview/src/components/grid/row.vue";
    
    export default {
        components: {
            ICol,
            IForm,
            IFormItem,
            IInput,
            IRow
        },
        mounted: function () {

            this.isLogin = this.$root.$store.state.user.isLogin;
            if (this.isLogin === null || this.isLogin === undefined) {
                this.isLogin = false;
            } else {
                this.userName = this.$root.$store.state.user.name;
            }
        },
        data() {
            return {
                user: {
                    name: "",
                    password: "",
                    email: "",
                    phone: ""
                },

                isLogin: false,
                userName: "",

                loginModal: false,
                loginLoading: false,

                registerModal: false,
                registerLoading: false
            }
        },
        methods: {
            sendLogin: function () {

                var querystring = '/user/login';

                if (this.user.name == null || this.user.name == "") {

                    this.$Notice.error({
                        title: "error",
                        desc: "用户名为空",
                        duration: 2
                    });
                    return;
                }

                if (this.user.password == null || this.user.password.length < 6) {

                    this.$Notice.error({
                        title: "error",
                        desc: "密码为空",
                        duration: 2
                    });
                    return;
                }

                this.loginLoading = true;
                this.$http.post(querystring, util.getParams({
                    password: this.user.password,
                    userName: this.user['name']
                })).then((response) => {

                    var data = response.data;
                    if (data['status'] === 200) {

                        this.$Notice.success({
                            title: "success",
                            desc: "登录成功！",
                            duration: 2
                        });
                        this.$store.dispatch('USER_SIGNIN', data.data);
                        this.isLogin = true;
                        this.userName = data.data.name;
                        this.loginLoading = false;
                        this.loginModal = false;
                    } else {

                        this.$Notice.error({
                            title: "error",
                            desc: data.data,
                            duration: 2
                        });
                        this.loginLoading = false;
                    }
                }).catch((error) => {
                    console.log(error);
                    // 关闭加载
                    this.registerLoading = false;
                });

            },

            sendRegister: function () {

                var querystring = '/user/register';

                if (this.user.name == null || this.user.name == "") {

                    this.$Notice.error({
                        title: "error",
                        desc: "用户名为空",
                        duration: 2
                    });
                    return;
                }

                if (this.user.password == null || this.user.password.length < 6) {

                    this.$Notice.error({
                        title: "error",
                        desc: "密码为空",
                        duration: 2
                    });
                    return;
                }

                if (this.user.email == null || !common.validateEmail(this.user.email)) {

                    this.$Notice.error({
                        title: "error",
                        desc: "email不正确",
                        duration: 2
                    });
                    return;
                }

                if (this.user.phone == null || !common.validatePhone(this.user.phone)) {

                    this.$Notice.error({
                        title: "error",
                        desc: "电话不正确",
                        duration: 2
                    });
                    return;
                }

                this.registerLoading = true;
                this.$http.post(querystring, util.getParams({
                    password: this.user.password,
                    userName: this.user['name'],
                    email: this.user.email,
                    phone: this.user.phone
                })).then((response) => {

                    var data = response.data;
                    if (data['status'] === 200) {

                        this.$Notice.success({
                            title: "success",
                            desc: "注册成功！",
                            duration: 2
                        });

                        // 关闭弹窗
                        this.registerLoading = false;
                        this.registerModal = false;
                    } else {

                        this.$Notice.error({
                            title: "error",
                            desc: data.data,
                            duration: 2
                        });

                        // 关闭加载
                        this.registerLoading = false;
                    }
                }).catch((error) => {
                    console.log(error);
                    // 关闭加载
                    this.registerLoading = false;
                });

            },

            logout() {

                this.isLogin = false;
                this.userName = "";
                this.$store.dispatch('USER_SIGNOUT');
            }
        }
    }
</script>

<style lang="less">
    .vertical-center-modal {
        display: flex;
        align-items: center;
        justify-content: center;

        .ivu-modal {
            top: 0;
        }
    }
</style>
