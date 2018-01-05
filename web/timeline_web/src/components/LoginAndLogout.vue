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
                   :loading="loading" :mask-closable="false" :label-width="50" @on-ok = "sendLogin()">
                <IForm ref="formInline" :model="user" :rules="rules">
                    <i-row type="flex" justify="center" class="code-row-bg">
                        <i-col>
                            <IFormItem prop="user">
                                <IInput type="text" v-model="user.name" placeholder="用户名" >
                                    <Icon type="ios-person-outline" slot="prepend"></Icon>
                                </IInput>
                            </IFormItem>
                        </i-col>
                    </i-row>
                    <i-row type="flex" justify="center" class="code-row-bg">
                        <i-col>
                            <IFormItem prop="password">
                                <IInput type="password" v-model="user.password" placeholder="密码">
                                    <Icon type="ios-locked-outline" slot="prepend"></Icon>
                                </IInput>
                            </IFormItem>
                        </i-col>
                    </i-row>
                </IForm>
            </Modal>

            <!--登录弹窗-->
            <Modal v-model="registerModal" title="注册" class-name="vertical-center-modal"
                   :loading="loading" :mask-closable="false" :label-width="50" @on-ok = "register()">
                <IForm ref="formInline" :model="user" :rules="rules">
                    <i-row type="flex" justify="center" class="code-row-bg">
                        <i-col>
                            <IFormItem prop="user">
                                <IInput type="text" v-model="user.name" placeholder="用户名" >
                                    <Icon type="ios-person-outline" slot="prepend"></Icon>
                                </IInput>
                            </IFormItem>
                        </i-col>
                    </i-row>
                    <i-row type="flex" justify="center" class="code-row-bg">
                        <i-col>
                            <IFormItem prop="password">
                                <IInput type="password" v-model="user.password" placeholder="密码">
                                    <Icon type="ios-locked-outline" slot="prepend"></Icon>
                                </IInput>
                            </IFormItem>
                        </i-col>
                    </i-row>
                    <i-row type="flex" justify="center" class="code-row-bg">
                        <i-col>
                            <IFormItem prop="password">
                                <IInput type="password" v-model="user.email" placeholder="邮箱">
                                    <Icon type="ios-locked-outline" slot="prepend"></Icon>
                                </IInput>
                            </IFormItem>
                        </i-col>
                    </i-row>
                </IForm>
            </Modal>
        </div>
    </Row>
</template>

<script>
    import iview from '../js/iview'
    import qs from 'qs';
    import util from '../libs/util'
    import IForm from "../../node_modules/iview/src/components/form/form.vue";
    import IFormItem from "../../node_modules/iview/src/components/form/form-item.vue";
    import IInput from "../../node_modules/iview/src/components/input/input.vue";
    import ICol from "../../node_modules/iview/src/components/grid/col.vue";

    export default {
        components: {
            ICol,
            IForm,
            IFormItem,
            IInput
        },
        mounted: function(){

            this.isLogin = this.$root.$store.state.user.isLogin;
            if(this.isLogin === null || this.isLogin === undefined) {
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
                    email:""
                },
                isLogin: false,
                userName: "",
                loginModal: false,
                registerModal: false,
                loading:false
            }
        },
        methods: {
            sendLogin: function () {

                var querystring = '/user/login';

                if (this.user.name == null || this.user.name == "") {

                    this.$Notice.error({
                        title: "error",
                        desc: "用户名为空",
                        duration: 1000 * 2
                    });
                    return;
                }

                if (this.user.password == null || this.user.password.length < 6) {

                    this.$Notice.error({
                        title: "error",
                        desc: "密码为空",
                        duration: 1000 * 2
                    });
                    return;
                }

                this.$http.post(querystring, util.getParams({
                    password: this.user.password,
                    userName: this.user['name']
                })).then((response) => {

                        var data = response.data;
                        if (data['status'] === 200) {

                            this.$Notice.success({
                                title: "success",
                                desc: "登录成功！",
                                duration: 1000 * 2
                            });
                            this.$store.dispatch('USER_SIGNIN', data.data);
                            this.isLogin = true;
                            this.userName = data.data.name;
                        } else {
                            this.$Notice.error({
                                title: "error",
                                desc: data.data,
                                duration: 1000 * 2
                            });
                        }
                    })
                    .catch((error) => {
                        console.log(error);
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
