<template>
    <div>
        <div class="softdiv">
            <el-table
                ref="multipleTable"
                :data="tableData"
                tooltip-effect="dark"
                style="width: 100%;margin-top: 20px;"
                border
                stripe
            >
                <el-table-column type="selection" align="center" width="55"></el-table-column>
                <el-table-column prop="contant" label="内容" width="1000" align="center"></el-table-column>
                <el-table-column prop="userName" label="发表人" width="100" align="center"></el-table-column>
                <el-table-column prop="createDate" label="发表时间" width="200" align="center"></el-table-column>
            </el-table>
        </div>
    </div>
</template>

<script>
export default {
    name: 'comment',
    data() {
        return {
            tableData: []
        };
    },
    methods: {
        getTableData() {
            let _this = this
            _this.$axios.post('/comment/getDataList', {}).then(res => {
                _this.tableData = res.data.data;
            });
        }
    },
    created() {
        this.getTableData();
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
</style>
