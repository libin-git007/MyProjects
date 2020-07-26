<template>
  <div>
    <div style="margin-bottom: 2px;">
      <el-button style="float: left" size="mini" icon="el-icon-plus" type="primary" @click="add">新增</el-button>
      <el-button style="float: left" size="mini" icon="el-icon-check" type="primary" @click="save">保存</el-button>
      <el-button style="float: left" size="mini" icon="el-icon-delete" type="danger" @click="del">删除</el-button>
      <div style="float: right">
        <el-input type="text" size="small" placeHolder="代码" style="width: 180px"
                  v-model="functionCode" clearable></el-input>
        <el-input type="text" size="small" placeHolder="名称" style="width: 180px"
                  v-model="functionName" clearable></el-input>
        <el-input type="text" size="small" placeHolder="类型" style="width: 180px"
                  v-model="functionType" clearable></el-input>
        <el-button icon="el-icon-search" size="small" type="primary" @click="query" round></el-button>
      </div>
    </div>
    <el-table
      ref="menuTable"
      :data="tableData"
      stripe
      border
      height="800"
      style="width: 100%;">
      <el-table-column
        type="selection" width="35">
      </el-table-column>
      <el-table-column
        label="功能代码"
        width="200"
        prop="functionCode"
        align="center">
        <template v-slot="{row,$index}">
          <div @click="changeNum($index)">
            <el-input size="small" v-if="click_index==$index" v-model="row.functionCode"></el-input>
            <span v-else>{{row.functionCode}}</span>
          </div>
        </template>
      </el-table-column>
      <el-table-column
        prop="functionName"
        label="功能名称"
        width="180"
        align="center">
        <template slot-scope="{row,$index}">
          <div @click="changeNum($index)">
            <el-input size="small" v-if="click_index==$index" v-model="row.functionName"></el-input>
            <span v-else>{{row.functionName}}</span>
          </div>
        </template>
      </el-table-column>
      <el-table-column
        prop="functionName"
        label="功能类型"
        width="180"
        align="center">
        <template slot-scope="{row,$index}">
          <div @click="changeNum($index)">
            <el-input size="small" v-if="click_index==$index" v-model="row.functionType"></el-input>
            <span v-else>{{row.functionType}}</span>
          </div>
        </template>
      </el-table-column>

      <el-table-column
        prop="functionName"
        label="上级功能代码"
        width="180"
        align="center">
        <template slot-scope="{row,$index}">
          <div @click="changeNum($index)">
            <el-input size="small" v-if="click_index==$index" v-model="row.parentFunctionCode"></el-input>
            <span v-else>{{row.parentFunctionCode}}</span>
          </div>
        </template>
      </el-table-column>
      <el-table-column
        prop="icon"
        label="图标"
        align="center">
        <template slot-scope="{row,$index}">
          <div @click="changeNum($index)">
            <el-input size="small" v-if="click_index==$index" v-model="row.icon"></el-input>
            <span v-else>{{row.icon}}</span>
          </div>
        </template>
      </el-table-column>
      <el-table-column
        prop="router"
        label="路由"
        align="center">
        <template slot-scope="{row,$index}">
          <div @click="changeNum($index)">
            <el-input size="small" v-if="click_index==$index" v-model="row.router"></el-input>
            <span v-else>{{row.router}}</span>
          </div>
        </template>
      </el-table-column>
      <el-table-column
        prop="sequence"
        label="排序"
        align="center">
        <template slot-scope="{row,$index}">
          <div @click="changeNum($index)">
            <el-input type="number" size="small" v-if="click_index==$index" v-model="row.sequence"></el-input>
            <span v-else>{{row.sequence}}</span>
          </div>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      style="float: right"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[2, 20, 50, 100]"
      :page-size="2"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total">
    </el-pagination>
  </div>
</template>

<script>

  export default {
    data() {
      return {
        tableData: [],
        isButtonDisabled: true,
        editable: [],
        functionCode: '',
        functionName: '',
        functionType: '',
        click_index: -1,
        currentPage: 1,
        total: 0,

      }
    },
    created() {
      this.initQuery();
    },
    methods: {
      initQuery() {
        let that = this;
        let loading = this.$loading({
          lock: true,
          text: 'Loading',
          spinner: 'el-icon-loading',
          background: 'rgba(0, 0, 0, 0.7)'
        });
        this.$axios.post( '/witty-main/menu/queryAll').then(function (res) {
          that.tableData = res.data;
          that.total = res.data.total;
          loading.close();
        }).catch(function (e) {
          loading.close();
        })
      },
      add() {
        this.tableData.push({
          "functionId": "",
          "functionCode": "EXP001",
          "functionName": "GONGNENG1",
          "functionType": "F",
          "parentFunctionId": "",
          "icon": "111",
        });
      },
      //保存table数据
      save() {
        let that = this;
        this.$axios.post( '/witty-main/menu/update',
          this.tableData).then(function (res) {
          that.$message({message: '成功', type: 'success'});

        }).catch(function (e) {
          that.$message({message: e, type: 'error'});
        })
      },
      //删除勾选的数据
      del() {
        let that = this;
        let selectData = this.$refs.menuTable.selection;
        this.$axios.post( '/witty-main/menu/delete',
          selectData).then(function (res) {
          that.$message({message: '成功', type: 'success'});
          that.initQuery();
        }).catch(function (e) {
          that.$message({message: e, type: 'error'});
        })
      },
      //点击查询按钮查询
      query() {
        let that = this;
        this.$axios.post('/witty-main/menu/queryByColumn',
          {
            "functionCode": that.functionCode,
            "functionName": that.functionName,
            "functionType": that.functionType
          }).then(function (res) {
          that.tableData = res.data.data;
          that.total = res.data.total;

        }).catch(function (e) {
          that.$message({message: e, type: "error"});
        })

      },
      changeNum(row) {
        this.click_index = row;
        //this.editable[row] = true;
        //this.$set(this.editable, row, true);
      },
      handleSizeChange(val) {
        // console.log(`每页 ${val} 条`);
      },
      handleCurrentChange(val) {
        //  console.log(`当前页: ${val}`);
      }
    }
  }

</script>
