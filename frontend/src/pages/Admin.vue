<template>
    <div>
        <el-col :span="6">
            <my-nav></my-nav>
        </el-col>
        <el-col :span="18">
            <router-view>
            </router-view>
        </el-col>
    </div>
</template>
<script>
    import MyNav from '../components/Nav.vue'
export default {
    components: {
        'my-nav': MyNav
    }
}
</script>
<style>

</style>