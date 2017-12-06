<template>
  <Row style="text-align: center;">
    <div style="width: 90%; display: inline-block; overflow: auto;">
      <div class="index-logo" style="font-size: x-large;">
        <h1>{{this.subjectTitle}}</h1>
        <h3 class="subject-detail">编辑作者{{this.author}} | 最近修改时间： {{this.latestUpdateTime}}</h3>
        <button class="btn white" style="float: right; margin: 0 0 0 10px;">贡献内容</button>
        <button class="btn white" style="float: right; margin: 0 0 0 10px;">关注</button>
      </div>
      <hr />
      <div id='timeline-embed' style="width: 100%; height: 600px;"></div>
    </div>
  </Row>
</template>

<script>
export default {
  data () {
    return {
        subjectId: '',
        timelineData: '',
        subjectTitle: '',
        author: '',
        latestUpdateTime: ''
    }
  },
  mounted: function () {
    // this.loadJS();
    this.subjectId = this.$route.params.value;
    this.loadDetail();
  },
  methods: {
    loadDetail: function () {
      var querystring = 'http://localhost:8080/subject/info';
      this.$http.get(querystring,
        {
          params: {
            subjectID: this.subjectId
          },
          headers: {'Content-Type': 'application/text; charset=UTF-8'}
        }).then(
          response => {
             this.timelineData = this.assembleTimeline(response.data);
             this.loadTimeline();
        }, response => {
            console.log("error");
        });
    },
    loadTimeline: function () {
      timeline = new TL.Timeline('timeline-embed',this.timelineData);
    },
    // loadJS: function () {
    //   const s = document.createElement('script');
    //   s.type = 'text/javascript';
    //   s.src = 'https://cdn.knightlab.com/libs/timeline3/latest/js/timeline-min.js';
    //   document.body.appendChild(s);
    // },
    assembleTimeline: function (responseData) {
      var timeline = {title: '', events: ''};
      var title = {text: '', media: ''};
      var eventGroup = {media: '', text: '', start_date: ''};
      var eventGroupArray = [];
      var detailDate;
      var media = {url: '', caption: '', credit: ''};
      var text = {text: '', headline: ''};
      var start_date = {day: '', month: '', year: ''};

      media.url = responseData.picUrl;
      media.caption = responseData.picDes;
      media.credit = responseData.content;
      text.text = responseData.content;
      text.headline = responseData.title;
      title.media = media;
      title.text = text;
      timeline.title = title;

      for (var i = 0; i < responseData.details.length; i++)
      {
        media = {url: '', caption: '', credit: ''};
        text = {text: '', headline: ''};
        start_date = {day: '', month: '', year: ''};
        eventGroup = {media: '', text: '', start_date: ''};

        media.url = responseData.details[i].picUrl;
        media.caption = responseData.details[i].title;
        media.credit = responseData.details[i].picDes;
        detailDate = new Date(responseData.details[i].occurrenceTime);
        start_date.day = detailDate.getDate();
        start_date.month = detailDate.getMonth();
        start_date.year = detailDate.getFullYear();
        text.headline = responseData.details[i].title;
        text.text = responseData.details[i].content;
        eventGroup.media = media;
        eventGroup.start_date = start_date;
        eventGroup.text = text;
        eventGroupArray.push(eventGroup);
      }
      this.latestUpdateTime = responseData.details[responseData.details.length-1].occurrenceTime
      timeline.events = eventGroupArray;
      this.subjectTitle = timeline.title.text.headline;
      return timeline;
    }
  }
}
</script>

<style>
</style>
