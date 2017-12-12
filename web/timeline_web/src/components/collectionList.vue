<template>
  <div class="collection-list">
    <div class="sideBanner-container round-large" style="padding-top: 10px; margin-top: 10px;">
      <h3 class="collection-title">我的收藏</h3>
      <ul class="list" style="text-align: left;" v-for="item in sidelist">
        <a :href="item.itemUrl" class="ivu-url"><li style="padding: 15px 0px;font-size: 15px;">{{item.itemText}}<i class="fa fa-heart text-red" aria-hidden="true" style="float: right;">  {{item.itemThumbsUp}}</i></li></a>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      sidelist: [
        {itemText: '感恩节将至 特朗普赦免火鸡激情演讲', itemUrl: '#', itemThumbsUp: 1230},
        {itemText: '[手稿曝光]厉以宁谈消除结构性失衡', itemUrl: '#', itemThumbsUp: 863},
        {itemText: '这个国家以前没国产轿车 现在中国帮忙圆了这个梦', itemUrl: '#', itemThumbsUp: 172}
      ]
    }
  },
  props: {
  },
  methods: {
  }
}
</script>

<style>
</style>
