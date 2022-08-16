<template>
    <div>
        <el-row :gutter="20">
            <el-col :span="5" style="padding: 0" v-for="(commodity, index) in commoditys" :key="index">
                <div class="box">
                    <img class="tu" :src="commodity.image" alt />
                    <a href @click.prevent="toDetail(commodity.id)" class="describe">
                        {{ commodity.operdescribe }}
                    </a>
                    <div class="price">￥{{ commodity.price }}</div>
                    <div class="shop">{{ commodity.shop }}</div>
                </div>
            </el-col>
        </el-row>
    </div>
</template>

<script>
export default {
    name: 'SortComputer',
    data() {
        return {
            visible: false,
            commoditys: [],
            infoForm: {},
            rules: {
                name: [{ required: true, message: '请输入商品名', trigger: 'blur' }],
                shop: [{ required: true, message: '请输入店铺名', trigger: 'blur' }],
                operdescribe: [{ required: true, message: '请输入商品的基本信息', trigger: 'blur' }],
                image: [{ required: true, message: '请输入商品图', trigger: 'blur' }],
                price: [{ required: true, message: '请输入商品价格', trigger: 'blur' }],
            },
            commodityType: '电脑',
        };
    },
    methods: {
        getCommoditys() {
            this.$axios.get('/commodity/queryByType/' + this.commodityType).then(res => {
                this.commoditys = res.data.data;
            });
        },
        toDetail(id) {
            this.$message({
                showClose: true,
                message: '已进入详情页面',
                type: 'success',
            });
            this.$router.push({
                name: 'detail',
                params: {
                    commodityId: id,
                },
            });
        },
    },
    created() {
        this.getCommoditys();
    },
};
</script>

<style lang="less" scoped>
.el-col {
    height: 320px;
    border-radius: 5px;
    margin: 15px 10px;
    background-color: white;
    position: relative;
    top: 20px;
    left: 55px;
    overflow: hidden; //不让溢出
    transition: all 0.6s;
}
.el-col:hover {
    box-shadow: 0px 15px 30px rgba(0, 0, 0, 0.5);
}
.box {
    width: 100%;
    height: 100%;
}
.tu {
    border-radius: 5px;
    width: 100%;
    height: 200px;
    margin-bottom: 10px;
    transition: all 0.6s; //变化速度
}
.tu:hover {
    transform: scale(1.1); //变化大小
}

.describe {
    font-size: 6px;
    margin: 10px;
    color: black;
    text-decoration: none; //去a标签下划线
}
.describe:hover {
    color: #409f60;
}
.price {
    color: red;
    position: absolute;
    bottom: 4px;
    left: 4px;
}
.shop {
    position: absolute;
    bottom: 4px;
    right: 4px;
}
.addbtn {
    margin-top: 60px;
    width: 150px;
    position: relative;
    left: 50%;
    transform: translate(-50%);
}
</style>
