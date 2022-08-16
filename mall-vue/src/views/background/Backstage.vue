<template>
    <el-container>
        <el-header>
            民宿在线管理系统后台管理系统
            <el-button style="margin-top: 10px; float: right; color: #FFF; background-color: #545c64" @click="logout()">退 出</el-button>
            <el-button style="margin: 10px 10px; float: right;" @click="toIndex()">返回前台</el-button>
        </el-header>
        <el-container>
            <el-aside style="background-color: #545c64" width="200px">
                <el-menu
                    default-active="/index"
                    class="el-menu-vertical-demo"
                    @open="handleOpen"
                    @close="handleClose"
                    background-color="#545c64"
                    text-color="#fff"
                    active-text-color="#ffd04b"
                    router
                >
                    <!-- <el-menu-item index="/index">
                        <i class="el-icon-tickets"></i>
                        <span slot="title">首页</span>
                    </el-menu-item> -->
                    <el-submenu index="2">
                        <template slot="title">
                            <i class="el-icon-goods"></i>
                            <span>民宿管理</span>
                        </template>
                        <el-menu-item index="/entity">民宿信息</el-menu-item>
                    </el-submenu>
                    <el-submenu index="3">
                        <template slot="title">
                            <i class="el-icon-user-solid"></i>
                            <span>民宿周边</span>
                        </template>
                        <el-menu-item index="/relationJq">民宿周边景区</el-menu-item>
                        <el-menu-item index="/relationMs">民宿周边美食</el-menu-item>
                    </el-submenu>
                    <el-submenu index="4">
                        <template slot="title">
                            <i class="el-icon-shopping-cart-2"></i>
                            <span>订单管理</span>
                        </template>
                        <el-menu-item index="/detailUserAdmin">订单列表</el-menu-item>
                    </el-submenu>
                    <el-submenu index="5">
                        <template slot="title">
                            <i class="el-icon-s-comment"></i>
                            <span>民宿交流</span>
                        </template>
                        <el-menu-item index="/comment">民宿交流</el-menu-item>
                    </el-submenu>
                    <el-submenu index="6">
                        <template slot="title">
                            <i class="el-icon-data-line"></i>
                            <span>城市新闻</span>
                        </template>
                        <el-menu-item index="/news">城市新闻</el-menu-item>
                    </el-submenu>
                     <el-submenu index="6">
                        <template slot="title">
                            <i class="el-icon-data-line"></i>
                            <span>用户管理</span>
                        </template>
                        <el-menu-item index="/userList">用户管理</el-menu-item>
                    </el-submenu>
                </el-menu>
            </el-aside>

            <el-main>
                <router-view></router-view>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
export default {
    name: 'Bcakstage',
    components: {},
    data() {
        return {};
    },
    created() {},
    methods: {
        toIndex() {
            this.$message({
                showClose: true,
                message: '返回成功',
                type: 'success',
            });
            this.$router.push('/');
        },
        logout() {
            this.$axios.post('/logout').then(res => {
                localStorage.clear();
                sessionStorage.clear();

                this.$store.commit('resetState');
                this.$message({
                    showClose: true,
                    message: '退出成功',
                    type: 'success',
                });

                this.$router.push('/login');
            });
        },
        handleOpen(key, keyPath) {},
        handleClose(key, keyPath) {},
    },
};
</script>

<style scoped>
.el-container {
    padding: 0;
    margin: 0;
    height: 100%;
}

.el-dropdown-link {
    cursor: pointer;
}

.el-header {
    background-color: #17b3a3;
    color: #333;
    text-align: center;
    line-height: 60px;
}

.el-main {
    color: #333;
    padding: 0;
}

a {
    text-decoration: none;
}
</style>
