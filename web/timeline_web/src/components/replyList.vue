<template>
    <div>
        <Row v-for="item in replies">
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
                        <Button type="ghost" shape="circle" size="small">Circle</Button>
                        <Button type="ghost" shape="circle" size="small">Circle</Button>
                    </p>
                </Col>
            </Row>
            <br/>
            <Row v-for="subItem in item.subReplies">
                <Col span="2">
                    <span> &nbsp; </span>
                </Col>
                <Col span="22">
                    <span style="border-right: gray;">
                        <a :href="subItem.user.id">{{subItem.user.name}}</a> : 
                        &nbsp; &nbsp;
                        {{subItem.content}}
                    </span>
                    <hr style="BORDER-BOTTOM-STYLE: dashed"></hr>
                </Col>
            </Row>
            <br/>
            <hr></hr>
            <br/>
        </Row>
    </div>
</template>

<script>
    export default {
        data () {
            return {
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
                        },
                        {
                        subReplies: [],
                        content: "ccc",
                        id: 3,
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
                        },
                        {
                        subReplies: [],
                        content: "ccc",
                        id: 4,
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
            //alert("hello");
        },
        props: {
            'detailID': Number
        },
        methods: {
        }
    };
</script>

<style scoped>

</style>