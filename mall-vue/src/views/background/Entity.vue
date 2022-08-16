<template>
    <div>
        <div class="softdiv">
            <el-input
                clearable
                placeholder="请输入名称"
                style="width: 300px; margin: 20px 20px"
                v-model="searchForm.entityName"
                class="input-with-select"
            >
                <el-button slot="append" icon="el-icon-search" @click="searchButton()"></el-button>
            </el-input>
            <el-button type="primary" @click="addButton()">新增</el-button>
            <el-table ref="multipleTable" :data="tableData" tooltip-effect="dark" style="width: 100%; margin-top: 20px" border stripe>
                <el-table-column type="selection" align="center" width="55"></el-table-column>
                <el-table-column prop="entityName" label="民宿名称" width="120" align="center"></el-table-column>
                <el-table-column prop="entityDept" label="区域" width="120" align="center"></el-table-column>
                <el-table-column prop="entityPlace" label="地址" width="120" align="center"></el-table-column>
                <el-table-column prop="entityPeople" label="入住人数" align="center"></el-table-column>
                <el-table-column prop="entityPrice" label="价格" align="center"></el-table-column>
                <el-table-column label="图片" align="center">
                    <template slot-scope="scope">
                        <img :src="scope.row.image" style="height: 50px" />
                    </template>
                </el-table-column>
                <el-table-column prop="description" label="描述" align="center"></el-table-column>
                <el-table-column prop label="操作" align="center" show-overflow-tooltip>
                    <template slot-scope="scope">
                        <el-button style="margin-right: 7px" type="success" size="small" @click="editButton(scope.row)">编辑</el-button>
                        <template>
                            <el-popconfirm title="确定删除？" @confirm="delButton(scope.row.id)">
                                <el-button type="danger" size="small" slot="reference">删除</el-button>
                            </el-popconfirm>
                        </template>
                    </template>
                </el-table-column>
            </el-table>

            <el-dialog title="编辑" :visible.sync="editVisible" width="40%" center>
                <el-form style="margin-left: 70px" label-position="left" :model="editForm" ref="editForm" label-width="110px" hide-required-asterisk>
                    <el-form-item label="id" prop="id" style="width: 380px" v-show="false">
                        <el-input v-model="editForm.id"></el-input>
                    </el-form-item>
                    <el-form-item label="民宿名称" prop="entityName" style="width: 380px">
                        <el-input v-model="editForm.entityName"></el-input>
                    </el-form-item>
                    <el-form-item label="区域" prop="entityDept" style="width: 380px">
                        <el-input v-model="editForm.entityDept"></el-input>
                    </el-form-item>
                    <el-form-item label="位置" prop="entityPlace" style="width: 380px">
                        <el-input v-model="editForm.entityPlace"></el-input>
                    </el-form-item>
                    <el-form-item label="入住人数" prop="entityPeople" style="width: 380px">
                        <el-input v-model="editForm.entityPeople"></el-input>
                    </el-form-item>
                    <el-form-item label="价格" prop="entityPrice" style="width: 380px">
                        <el-input v-model="editForm.entityPrice"></el-input>
                    </el-form-item>
                
                    <el-form-item label="描述" prop="description" style="width: 380px">
                        <el-input v-model="editForm.description"></el-input>
                    </el-form-item>
                    <el-table-column label="图片" align="center" style="width: 380px">
                        <div>图片</div>
                        <img :src="editForm.image" style="height: 200px;width: 200px;margin-left: 120px" />  
                </el-table-column>
                </el-form>
                <span slot="footer" class="dialog-footer">
                    <el-button type="primary" @click="saveEdit()">保存</el-button>
                </span>
            </el-dialog>

            <el-dialog title="新增" :visible.sync="addVisible" width="40%" center>
                <el-form style="margin-left: 70px" label-position="left" :model="addForm" ref="addForm" label-width="110px"  hide-required-asterisk>
                    <el-form-item label="民宿名称" prop="entityName" style="width: 380px">
                        <el-input v-model="addForm.entityName"></el-input>
                    </el-form-item>
                    <el-form-item label="区域" prop="entityDept" style="width: 380px">
                        <el-input v-model="addForm.entityDept"></el-input>
                    </el-form-item>
                    <el-form-item label="位置" prop="entityPlace" style="width: 380px">
                        <el-input v-model="addForm.entityPlace"></el-input>
                    </el-form-item>
                    <el-form-item label="入住人数" prop="entityPeople" style="width: 380px">
                        <el-input v-model="addForm.entityPeople"></el-input>
                    </el-form-item>
                    <el-form-item label="价格" prop="entityPrice" style="width: 380px">
                        <el-input v-model="addForm.entityPrice"></el-input>
                    </el-form-item>
                     <el-form-item>
                        <el-upload
                            ref="upload"
                            class="upload-demo"
                            action=""
                        
                            :before-upload="beforeUploadFile"
                         
                            :file-list="fileList"
                            :on-remove="beforeRemove"
                            :auto-upload="true"
                        >
                           <!-- :on-change="handleChange" -->
                            <el-button slot="trigger" size="small" type="primary">选取图片</el-button>
                            <div slot="tip" class="el-upload__tip">选择要上传的图片，且不超过1M</div>
                        </el-upload>
                    </el-form-item>
                
                    <el-form-item label="描述" prop="description" style="width: 380px">
                        <el-input v-model="addForm.description"></el-input>
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
    name: 'HotSoftware',
    data() {
        return {
            editVisible: false,
            addVisible: false,
            tableData: [],
            searchForm: {},
            addForm: {},
            editForm: {},
            relativePath: '/mall-vue/public',
            imageUrl: '',
            fileList: [],
            image:'',
            file: {},
            isCarousel: false,
        };
    },
    methods: {
        getTableData() {
            let _this = this;
            _this.$axios.post('/entity/getDataList', {}).then(res => {
                _this.tableData = res.data.data;
            });
        },
        searchButton() {
            let _this = this;
            _this.$axios.post('/entity/getDataList', _this.searchForm).then(res => {
                _this.tableData = res.data.data;
            });
        },
        addButton() {
            let _this = this;
            _this.addVisible = true;
        },
        editButton(params) {
            let _this = this;
            _this.editForm = params;
            _this.editVisible = true;
        },
        beforeUploadFile(file){
            console.log(file)
            let _this = this;
            let par=new FormData();
            par.append('file',file)
            par.append('relativePath',this.relativePath)
            _this.image=file.name
            _this.$axios.post('/files/uploadImg', par).then(res => {
                _this.$message({
                    showClose: true,
                    message: '保存成功',
                    type: 'success',
                });
                _this.getTableData();
            });
        },
        requestFun() {
            //'/files/uploadImg?relativePath=' + relativePath
            let _this = this;
            console.log('的' + _this.relativePath);
            _this.$axios.post('/files/uploadImg?relativePath=', _this.relativePath).then(res => {
                _this.$message({
                    showClose: true,
                    message: '保存成功',
                    type: 'success',
                });
                _this.getTableData();
            });
            _this.addVisible = false;
        },
        saveAdd() {
            let _this = this;
            _this.addForm.image=_this.image
            _this.$axios.post('/entity/saveData', _this.addForm).then(res => {
                _this.$message({
                    showClose: true,
                    message: '保存成功',
                    type: 'success',
                });
                _this.getTableData();
            });
            _this.addForm={}
            _this.addVisible = false;
        },
        saveEdit() {
            let _this = this;
            _this.$axios.post('/entity/saveData', _this.editForm).then(res => {
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
            let _this = this;
            _this.$axios.post('/entity/delData', { id: params }).then(res => {
                _this.$message({
                    showClose: true,
                    message: '删除成功',
                    type: 'success',
                });
                _this.getTableData();
            });
        },
        saveFile: function () {
            this.$axios
                .post('/files/uploadImg', this.file)
                .then(res => {
                    if (res.data.code == OK) {
                        this.$message.success('上传文件成功');
                        // this.$router.push({ name: 'PassageList' });
                    } else {
                        this.$message({
                            message: res.data.message,
                            type: 'error',
                        });
                    }
                })
                .catch(function (error) {
                    this.$message.error(error);
                });
        },
        // handleChange: function (file, fileList) {
        //     var response = file.response;
        //     console.log(response);
        //     if (response != null && response.code == OK) {
        //         console.log(response.data);
        //         this.file.filePath = response.data;
        //         this.file.fileName = this.getFileName(this.file.filePath);
        //         console.log(this.file.fileName);
        //         this.file.passageId = this.passageId;
        //         console.log(this.file);
        //         this.$message.success('上传文件成功');
        //         this.saveFile();
        //     }
        //     this.fileList = fileList.slice(-3);
        // },
        getFileName: function (filePath) {
            var fileName = null;
            if (filePath != null) {
                if (filePath.indexOf('/') != -1) {
                    fileName = filePath.substring(filePath.lastIndexOf('/') + 1);
                }
            }
            console.log('路径' + fileName);
            return fileName;
        },
        beforeRemove: function (file, fileList) {
            return this.$confirm(`确定移除 ${file.name}？`);
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
