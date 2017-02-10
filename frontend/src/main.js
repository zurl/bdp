import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-default/index.css'
import Vuex from 'vuex'
import VueRouter from 'vue-router'


import App from './App.vue'
import AdminPage from './pages/Admin.vue'
import TemplatePage from './pages/Template.vue'
import ProxyPage from './pages/Proxy.vue'
import StatusPage from './pages/Status.vue'
import TaskPage from './pages/Task.vue'
import BasicSettingPage from './pages/BasicSetting.vue'
import SearchPage from './pages/Search.vue'
import MetaDataPage from './pages/MetaData.vue'


const routes = [
    {
        path: '/admin',
        component: AdminPage,
        children: [
            {
                path: 'status',
                component: StatusPage
            },
            {
                path: 'basic-setting',
                component: BasicSettingPage
            },
            {
                path: 'search',
                component: SearchPage
            },
            {
                path: 'task',
                component: TaskPage
            },
            {
                path: 'proxy',
                component: ProxyPage
            },
            {
                path: 'template',
                component: TemplatePage
            },
            {
                path: 'metadata',
                component: MetaDataPage
            }
        ]
    }
];


const router = new VueRouter({
    routes
});

Vue.use(Vuex);
Vue.use(ElementUI);
Vue.use(VueRouter);

const store = new Vuex.Store({
    state: {
        count: 0
    },
    mutations: {
        increment (state) {
            state.count++
        }
    }
});


new Vue({
    el: '#app',
    router,
    render: h => h(App)
});
