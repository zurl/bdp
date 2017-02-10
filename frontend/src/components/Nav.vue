<template>
    <el-menu default-active="2" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" theme="dark">
        <router-link to="/admin/status">
            <el-menu-item index="1-1">运行状态</el-menu-item>
        </router-link>
        <router-link to="/admin/basic-setting">
            <el-menu-item index="1-1">基本配置</el-menu-item>
        </router-link>
        <router-link to="/admin/task">
            <el-menu-item index="1-1">任务管理</el-menu-item>
        </router-link>
        <router-link to="/admin/template">
            <el-menu-item index="1-1">采集模板设置</el-menu-item>
        </router-link>
        <router-link to="/admin/search">
            <el-menu-item index="1-1">数据检索</el-menu-item>
        </router-link>

        <router-link to="/admin/proxy">
            <el-menu-item index="1-1">代理IP管理</el-menu-item>
        </router-link>

        <router-link to="/admin/metadata">
            <el-menu-item index="1-1">元数据采集管理</el-menu-item>
        </router-link>
    </el-menu>
</template>
<script>

</script>
<style>
    a:link {
        text-decoration: none;
    }

    a:visited {
        text-decoration: none;
    }

    a:hover {
        text-decoration: none;
    }

    a:active {
        text-decoration: none;
    }

    .router-link-active li {
        background-color: green;
    }
</style>
