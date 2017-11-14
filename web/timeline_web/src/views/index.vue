<style scoped>
    .layout {
        border: 1px solid #d7dde4;
        background: #f5f7f9;
    }

    .layout-logo{
        width: 30px;
        height: 30px;
        #background: #f8f8f9;
        border-radius: 3px;
        float: left;
        position: relative;
        top: 15px;
        left: 20px;
        text-align: center;
    }

    .layout-login {
        width: 100px;
        height: 30px;
        border-radius: 3px;
        float: right;
        position: relative;
        top: 15px;
        right: 20px;
    }

    .layout-nav {
        width: 525px;
        margin: 0 auto;
    }

    .layout-breadcrumb {
        padding: 10px 15px 0;
    }

    .layout-content {
        min-height: 200px;
        margin: 15px;
        overflow: hidden;
        background: #fff;
        border-radius: 4px;
    }

    .layout-content-main {
        padding: 10px;
    }

    .layout-copy {
        text-align: center;
        padding: 10px 0 20px;
        color: #9ea7b4;
    }
</style>
<template>
    <div class="layout">
        <Row>
            <Menu mode="horizontal" theme="dark" active-name="1">
                <!-- Logo -->
                <div>
                    <img src="data:image/png;base64,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" class="layout-logo"></img>
                </div>
                <div class="layout-nav">
                    <MenuItem name="1">
                        <Icon type="ios-navigate"></Icon>
                        首页
                    </MenuItem>
                    <MenuItem name="2">
                        <Icon type="ios-keypad"></Icon>
                        我的关注
                    </MenuItem>
                    <MenuItem name="3">
                        <Icon type="ios-analytics"></Icon>
                        专题分类
                    </MenuItem>
                    <MenuItem name="4">
                        <Icon type="ios-paper"></Icon>
                        关于我们
                    </MenuItem>
                </div>
                <div class="">
                    <Button class="layout-login">Sign in/Sign up</Button>
                </div>
            </Menu>
            <div class="layout-breadcrumb">
                <Breadcrumb>
                    <BreadcrumbItem href="#">Home</BreadcrumbItem>
                    <BreadcrumbItem href="#">Projects</BreadcrumbItem>
                    <BreadcrumbItem>iView</BreadcrumbItem>
                </Breadcrumb>
            </div>
        </Row>
        <Row>
            <div class="layout-content">
                <div class="layout-content-main">
                    <router-view></router-view>
                </div>
            </div>
        </Row>

        <Row>
            <div class="layout-copy">
                2011-2016 &copy; TalkingData
            </div>
        </Row>
    </div>
</template>
<script>
    export default {}
</script>
