<template>
  <div>
    <Row style="text-align: center;">
        <div class="index-logo" style="font-size: x-large;"><h1>Search result</h1></div>
        <div class="index-search">
            <input v-model="value" class="ivu-inputbox" placeholder="Enter something..."/>
            <router-link :to="{ path: '/search', params: {} }"><Button type="ghost" shape="circle" icon="ios-search">Search</Button></router-link>
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
        cardlist: [
          {titleImage: 'https://timeline.knightlab.com/static/img/examples/thumbs/thumb_mandela.jpg', subTitleImage: 'https://timeline.knightlab.com/static/img/examples/logos/logo_time.png', itemDes: 'Mandela: A Life of Purpose', itemUrl: '#'},
          {titleImage: 'https://timeline.knightlab.com/static/img/examples/thumbs/thumb_mandela.jpg', subTitleImage: 'https://timeline.knightlab.com/static/img/examples/logos/logo_time.png', itemDes: 'Mandela: A Life of Purpose', itemUrl: '#'},
          {titleImage: 'https://timeline.knightlab.com/static/img/examples/thumbs/thumb_mandela.jpg', subTitleImage: 'https://timeline.knightlab.com/static/img/examples/logos/logo_time.png', itemDes: 'Mandela: A Life of Purpose', itemUrl: '#'},
          {titleImage: 'https://timeline.knightlab.com/static/img/examples/thumbs/thumb_mandela.jpg', subTitleImage: 'https://timeline.knightlab.com/static/img/examples/logos/logo_time.png', itemDes: 'Mandela: A Life of Purpose', itemUrl: '#'},
          {titleImage: 'https://timeline.knightlab.com/static/img/examples/thumbs/thumb_mandela.jpg', subTitleImage: 'https://timeline.knightlab.com/static/img/examples/logos/logo_time.png', itemDes: 'Mandela: A Life of Purpose', itemUrl: '#'},
          {titleImage: 'https://timeline.knightlab.com/static/img/examples/thumbs/thumb_mandela.jpg', subTitleImage: 'https://timeline.knightlab.com/static/img/examples/logos/logo_time.png', itemDes: 'Mandela: A Life of Purpose', itemUrl: '#'},
          {titleImage: 'https://timeline.knightlab.com/static/img/examples/thumbs/thumb_mandela.jpg', subTitleImage: 'https://timeline.knightlab.com/static/img/examples/logos/logo_time.png', itemDes: 'Mandela: A Life of Purpose', itemUrl: '#'},
          {titleImage: 'https://timeline.knightlab.com/static/img/examples/thumbs/thumb_mandela.jpg', subTitleImage: 'https://timeline.knightlab.com/static/img/examples/logos/logo_time.png', itemDes: 'Mandela: A Life of Purpose', itemUrl: '#'},
          {titleImage: 'https://timeline.knightlab.com/static/img/examples/thumbs/thumb_mandela.jpg', subTitleImage: 'https://timeline.knightlab.com/static/img/examples/logos/logo_time.png', itemDes: 'Mandela: A Life of Purpose', itemUrl: '#'},
          {titleImage: 'https://timeline.knightlab.com/static/img/examples/thumbs/thumb_mandela.jpg', subTitleImage: 'https://timeline.knightlab.com/static/img/examples/logos/logo_time.png', itemDes: 'Mandela: A Life of Purpose', itemUrl: '#'},
          {titleImage: 'https://timeline.knightlab.com/static/img/examples/thumbs/thumb_mandela.jpg', subTitleImage: 'https://timeline.knightlab.com/static/img/examples/logos/logo_time.png', itemDes: 'Mandela: A Life of Purpose', itemUrl: '#'}
        ],
        sidelist: [
          {itemText: 'Create your own timeline!', itemUrl: '#'},
          {itemText: 'What is latest news?', itemUrl: '#'},
          {itemText: 'Tips', itemUrl: '#'}
        ]
    }
  },
  components: {
    itemCard: itemCard,
    sideBanner: sideBanner
  }
}
</script>

<style>
</style>
