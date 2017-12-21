<template>
    <div>
        <Button type="primary" @click="modal1 = true" shape="circle" size="large">赞赏</Button>
        <Modal v-model="modal1" :title="donationTo" @on-ok="ok" @on-cancel="cancel">
            <Collapse accordion v-model="collapseValue">
                <Panel name="alipay">
                    支付宝打赏
                    <p slot="content">
                        <img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513873324545&di=541c5eba403675e979f09bf623785657&imgtype=0&src=http%3A%2F%2Fimgq.duitang.com%2Fuploads%2Fitem%2F201502%2F07%2F20150207130259_2MPBs.thumb.224_0.jpeg" />
                    </p>
                </Panel>
                <Panel name="wechat">
                    微信打赏
                    <p slot="content">
                        <img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513873324545&di=541c5eba403675e979f09bf623785657&imgtype=0&src=http%3A%2F%2Fimgq.duitang.com%2Fuploads%2Fitem%2F201502%2F07%2F20150207130259_2MPBs.thumb.224_0.jpeg" />
                    </p>
                </Panel>
                <Panel name="paypale">
                    paypal打赏
                    <p slot="content">
                        <img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513873324545&di=541c5eba403675e979f09bf623785657&imgtype=0&src=http%3A%2F%2Fimgq.duitang.com%2Fuploads%2Fitem%2F201502%2F07%2F20150207130259_2MPBs.thumb.224_0.jpeg" />
                    </p>
                </Panel>
            </Collapse>
            <br/>
            <Input v-model="value" placeholder="给ta留言……" />
        </Modal>
    </div>
</template>
<script>
    export default {
        data () {
            return {
                modal1: false,
                collapseValue: 'alipay'
            }
        },
        props: {
            'donationTo': String
        },
        methods: {
            ok () {
                this.$Message.info('感谢您的赞赏');
            },
            cancel () {
                this.$Message.info('如果喜欢请支持我们');
            }
        }
    }
</script>