<template>
    <div>
        <div class="softdiv">
            <section class="data_section">
                <header class="section_title">数据统计</header>
                <el-row :gutter="20" style="margin-bottom: 10px;">
                    <el-col :span="4">
                        <div class="data_list today_head"><span class="data_num head">当日数据：</span></div>
                    </el-col>
                    <el-col :span="4">
                        <div class="data_list">
                            <span class="data_num">{{ userSum }}</span>
                            用户数
                        </div>
                    </el-col>
                    <el-col :span="4">
                        <div class="data_list">
                            <span class="data_num">{{ orderSum }}</span>
                            订单
                        </div>
                    </el-col>
                    <el-col :span="4">
                        <div class="data_list">
                            <span class="data_num">{{ commoditySum }}</span>
                            平台商品
                        </div>
                    </el-col>
                </el-row>
                <el-row :gutter="20">
                    <el-col :span="4">
                        <div class="data_list all_head"><span class="data_num head">总数据：</span></div>
                    </el-col>
                    <el-col :span="4">
                        <div class="data_list">
                            <span class="data_num">{{ userTotal }}</span>
                            注册用户
                        </div>
                    </el-col>
                    <el-col :span="4">
                        <div class="data_list">
                            <span class="data_num">{{ orderTotal }}</span>
                            订单
                        </div>
                    </el-col>
                    <el-col :span="4">
                        <div class="data_list">
                            <span class="data_num">{{ commodityTotal }}</span>
                            平台商品
                        </div>
                    </el-col>
                </el-row>
            </section>
            <div id="line" class="" style="width: 90%;height:450px;"></div>
        </div>
    </div>
</template>

<script>
import * as echarts from 'echarts';

export default {
    name: 'Index',
    data() {
        return {
            line: null,
            userSum: '',
            orderSum: '',
            commoditySum: '',
            userTotal: '',
            orderTotal: '',
            commodityTotal: '',
        };
    },
    created() {
        this.getInfo();
    },
    methods: {
        getInfo() {
            this.$axios.get('/user/sum').then(res => {
                this.userSum = res.data.data;
                this.userTotal = 200 + res.data.data;
            });
            this.$axios.get('/orderMaster/sum').then(res => {
                this.orderSum = res.data.data;
                this.orderTotal = 300 + res.data.data;
            });
            this.$axios.get('/commodity/sum').then(res => {
                this.commoditySum = res.data.data;
                this.commodityTotal = 293 + res.data.data;
            });
        },
        drawLine() {
            this.line = echarts.init(document.getElementById('line'));
            const colors = ['#5793f3', '#675bba', '#d14a61'];
            this.line.setOption({
                color: colors,
                title: {
                    text: '最近一周走势图',
                    subtext: '',
                },
                tooltip: {
                    trigger: 'axis',
                },
                legend: {
                    data: ['新注册用户', '新增订单', '新增管理员'],
                },
                toolbox: {
                    show: true,
                    feature: {
                        dataZoom: {
                            yAxisIndex: 'none',
                        },
                        dataView: { readOnly: false },
                        magicType: { type: ['bar', 'line'] },
                        restore: {},
                    },
                },
                xAxis: {
                    type: 'category',
                    boundaryGap: false,
                    data: ['9-21', '9-22', '9-23', '9-24', '9-25', '9-26', '9-27'],
                },
                yAxis: [
                    {
                        type: 'value',
                        name: '用户',
                        min: 0,
                        max: 200,
                        position: 'left',
                        axisLine: {
                            lineStyle: {
                                color: '#999',
                            },
                        },
                        axisLabel: {
                            formatter: '{value}',
                        },
                    },
                    {
                        type: 'value',
                        name: '订单',
                        min: 0,
                        max: 200,
                        position: 'right',
                        axisLine: {
                            lineStyle: {
                                color: '#999',
                            },
                        },
                        axisLabel: {
                            formatter: '{value}',
                        },
                    },
                ],
                series: [
                    {
                        name: '新注册用户',
                        type: 'line',
                        data: ['23', '35', '22', '38', '37', '88', '89'],
                        yAxisIndex: 1,
                        markPoint: {
                            data: [
                                { type: 'max', name: '最大值' },
                                { type: 'min', name: '最小值' },
                            ],
                        },
                    },
                    {
                        name: '新增订单',
                        type: 'line',
                        data: ['58', '88', '188', '199', '27', '100', '200'],
                        yAxisIndex: 1,
                        markPoint: {
                            data: [
                                { type: 'max', name: '最大值' },
                                { type: 'min', name: '最小值' },
                            ],
                        },
                    },
                    {
                        name: '新增管理员',
                        type: 'line',
                        data: ['45', '67', '55', '87', '133', '23', '84'],
                        yAxisIndex: 1,
                        markPoint: {
                            data: [
                                { type: 'max', name: '最大值' },
                                { type: 'min', name: '最小值' },
                            ],
                        },
                    },
                ],
            });
        },
    },
    mounted() {
        this.drawLine();
    },
};
</script>

<style lang="less" scoped>
.softdiv {
    width: 98%;
    height: 90%;
    border: 1px #e3e3e3 solid;
    margin: 10px 10px;
}
.data_section {
    margin-left: 200px;
    padding: 20px;
    margin-bottom: 40px;
    .section_title {
        //text-align: center;
        margin-left: 270px;
        font-size: 30px;
        margin-bottom: 10px;
    }
    .data_list {
        text-align: center;
        font-size: 14px;
        color: #666;
        border-radius: 6px;
        background: #e5e9f2;
        .data_num {
            color: #333;
            font-size: 26px;
        }
        .head {
            border-radius: 6px;
            font-size: 22px;
            padding: 4px 0;
            color: #fff;
            display: inline-block;
        }
    }
    .today_head {
        background: #ff9800;
    }
    .all_head {
        background: #20a0ff;
    }
}
</style>
