<template>
    <div>
        <div class="softdiv">
            <el-input clearable placeholder="请输入用户名" style="width: 300px; margin: 20px 20px;" v-model="input" class="input-with-select">
                <el-button slot="append" icon="el-icon-search" @click="selectUser()"></el-button>
            </el-input>
            <el-button type="primary" @click="addvisible = true">添加用户</el-button>

            <el-table
                ref="multipleTable"
                :data="tableData"
                tooltip-effect="dark"
                style="width: 100%;margin-top: 20px;"
                border
                stripe
                @selection-change="handleSelectionChange"
            >
                <el-table-column type="selection" align="center" width="55"></el-table-column>
                <el-table-column prop="userId" label="用户id" width="70" align="center"></el-table-column>
                <el-table-column prop="name" label="用户名" width="100" align="center"></el-table-column>
                <el-table-column prop="pass" label="密码" align="center"></el-table-column>
                <el-table-column prop="phone" label="手机号" width="120" align="center"></el-table-column>
                <el-table-column prop="address" label="居住地" width="120" align="center"></el-table-column>
                <el-table-column prop="sex" label="性别" width="50" align="center"></el-table-column>
                <el-table-column prop="age" label="年龄" width="50" align="center"></el-table-column>
                <el-table-column prop="isBusiness" label="角色" width="80" align="center">
                    <template slot-scope="scope">
                        <el-tag type="success" v-if="scope.row.isBusiness == 1">店 铺</el-tag>
                        <el-tag v-else-if="scope.row.isBusiness == 0">买 家</el-tag>
                    </template>
                </el-table-column>
                <el-table-column prop="email" label="邮箱" align="center"></el-table-column>
                <el-table-column prop label="操作" align="center" show-overflow-tooltip>
                    <template slot-scope="scope">
                        <el-button style="margin-right: 7px" type="success" size="small" @click="visible = true">
                            编辑
                        </el-button>

                        <template>
                            <el-popconfirm title="确定删除该用户吗？" @confirm="delHandle(scope.row.userId)">
                                <el-button type="danger" size="small" slot="reference">删除</el-button>
                            </el-popconfirm>
                        </template>
                    </template>
                </el-table-column>
            </el-table>

            <!-- 批量操作 -->
            <template>
                <el-popconfirm title="确定删除所选择用户吗？" @confirm="delHandle(null)">
                    <el-button style="margin: 20px 20px; float: right" :disabled="selectionstatus" type="danger" slot="reference">批量删除</el-button>
                </el-popconfirm>
            </template>

            <!-- 编辑框 -->
            <el-dialog title="编辑用户" :visible.sync="visible" width="40%" center>
                <el-form
                    style="margin-left: 70px"
                    label-position="left"
                    :model="infoForm"
                    :rules="rules"
                    ref="infoForm"
                    label-width="110px"
                    hide-required-asterisk
                >
                    <el-form-item label="用户ID" prop="userId" style="width: 380px;">
                        <el-input placeholder="必填" v-model="infoForm.userId"></el-input>
                    </el-form-item>
                    <el-form-item label="用户名称" prop="name" style="width: 380px;">
                        <el-input v-model="infoForm.name"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="pass" style="width: 380px;">
                        <el-input v-model="infoForm.pass"></el-input>
                    </el-form-item>
                    <el-form-item label="性别" prop="sex" style="width: 380px;">
                        <el-input v-model="infoForm.sex"></el-input>
                    </el-form-item>
                    <el-form-item label="手机号" prop="phone" style="width: 380px;">
                        <el-input v-model="infoForm.phone"></el-input>
                    </el-form-item>
                    <el-form-item label="居住地" prop="address" style="width: 380px;">
                        <el-input v-model="infoForm.address"></el-input>
                    </el-form-item>
                    <el-form-item label="年龄" prop="age" style="width: 380px;">
                        <el-input v-model="infoForm.age"></el-input>
                    </el-form-item>
                    <el-form-item label="角色" prop="isBusiness" style="width: 380px;">
                        <el-input placeholder="1为店家，0为买家" v-model="infoForm.isBusiness"></el-input>
                    </el-form-item>
                    <el-form-item label="邮箱" prop="email" style="width: 380px;">
                        <el-input v-model="infoForm.email"></el-input>
                    </el-form-item>
                </el-form>
                <span slot="footer" class="dialog-footer">
                    <el-button @click="resetForm('infoForm')">重 置</el-button>
                    <el-button type="primary" @click="update()">修 改</el-button>
                </span>
            </el-dialog>

            <!-- 添加用户框 -->
            <el-dialog title="添加用户" :visible.sync="addvisible" width="40%" center>
                <el-form
                    style="margin-left: 70px"
                    label-position="left"
                    :model="addinfoForm"
                    :rules="rules"
                    ref="addinfoForm"
                    label-width="110px"
                    hide-required-asterisk
                >
                    <el-form-item label="用户名称" prop="name" style="width: 380px;">
                        <el-input v-model="addinfoForm.name"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="pass" style="width: 380px;">
                        <el-input v-model="addinfoForm.pass"></el-input>
                    </el-form-item>
                    <el-form-item label="性别" prop="sex" style="width: 380px;">
                        <el-input v-model="addinfoForm.sex"></el-input>
                    </el-form-item>
                    <el-form-item label="手机号" prop="phone" style="width: 380px;">
                        <el-input v-model="addinfoForm.phone"></el-input>
                    </el-form-item>
                    <el-form-item label="居住地" prop="address" style="width: 380px;">
                        <el-input v-model="addinfoForm.address"></el-input>
                    </el-form-item>
                    <el-form-item label="年龄" prop="age" style="width: 380px;">
                        <el-input v-model="addinfoForm.age"></el-input>
                    </el-form-item>
                    <el-form-item label="角色" prop="isBusiness" style="width: 380px;">
                        <el-input placeholder="1为店家，0为买家" v-model="addinfoForm.isBusiness"></el-input>
                    </el-form-item>
                    <el-form-item label="邮箱" prop="email" style="width: 380px;">
                        <el-input v-model="addinfoForm.email"></el-input>
                    </el-form-item>
                </el-form>
                <span slot="footer" class="dialog-footer">
                    <el-button @click="resetForm('addinfoForm')">重 置</el-button>
                    <el-button type="primary" @click="addbtn()">添 加</el-button>
                </span>
            </el-dialog>
        </div>
    </div>
</template>

<script>
export default {
    name: 'UserList',
    data() {
        return {
            input: '',
            visible: false,
            addvisible: false,
            drawer: false,
            multipleSelection: [],
            selectionstatus: true,
            tableData: [],
            infoForm: {},
            addinfoForm: {},
            rules: {
                name: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
                pass: [{ required: true, message: '请输入密码', trigger: 'blur' }],
                sex: [{ required: true, message: '请输入性别', trigger: 'blur' }],
                age: [{ required: true, message: '请输入年龄', trigger: 'blur' }],
                phone: [{ required: true, message: '请输入手机号', trigger: 'blur' }],
                address: [{ required: true, message: '请输入居住地', trigger: 'blur' }],
                isBusiness: [{ required: true, message: '请输入角色', trigger: 'blur' }],
                email: [{ required: true, message: '请输入邮箱', trigger: 'blur' }],
            },
        };
    },
    methods: {
        toggleSelection(rows) {
            if (rows) {
                rows.forEach(row => {
                    this.$refs.multipleTable.toggleRowSelection(row);
                });
            } else {
                this.$refs.multipleTable.clearSelection();
            }
        },
        handleSelectionChange(val) {
            this.multipleSelection = val;
            this.selectionstatus = val.length == 0;
        },
        getTableData() {
            this.$axios.get('/user/list').then(res => {
                this.tableData = res.data.data;
            });
        },
        selectUser() {
            this.$axios.get('/user/select/' + this.input).then(res => {
                this.tableData = res.data.data;
            });
        },
        addbtn() {
            this.$axios.post('/user/save', this.addinfoForm).then(res => {
                this.$message({
                    showClose: true,
                    message: '添加成功',
                    type: 'success',
                });
                this.getTableData();
            });
            this.addvisible = false;
        },
        update() {
            this.$axios.post('/user/houUpdate', this.infoForm).then(res => {
                this.$message({
                    showClose: true,
                    message: '修改成功',
                    type: 'success',
                });
                this.getTableData();
            });
            this.visible = false;
        },
        delHandle(id) {
            var ids = [];
            if (id) {
                ids.push(id);
            } else {
                this.multipleSelection.forEach(row => {
                    ids.push(row.userId);
                });
            }
            console.log(ids);
            this.$axios.post('/user/delete', ids).then(res => {
                this.$message({
                    showClose: true,
                    message: '删除成功',
                    type: 'success',
                });
                this.getTableData();
            });
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
        },
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
