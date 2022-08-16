<template>
    <div>
        <div class="softdiv">
            <el-button type="primary" @click="addButton()">新增</el-button>
            <el-table
                ref="multipleTable"
                :data="tableData"
                tooltip-effect="dark"
                style="width: 100%;margin-top: 20px;"
                border
                stripe
            >
                <el-table-column type="selection" align="center" width="55"></el-table-column>
                <el-table-column prop="contant" label="新闻内容" width="900" align="center"></el-table-column>
                <el-table-column prop="createDate" label="发布时间" width="200" align="center"></el-table-column>
                <el-table-column prop label="操作" align="center" show-overflow-tooltip>
                    <template slot-scope="scope">
                        <el-button style="margin-right: 7px" type="success" size="small" @click="editButton(scope.row)">
                            编辑
                        </el-button>
                        <template>
                            <el-popconfirm title="确定删除？" @confirm="delButton(scope.row.id)">
                                <el-button type="danger" size="small" slot="reference">删除</el-button>
                            </el-popconfirm>
                        </template>
                    </template>
                </el-table-column>
            </el-table>

            <el-dialog title="编辑" :visible.sync="editVisible" width="40%" center>
                <el-form
                    style="margin-left: 70px"
                    label-position="left"
                    :model="editForm"
                    ref="editForm"
                    label-width="110px"
                    hide-required-asterisk
                >
                    <el-form-item label="id" prop="id" style="width: 380px;" v-show=false>
                        <el-input v-model="editForm.id"></el-input>
                    </el-form-item>
                    <el-form-item label="新闻内容" prop="contant" style="width: 500px;">
                        <el-input type="textarea" :rows="4" v-model="editForm.contant"></el-input>
                    </el-form-item>
                </el-form>
                <span slot="footer" class="dialog-footer">
                    <el-button type="primary" @click="saveEdit()">保存</el-button>
                </span>
            </el-dialog>

            <el-dialog title="新增" :visible.sync="addVisible" width="40%" center>
                <el-form
                    style="margin-left: 70px"
                    label-position="left"
                    :model="addForm"
                    ref="addForm"
                    label-width="110px"
                    hide-required-asterisk
                >
                   <el-form-item label="新闻内容" prop="contant" style="width: 500px;">
                        <el-input type="textarea" :rows="4" v-model="addForm.contant"></el-input>
                    </el-form-item>
                </el-form>
                <span slot="footer" class="dialog-footer">
                    <el-button type="primary" @click="saveAdd()">保存</el-button>
                </span>
            </el-dialog>
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
            _this.$axios.post('/news/getDataList', {}).then(res => {
                _this.tableData = res.data.data;
            });
        },
        addButton() {
            let _this = this
            _this.addVisible = true
        },
        editButton(params) {
            let _this = this
            _this.editForm = params
            _this.editVisible = true
        },
        saveAdd() {
            let _this = this
            _this.$axios.post('/news/saveData', _this.addForm).then(res => {
                _this.$message({
                    showClose: true,
                    message: '保存成功',
                    type: 'success',
                });
                _this.getTableData();
            });
            _this.addVisible = false;
        },
        saveEdit() {
            let _this = this
            _this.$axios.post('/news/saveData', _this.editForm).then(res => {
                _this.$message({
                    showClose: true,
                    message: '保存成功',
                    type: 'success',
                });
                _this.getTableData();
            });
            _this.editVisible = false;
        },
        delButton(params) {
            let _this = this
            _this.$axios.post('/news/delData', {id: params}).then(res => {
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
