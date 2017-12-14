<template>
    <div>
        <Row style="text-align: center;">
            <div class="index-logo" style="font-size: xx-large;"><h1>timeline<sup class="sup red">js</sup></h1></div>
            <span><h3>Sub title</h3></span>
            <br/>
            <div class="index-search">
                <input v-model="searchKey" class="ivu-inputbox" v-on:keyup.enter="searchSubject" placeholder="Enter something..."/>
                <Button type="ghost" shape="circle" icon="ios-search" @click="searchSubject">Search</Button>
            </div>

            <!-- content grid start -->
            <div class="margin-top-48">
              <div class="row-padding">
                <div class="col l9 s12">
                  <itemCard v-for="item in cardlist" v-bind:item="item"/>
                </div>
                <div class="col l3 s0">
                  <sideBanner v-bind:sidelist="sidelist"/>
                </div>
              </div>
            </div>
            <!-- content grid end -->
        </Row>
        <Row>

        </Row>
    </div>
</template>

<script>
import itemCard from './../components/itemCard'
import sideBanner from './../components/sideBanner'

export default {
  data () {
    return {
        cardlist: '',
        sidelist: [
          {itemText: 'Create your own timeline!', itemUrl: '#'},
          {itemText: 'What is latest news?', itemUrl: '#'},
          {itemText: 'Tips', itemUrl: '#'}
        ],
        searchKey: ''
    }
  },
  components: {
    itemCard: itemCard,
    sideBanner: sideBanner
  },
  mounted: function () {
    this.onMainPageLoaded();
  },
  methods: {
    onMainPageLoaded: function () {
      this.$http.get('/subject/list?pageNum=1').then(response => {
           this.cardlist = response.data;
      }, response => {
          console.log("error");
      });
    },
    searchSubject: function () {
      this.$router.push({ name: '/search', params: { value:this.searchKey }})
    }
  }
}
</script>

<style>
</style>
