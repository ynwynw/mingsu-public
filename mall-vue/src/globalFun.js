// 全局判断是否有权限方法
import Vue from "vue"

Vue.mixin({
    methods: {
        hasAuth(perm) {
            var authority = this.$store.state.permList

            //console.log("权限为" + authority)
            // perm权限参数是否在authority数组中 authority.indexOf(perm) > -1为true：表示有该权限
            return authority.indexOf(perm) > -1
        }
    }
})