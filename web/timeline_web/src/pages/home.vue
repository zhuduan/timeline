<template>
  <Row style="text-align: center;">
    <div class="margin-top home-container">

      <!-- personal brief -->
      <div class="brief">
        <div class="row-padding">

          <!-- first row -->
          <div class="col l2 s12">
            <div class="container">
              <img class="circle" src="https://unsplash.it/300/200?image=1005" width="80" height="80" alt="author" ><br>
              <button class="btn margin-top" type="button" name="button">设置</button>
            </div>
          </div>

          <!-- second row -->
          <div class="col l6 s12">
            <div class="container">
              <ul class="list">
                <li><h2 class="user-name">dkhumanbeat</h2></li>
                <li><h4>二流程序员，二流极客，二流子</h4></li>
                <li>
                  <i class="fa fa-user margin-right"> 男，23岁</i>
                  <i class="fa fa-map-marker margin-right"> 四川，成都</i>
                  <i class="fa fa-clock-o margin-right"> 加入iView 158 天</i>
                </li>
              </ul>
            </div>
          </div>

          <!-- third row -->
          <div class="col l4 s12 post-container">
            <div class="post-d">
              <a href="#">
                <div class="border circle post-l" style="width: 50px; height: 50px;">
                  <i class="post-i fa fa-th" aria-hidden="true"></i>
                </div>
                <div class="post-l">贡献</div>
                <div class="post-l">0</div>
              </a>
            </div>
            <div class="post-d">
              <a href="#">
                <div class="border circle post-l" style="width: 50px; height: 50px;">
                  <i class="post-i fa fa-th" aria-hidden="true"></i>
                </div>
                <div class="post-l">回复</div>
                <div class="post-l">12</div>
              </a>
            </div>
          </div>
        </div>
      </div>

      <!-- personal details -->
      <div class="details-container">
        <div class="row-padding">

          <!-- first row -->
          <div class="col l8 s12">
            <collectionList/>
          </div>

          <!-- second row -->
          <div class="col l4 s12">
          </div>

        </div>
      </div>

    </div>
  </Row>
</template>

<script>
import collectionList from './../components/collectionList'
export default {
  components: {
    collectionList: collectionList
  }
}
</script>

<style>
</style>
