<template>
  <div class="sideBanner-container border round-large" style="padding-top: 10px; margin-top: 10px;">
    <h3 style="padding-left: 15px; text-align: left">快捷菜单 / 公告</h3>
    <ul class="list" style="text-align: left;" v-for="item in sidelist">
      <a :href="item.itemUrl" class="ivu-url"><li><i class="fa fa-birthday-cake margin-right text-red"></i>{{item.itemText}}</li></a>
    </ul>
  </div>

</template>

<script>
export default {
  data () {
    return {

    }
  },
  props: {
    'sidelist': Object
  }
}
</script>

<style>
</style>
