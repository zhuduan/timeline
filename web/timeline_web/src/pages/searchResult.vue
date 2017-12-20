<template>
  <div>
    <Row style="text-align: center;">
        <div class="index-logo" style="font-size: x-large;"><h1>Search result</h1></div>
        <div class="index-search">
          <input v-model="searchKey" class="ivu-inputbox" v-on:keyup.enter="searchSubject" placeholder="Enter something..."/>
          <Button type="ghost" shape="circle" icon="ios-search" @click="searchSubject">Search</Button>
        </div>

        <!-- searchResult grid start -->
        <div class="margin-top-48">
          <div class="row-padding">
            <div class="col l12 m12 s12">
              <itemCard v-for="item in cardlist" v-bind:item="item"/>
            </div>
          </div>
        </div>
        <!-- searchResult grid end -->

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
        searchKey: ''
    }
  },
  components: {
    itemCard: itemCard,
    sideBanner: sideBanner
  },
  mounted: function () {
    this.searchKey = this.$route.params.value;
    this.onSearchPageLoaded();

  },
  methods: {
    onSearchPageLoaded: function () {
      var querystring = '/subject/search';
      this.$http.get(querystring,
        {
          params: {
                    key: this.searchKey,
                    pageNum: 1
                  },
          headers: {'Content-Type': 'application/text; charset=UTF-8'}
        }).then(
          response => {
            this.cardlist = response.data.data;
        }, response => {
            console.log("error");
        });
    },
    searchSubject: function () {
      console.log("searchKey in index page: "+this.searchKey);
      this.$router.push({ name: '/search', params: { value:this.searchKey }});
      this.onSearchPageLoaded();
    }
  },
  http: {
        root: '/',
        headers: {
            ContentType: 'application/text; charset=UTF-8'
        }
    }
}
</script>

<style>
</style>
