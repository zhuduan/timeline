<template>
  <Row style="text-align: center;">
    <div class="">
      <div class="col l4 m4 s8 login-form-container" style="float: initial">
        <form class="" action="#" method="post">
          <div class="form-group-label">
            <label for="name" class="floating-label">姓名</label>
            <input type="text" class="form-control" name="name" value="" @focus="inputOnFocus" @blur="inputOnBlur"/>
          </div>
          <div class="form-group-label">
            <label for="name" class="floating-label">邮箱</label><label for="name" ref="emailAlert" class="floating-label hidden" style="margin-left:80px;">! 邮箱格式不正确，请确认输入</label>
            <input type="text" class="form-control" name="password" ref="email" value=""  @focus="inputOnFocus" @blur="validateEmail"/>
          </div>
          <div class="form-group-label">
            <label for="name" class="floating-label">电话</label><label for="name" ref="phoneAlert" class="floating-label hidden" style="margin-left:80px;">! 号码格式不正确，请确认输入</label>
            <input type="text" class="form-control" name="password" ref="phone" maxLength="11" value=""  @focus="inputOnFocus" @blur="validatePhone"/>
          </div>
          <div class="form-group-label">
            <label for="name" class="floating-label">密码</label>
            <input type="password" class="form-control" id="password" ref="password" name="password" value=""  @focus="inputOnFocus" @blur="inputOnBlur"/>
          </div>
          <div class="form-group-label">
            <label for="name" class="floating-label">确认密码</label><label for="name" ref="pswdAlert" class="floating-label hidden" style="margin-left:80px;">! 两次输入密码不同，请确认输入</label>
            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" value=""  @focus="inputOnFocus" @blur="confirmPassword"/>
          </div>
          <div class="bar">
            <button class="btn white" type="button" name="button" style="color: gery;">注册</button>
          </div>
        </form>
      </div>
    </div>
  </Row>
</template>

<script>
import Vue from 'vue'
import iview from './../js/iview'
export default {
  methods: {
    inputOnFocus: function (e) {
      iview.inputOnFocus(e);
    }
    ,
    inputOnBlur: function (e) {
      iview.inputOnBlur(e);
    },
    confirmPassword: function (e) {
      iview.inputOnBlur(e);
      var confirmpswd = e.target.value;
      var pswd = this.$refs.password.value;
      if(confirmpswd != pswd){
        this.$refs.pswdAlert.className = 'floating-label show';
      }else {this.$refs.pswdAlert.className = 'floating-label hidden';}
    },
    validateEmail: function (e) {
      iview.inputOnBlur(e);
      if(!iview.validateEmail(this.$refs.email.value)){
        this.$refs.emailAlert.className = 'floating-label show';
      }else{this.$refs.emailAlert.className = 'floating-label hidden';}
    },
    validatePhone: function (e) {
      iview.inputOnBlur(e);
      if(!iview.validatePhone(this.$refs.phone.value)){
        this.$refs.phoneAlert.className = 'floating-label show';
      }else{this.$refs.phoneAlert.className = 'floating-label hidden';}
    }
  }
}
</script>

<style>
  .bar {
    float: right;
  }
</style>
