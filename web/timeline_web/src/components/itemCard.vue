<template>
    <div class="item-card col l3 m4 s6 ">
      <div class="border round-large shadow" style="height: 100%">
        <a :href="url">
          <img :src="titleImage" class="round-small title-image" alt="" style="width: 100%; height: auto">
          <img :src="subTitleImage" class="round-small subtitle-image" alt="" style="width: 70%; height: auto">
          <h2 class="item-des text-shadow">Mandela: A Life of Purpose</h2>
        </a>
      </div>
    </div>

</template>

<script>
export default {
  data () {
    return {
      url: 'http://www.baidu.com',
      titleImage: 'https://timeline.knightlab.com/static/img/examples/thumbs/thumb_mandela.jpg',
      subTitleImage: 'https://timeline.knightlab.com/static/img/examples/logos/logo_time.png'
    }
  }
}
</script>

<style>
  @import "./../css/timeline.css";
</style>
