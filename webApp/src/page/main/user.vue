<template>
  <div>
    <div style="margin-bottom: 2px;">
      <el-button style="float: left" size="mini" icon="el-icon-plus" type="primary" @click="add">新增</el-button>
      <el-button style="float: left" size="mini" icon="el-icon-check" type="primary" @click="save">保存</el-button>
      <el-button style="float: left" size="mini" icon="el-icon-delete" type="danger" @click="del">删除</el-button>
      <div style="float: right">
        <el-input type="text" size="small" placeHolder="代码" style="width: 180px" clearable></el-input>
        <el-input type="text" size="small" placeHolder="名称" style="width: 180px" clearable></el-input>
        <el-input type="text" size="small" placeHolder="类型" style="width: 180px" clearable></el-input>
        <el-button icon="el-icon-search" size="small" type="primary" @click="query" round></el-button>
      </div>
    </div>
    <el-table
      ref="menuTable"
      stripe
      border
      height="800"
      style="width: 100%;">
      <el-table-column
        type="selection" width="35">
      </el-table-column>
      <el-table-column label="角色代码"></el-table-column>

    </el-table>
  </div>
</template>

<script>

  export default {
    data() {
      return {

      }
    },
    created() {
     // this.initQuery();
    },
    methods: {
      initQuery() {

      },
      add(){},
      save(){},
      del(){},
      query(){}
    }
  }

</script>
