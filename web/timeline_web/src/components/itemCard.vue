<template>
    <div class="item-card col l3 m4 s6 ">
      <div class="border round-large shadow" style="height: 100%">
        <a :href="item.itemUrl">
          <img :src="item.titleImage" class="round-small title-image" alt="" style="width: 100%; height: auto">
          <img :src="item.subTitleImage" class="round-small subtitle-image" alt="" style="width: 70%; height: auto">
          <h2 class="item-des text-shadow">{{item.itemDes}}</h2>
        </a>
      </div>
    </div>

</template>

<script>
export default {
  data () {
    return {

    }
  },
  props: {
    'item': Object
  }
}
</script>

<style>
  @import "./../css/timeline.css";
</style>
