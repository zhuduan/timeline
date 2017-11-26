<template>
    <div class="item-card col l3 m4 s6 ">
      <router-link :to="{ name: '/subject', params: {value:item.id} }">
        <a :href="item.itemUrl">
          <div class="border round-large shadow hover-shadow-large" style="height: 100%">
              <div class="title-image-cover">
                <img :src="item.picUrl" class="round title-image grayscale-max hover-grayscale-min " alt="" >
              </div>
              <!-- <img :src="item.subTitleImage" class="round-small subtitle-image" alt="" style="width: 70%; height: auto"> -->
              <h3 class="subject-title">{{item.title}}</h3>
              <h2 class="item-des text-shadow hover-text-shadow">{{addEllipsis(item.content)}}</h2>
          </div>
        </a>
      </router-link>
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
  },
  methods: {
    addEllipsis: function (str) {
        if(str.length > 32){
          return str.substring(0,32)+"...";
        }else{
          return str;
        }
    }
  }
}
</script>

<style>
</style>
