<template>
    <div id="app">
        <router-view>
        </router-view>
    </div>
</template>

<script>
    export default {
        data () {
            return {
                msg: 'A Tiny Test of website'
            }
        },

        methods: {
            startHacking () {
                this.$notify({
                    title: 'It Works',
                    message: 'We have laid the groundwork for you. Now it\'s your time to build something epic!',
                    duration: 6000
                })
            }
        }
    }
</script>

<style>
    body {
        font-family: Helvetica, sans-serif;
    }
</style>
