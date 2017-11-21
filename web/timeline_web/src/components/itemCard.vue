<template>
    <div class="item-card col l3 m4 s6 ">
      <a :href="item.itemUrl">
        <div class="border round-large shadow hover-shadow-large" style="height: 100%">
            <figure>
              <img :src="item.titleImage" class="round title-image grayscale-max hover-grayscale-min " alt="" style="width: 100%; height: auto">
            </figure>
            <img :src="item.subTitleImage" class="round-small subtitle-image" alt="" style="width: 70%; height: auto">
            <h2 class="item-des text-shadow hover-text-shadow">{{item.itemDes}}</h2>
        </div>
      </a>
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
</style>
