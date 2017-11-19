<template>
    <div>
        <Row style="text-align: center;">
            <div class="index-logo" style="font-size: xx-large;"><h1>timeline<sup class="sup red">js</sup></h1></div>
            <span><h3>Sub title</h3></span>
            <br/>
            <div class="index-search">
                <input v-model="value" class="ivu-inputbox" placeholder="Enter something..."/>
                <Button type="ghost" shape="circle" icon="ios-search">Search</Button>
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
  @import "./../css/base.css";
  @import "./../css/timeline.css";
</style>
