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
                <el-table-column prop="entityName" label="民宿名称" width="300" align="center"></el-table-column>
                <el-table-column prop="userName" label="预订人" width="300" align="center"></el-table-column>
                <el-table-column prop="detailDate" label="预订日期" width="300" align="center"></el-table-column>
                <el-table-column prop label="操作" align="center" show-overflow-tooltip>
                    <template slot-scope="scope">
                        <template>
                            <el-popconfirm title="确定删除？" @confirm="delButton(scope.row.id)">
                                <el-button type="danger" size="small" slot="reference">删除</el-button>
                            </el-popconfirm>
                        </template>
                    </template>
                </el-table-column>
            </el-table>

        

           
        </div>
    </div>
</template>

<script>
export default {
    name: 'news',
    data() {
        return {
            editVisible: false,
            addVisible: false,
            tableData: [],
            searchForm: {},
            addForm: {},
            editForm: {}
        };
    },
    methods: {
        getTableData() {
            let _this = this
            var name = $(".loginbtn").innerText;
            _this.$axios.post('/detail/getDataList', {userName: name}).then(res => {
                _this.tableData = res.data.data;
            });
        },
        
        delButton(params) {
            let _this = this
            _this.$axios.post('/detail/delData', {id: params}).then(res => {
                _this.$message({
                    showClose: true,
                    message: '删除成功',
                    type: 'success',
                });
                _this.getTableData();
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
