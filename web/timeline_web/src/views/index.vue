<template>
    <div>
        <Row>
            
            <div class="index-logo"></div>
            <br/>
            <div class="index-search">
                <Input v-model="value" placeholder="Enter something..." style="width: 300px"/>
                <Button type="ghost" shape="circle" icon="ios-search">Search</Button>
            </div>

        </Row>
        <Row>

        </Row>
    </div>
</template>

<script>
</script>

<style>
    .index-logo {
        width: 300px;
        height: 100px;
        border: 1px;
        border-radius: 5px;
        text-align: center;
        position: relative;
        left: 35%;
        background-color: black;
    }

    .index-search {
        position: relative;
        left: 35%;
    }
</style>
