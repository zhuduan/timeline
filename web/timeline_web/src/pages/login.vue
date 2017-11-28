<template>
  <Row style="text-align: center;">
    <div class="">
      <div class="col l4 m4 s8 login-form-container" style="float: initial">
        <form class="" action="#" method="post">
          <div class="form-group-label">
            <label for="name" class="floating-label">姓名</label>
            <input type="text" class="form-control" id="name" name="name" value="" @focus="inputOnFocus" @blur="inputOnBlur"/>
          </div>
          <div class="form-group-label">
            <label for="name" class="floating-label">密码</label>
            <input type="password" class="form-control" id="password" name="password" value=""  @focus="inputOnFocus" @blur="inputOnBlur"/>
          </div>
          <div class="bar">
            <button class="btn" type="button" name="button">登录</button>
            <button class="btn white" type="button" name="button" style="color: gery;">注册</button>
          </div>
        </form>
      </div>
    </div>
  </Row>
</template>

<script>
import iview from './../js/iview'
export default {
  methods: {
    inputOnFocus: function (e) {
      iview.inputOnFocus(e);
    }
    ,
    inputOnBlur: function (e) {
      iview.inputOnBlur(e);
    }
  }
}
</script>

<style>
  .bar {
    float: right;
  }
</style>
