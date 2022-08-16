import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        token: '',
        permList: [],
    },
    mutations: {
        SET_TOKEN: (state, token) => {
            state.token = token
            localStorage.setItem("token", token)
        },
        setPermList(state, perms) {
            state.permList = perms
        },
    resetState: (state) => {
			state.permList = []
		}

    },

    actions: {},
    modules: {}
})