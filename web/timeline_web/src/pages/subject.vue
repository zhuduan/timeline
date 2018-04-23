<template>
    <Row style="text-align: center;">
        <div style="width: 90%; display: inline-block; overflow: auto;">
            <div class="index-logo" style="font-size: x-large;">
                <h1>{{this.subjectTitle}}</h1>
                <h3 class="subject-detail">编辑作者{{this.author}} | 最近修改时间： {{this.latestUpdateTime}}</h3>
                <button class="btn white btn-style" >贡献内容</button>
                <button class="btn white btn-style" v-if="isFocus == false" @click="focus">关注</button>
                <button class="btn white btn-style" v-else="isFocus == true" @click="unFocus">已关注</button>
            </div>
            <hr/>
            <div id='timeline-embed' style="width: 100%; height: 600px;"></div>
        </div>
    </Row>
</template>

<script>
    import TL from "../js/TL";
    import util from '../libs/util';

    export default {
        data() {
            return {
                subjectId: '',
                timelineData: '',
                subjectTitle: '',
                author: '',
                latestUpdateTime: '',
                timeline:null,
                isFocus:false
            }
        },
        mounted: function () {
            this.subjectId = this.$route.params.value;
            this.loadDetail();
            if (this.$root.$store.state.user.isLogin === true) {
                this.isSubjectFocus();
            }
        },
        methods: {
            // 加载 Subject 详情
            loadDetail: function () {
                var querystring = '/subject/info';
                this.$http.get(querystring, {
                        params: {
                            subjectID: this.subjectId
                        },
                        headers: {'Content-Type': 'application/text; charset=UTF-8'}
                    }).then(response => {
                        this.timelineData = this.assembleTimeline(response.data.data);
                        this.loadTimeline();
                    }, response => {
                        console.log("error: " + response);
                    });
            },
            
            // 关注相关
            focus: function () {
                var focusApi = "/focus/subject/on";
                this.$http.post(focusApi, util.getParams( { subjectID:this.subjectId }) ).then(response => {
                    if (response.data.data === true) {
                        this.isFocus = true;
                        this.$Notice.success({
                            title: "success",
                            desc: "关注成功",
                            duration: 2
                        });
                    } else {
                        this.$Notice.error({
                            title: "fail",
                            desc: "关注失败",
                            duration: 2
                        });
                    }
                })
            },

            unFocus: function () {
                var focusApi = "/focus/subject/off";
                this.$http.post(focusApi, util.getParams({ subjectID:this.subjectId })).then(response => {
                    if (response.data.data === true) {
                        this.isFocus = false;
                        this.$Notice.success({
                            title: "success",
                            desc: "取关成功",
                            duration: 2
                        });
                    } else {
                        this.$Notice.error({
                            title: "fail",
                            desc: "取关失败",
                            duration: 2
                        });
                    }
                })
            },

            isSubjectFocus: function () {
                var focusApi = "/focus/subject";
                this.$http.get(focusApi, {params: { subjectID:this.subjectId }}).then(response => {

                    if (response.data.data === true) {
                        this.isFocus = true;
                    }
                })
            },
            // 初始化 TimeLine 组件
            loadTimeline: function () {
                this.timeline = new TL.Timeline('timeline-embed', this.timelineData);
            },
            // 解析返回结果为 TimeLine 组件数据
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

                for (var i = 0; i < responseData.details.length; i++) {
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
                this.latestUpdateTime = responseData.details[responseData.details.length - 1].occurrenceTime;
                timeline.events = eventGroupArray;
                this.subjectTitle = timeline.title.text.headline;
                return timeline;
            }
        }
    }
</script>

<style>
    @import "./../css/timeline.css";
    .btn-style {
        float: right;
        margin: 0 0 0 10px;
    }
</style>
