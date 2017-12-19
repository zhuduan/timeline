<template>
    <Row style="text-align: center;">
        <div class="">
            <div class="col l4 m4 s8 login-form-container" style="float: initial">
                <form class="" action="#" method="post">
                    <div class="form-group-label">
                        <label for="name" class="floating-label">姓名</label>
                        <input type="text" class="form-control" ref="userName" id="name" v-model="userName" value=""
                               @focus="inputOnFocus" @blur="inputOnBlur"/>
                    </div>
                    <div class="form-group-label">
                        <label for="name" class="floating-label">密码</label>
                        <input type="password" class="form-control" ref="password" id="password" v-model="password"
                               value="" @focus="inputOnFocus" @blur="inputOnBlur"/>
                    </div>
                    <div class="bar">
                        <button class="btn" type="button" name="button" @click="sendLogin">登录</button>
                        <router-link :to="{ name: '/home', params: {} }">
                            <button class="btn white" type="button" name="button" style="color: gery;">注册</button>
                        </router-link>
                    </div>
                </form>
            </div>
        </div>
    </Row>
</template>

<script>
    import iview from './../js/iview'
    import qs from 'qs';
    import util from './../libs/util'
    export default {
        data() {
            return {
                userName: '',
                password: ''
            }
        },
        methods: {
            inputOnFocus: function (e) {
                iview.inputOnFocus(e);
            }
            ,
            inputOnBlur: function (e) {
                iview.inputOnBlur(e);
            },
            sendLogin: function (e) {
                var querystring = '/user/login';

                if(this.userName != null && this.userName != "") {

                    if(this.password != null && this.password.length >= 6) {

                        this.$http.post(querystring, util.getParams({
                            userName: this.userName,
                            password: this.password
                        }))
                        .then(function (response) {

                            console.log(response.data);
                            this.$router.back();
                        })
                        .catch(function (error) {
                            console.log(error);
                        });
                    }
                }

            }
        }
    }
</script>

<style>
    .bar {
        float: right;
    }
</style>
