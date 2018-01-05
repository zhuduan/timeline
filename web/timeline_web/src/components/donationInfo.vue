<template>
    <div>
        <Button type="primary" @click="modal1 = true" shape="circle" size="large">赞赏</Button>
        <Modal v-model="modal1" :title="donationTo" @on-ok="ok" @on-cancel="cancel">
            <Collapse accordion v-model="collapseValue">
                <Panel name="alipay">
                    支付宝打赏
                    <p slot="content">
                        <img src="../img/alipay.jpg" style="width:100%" />
                    </p>
                </Panel>
                <Panel name="wechat">
                    微信打赏
                    <p slot="content">
                        <img src="../img/wechat.jpg" style="width:100%" />
                    </p>
                </Panel>
            </Collapse>
        </Modal>
    </div>
</template>
<script>
    export default {
        data () {
            return {
                modal1: false,
                collapseValue: 'wechat'
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