<template>
    <div>
        <Row v-for="item in replies" v-if="item.user!=null">
            <input type="hidden" :value="item.id" />
            <Row>
                <Col span="2" style="text-align:center;">
                    <Avatar src="https://i.loli.net/2017/08/21/599a521472424.jpg" />
                </Col>
                <Col span="22">
                    <Row>
                        <span style="color:#464c5b;"><b>{{item.user.name}}</b></span>
                    </Row>
                    <Row>
                        <span style="color:#9ea7b4; font-size:10px;">{{item.createTime}}</span>
                    </Row>
                </Col>
            </Row>
            <br/>
            <Row>
                <Col span="24">
                    <p style="margin-left:4%;">
                        {{item.content}}
                    </p>
                    <br/>
                    <p style="margin-left:2%;">
                        <Button type="ghost" shape="circle" size="small" @click='showAddSubButton("subReplyButton"+item.id)'>回复</Button>
                        <Button type="ghost" shape="circle" size="small" @click="rmvReply(item.id)" :disabled="isAuthor(item.authorID)">删除</Button>
                    </p>
                </Col>
            </Row>
            <br/>
            <Row v-for="subItem in item.subReplies" v-if="subItem.user!=null">
                <Col span="2">
                    <span> &nbsp; </span>
                </Col>
                <Col span="22">
                    <span style="border-right: gray;">
                        <a :href="subItem.authorID">{{subItem.user.name}}</a> : 
                        &nbsp; &nbsp;
                        {{subItem.content}}
                    </span>
                    <hr style="BORDER-BOTTOM-STYLE: dashed"></hr>
                </Col>
            </Row>
            <br/>
            <div style="margin-left:8%; margin-right:8%; display: none" :id='"subReplyButton"+item.id'>
                <Input v-model="subReplyContent">
                    <Button slot="append" type="ghost" @click="addSubReply(item.id)">发送</Button>
                </Input>
            </div>
            <hr></hr>
            <br/>
        </Row>
        <div style="text-align: center;">
            <Page :current="pageNum" :total="totalSize" @on-change="showPage"></Page>
        </div>
        <br/>
        <Row>
            <p style="margin-left:1%; margin-right:1%; ">
                <Input v-model="replyContent">
                    <Button slot="append" type="ghost" @click="addReply()" >回复</Button>
                </Input>
            </p>
        </Row>
    </div>
</template>

<script>
    export default {
        data () {
            return {
                pageNum: 1,
                pageSize: 10,
                totalSize: 20,
                replyContent: '',
                subReplyContent:'',
                replies: [
                    {
                        subReplies: [
                            {
                            subReplies: [],
                            content: "cccdafsdfasdfa, 这是看看效果如何。。。 各个时代阿大阿大啊大大啊啊啊啊QQ嗯嗯去",
                            id: 2,
                            title: "hello4",
                            user: {
                                name: "Granado",
                                authority: 0,
                                id: 1,
                                email: null,
                                role: 0,
                                weiboAccount: null,
                                googleAccount: null,
                                phone: null,
                                picUrl: null,
                                wechatAccount: null
                            },
                            authorID: 1,
                            detailID: 1,
                            toReplyID: 5
                            }
                        ],
                        content: "cccdafsdfasdfa, 这是看看效果如何。。。 各个时代阿大阿大啊大大啊啊啊啊QQ嗯嗯去",
                        id: 5,
                        title: "hello1_change",
                        user: {
                            name: "Granado",
                            authority: 0,
                            id: 1,
                            email: null,
                            role: 0,
                            weiboAccount: null,
                            googleAccount: null,
                            phone: null,
                            picUrl: null,
                            wechatAccount: null
                        },
                        authorID: 1,
                        detailID: 1,
                        toReplyID: 0,
                        createTime: "2018-06-01 10:00:00"
                    },
                    {
                        subReplies: [],
                        content: "ccc",
                        id: 6,
                        title: "hello4",
                        user: {
                            name: "Granado",
                            authority: 0,
                            id: 1,
                            email: null,
                            role: 0,
                            weiboAccount: null,
                            googleAccount: null,
                            phone: null,
                            picUrl: null,
                            wechatAccount: null
                        },
                        authorID: 1,
                        detailID: 1,
                        toReplyID: 0,
                        createTime: "2018-06-01 10:00:00"
                    }
                ]
            }
        },
        mounted: function () {
            // alert("hello");
            // alert(this.detailID);
            this.getReplyList();
        },
        props: {
            'detailID': Number,
            'userID': Number
        },
        methods: {
            showPage(page){
                this.pageNum = page;
                this.getReplyList();
            },
            getReplyList: function () {
                let url = '/detail/reply/list?detailID='+ this.detailID
                    + '&pageNum=' + this.pageNum
                    + '&pageSize=' + this.pageSize;

                this.$http.get(url).then(response => {
                    if(response.data['status'] == 200) {
                        this.replies = response.data.data;
                        this.getTotalCount();
                    }
                }, response => {
                    console.log("error");
                });
            },
            getTotalCount: function () {
                let url = '/detail/reply/count/total?detailID='+ this.detailID;

                this.$http.get(url).then(response => {
                    if(response.data['status'] == 200) {
                        this.totalSize = response.data.data.total>this.pageSize ? response.data.data.total : this.pageSize;
                    }
                }, response => {
                    console.log("error");
                });
            },
            addReply: function () {
                if( this.userID<=0 || undefined==this.userID ){
                    this.showErrMsg("用户信息错误", "您需要先登录之后才能发送用户信息");
                }

                let url = '/detail/reply/info/new';
                this.$http.post(url, {
                    detailID: this.detailID,
                    title: '',
                    content: this.replyContent,
                    authorID: this.userID,
                    toReplyID: 0  
                }).then(response => {
                    if(response.data['status'] == 200) {
                        this.replies = this.getReplyList();
                        this.replyContent = '';
                    } 
                }, response => {
                    console.log("error");
                });
            },
            addSubReply: function(toReply) {
                if( this.userID<=0 || undefined==this.userID ){
                    this.showErrMsg("用户信息错误", "您需要先登录之后才能发送用户信息");
                }

                let url = '/detail/reply/info/new';
                this.$http.post(url, {
                    detailID: this.detailID,
                    title: '',
                    content: this.subReplyContent,
                    authorID: this.userID,  
                    toReplyID: toReply
                }).then(response => {
                    if(response.data['status'] == 200) {
                        this.replies = this.getReplyList();
                        this.subReplyContent = '';
                    }
                }, response => {
                    console.log("error");
                });
            },
            rmvReply: function(id) {
                if( this.userID<=0 || undefined==this.userID ){
                    this.showErrMsg("用户信息错误", "您需要先登录之后才能发送用户信息");
                }

                let url = '/detail/reply/info/delete';
                this.$http.delete(url,{
                    headers: {"Content-Type": "application/json"},
                    data: {
                        id: id,
                        authorID: this.userID
                    }
                }).then(response => {
                    if(response.data['status'] == 200) {
                        this.replies = this.getReplyList();
                    }
                }, response => {

                });
            },
            showAddSubButton: function(domId){
                document.getElementById(domId).style.display = "block";
            },
            showErrMsg: function(msgTitle, msgContent) {
                this.$Notice.error({
                    title: msgTitle,
                    desc: msgContent
                });
            },
            isAuthor: function(replyUserID){
                return replyUserID!=this.userID;
            }
        }
    };
</script>

<style scoped>

</style>