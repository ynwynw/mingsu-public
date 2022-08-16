import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Register from '../views/Register.vue'
import axios from '../axios'
import store from '../store'

Vue.use(VueRouter)

const routes = [{
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/login',
        name: 'login',
        component: () =>
            import ('../views/Login.vue')
    }, {
        path: '/personalcenter',
        name: 'personalcenter',
        component: () =>
            import ('../views/PersonalCenter.vue')
    },{
        path: '/register',
        name: 'Register',
        component: Register
    }, {
        path: '/huang',
        name: 'huang',
        component: () =>
            import ('../views/common/huang.vue')
    }, {
        path: '/test',
        name: 'test',
        component: () =>
            import ('../views/common/test.vue')
    }, {
        path: '/entityUser',
        name: 'entityUser',
        component: () =>
            import ('../views/EntityUser.vue')
    },{
        path: '/Ydms',
        name: 'Ydms',
        component: () =>
            import ('../views/EntityUser11.vue')
    }, {
        path: '/detailUser',
        name: 'detailUser',
        component: () =>
            import ('../views/DetailUser.vue')
    }, {
        path: '/relationJqUser',
        name: 'relationJqUser',
        component: () =>
            import ('../views/RelationJqUser.vue')
    }, {
        path: '/relationMsUser',
        name: 'relationMsUser',
        component: () =>
            import ('../views/RelationMsUser.vue')
    }, {
        path: '/commentUser',
        name: 'commentUser',
        component: () =>
            import ('../views/CommentUser.vue')
    }, {
        path: '/bcakstage',
        name: 'bcakstage',
        component: () =>
            import ('../views/background/Backstage.vue'),
        children: [{
                path: '/index',
                name: 'index',
                component: () =>
                    import ('../views/background/Index.vue')
            }, {
                path: '/userList',
                name: 'userList',
                component: () =>
                    import ('../views/background/UserList.vue')
            }, {
                path: '/comment',
                name: 'comment',
                component: () =>
                    import ('../views/background/Comment.vue')
            }, {
                path: '/entity',
                name: 'entity',
                component: () =>
                    import ('../views/background/Entity.vue')
            }, {
                path: '/detailUserAdmin',
                name: 'detailUserAdmin',
                component: () =>
                    import ('../views/background/DetailUserAdmin.vue')
            },{
                path: '/relationJq',
                name: 'relationJq',
                component: () =>
                    import ('../views/background/RelationJq.vue')
            }, {
                path: '/relationMs',
                name: 'relationMs',
                component: () =>
                    import ('../views/background/RelationMs.vue')
            }, {
                path: '/news',
                name: 'news',
                component: () =>
                    import ('../views/background/News.vue')
            }
        ]
    }, {
        path: '*',
        name: '404',
        component: () =>
            import ('../views/common/Error404.vue')
    },

]

const router = new VueRouter({
    mode: 'history', //去地址中的#
    routes
})


//路由守卫
router.beforeEach((to, from, next) => {

    let token = localStorage.getItem("token")

    if (to.path == '/login') {
        next()
    } else if (to.path == '/register') {
        next()
    } else if (!token) {
        next({ path: '/login' })
    } else if (token) {
        axios.get("/user/auth", {
            headers: {
                Authorization: localStorage.getItem("token")
            }
        }).then(res => {
            //console.log(res.data.data)
            // 拿到用户权限
            store.commit("setPermList", res.data.data.authoritys)
        })
    }
    next();
})




export default router