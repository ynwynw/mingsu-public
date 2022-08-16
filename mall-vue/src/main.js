import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/element.js'
import axios from './axios.js'
import global from './globalFun'

import animated from 'animate.css'

Vue.use(animated)
Vue.config.productionTip = false

Vue.prototype.$axios = axios
    //require("./mock.js")

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')