<template>
  <div>
    <el-form v-model="form" label-width="80px">
      <el-form-item>
        <el-avatar :size="200" shape="square"></el-avatar>
      </el-form-item>
      <el-form-item label="用户名">
        <el-input v-model="form.userDesc" size="small" style="width:200px;"></el-input>
      </el-form-item>
      <el-form-item label="性别">
        <el-select v-model="form.sex" placeholder="请选择性别" style="width: 200px;" size="small">
          <el-option label="男" value="M"></el-option>
          <el-option label="女" value="F"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        form: {}
      };
    },
    created() {
      //查询当前用户信息
      let that = this;
      //let data = [];
      // data.push({"userId":that.$session.get("userId")});
      this.$axios.get( '/witty-main/userInfo/queryUserInfo', {params: {"userId": that.$session.get("userId")}}).then(function (res) {
        var resultJson = res.data;
        that.form = resultJson.data[0];
      });
    },
    methods: {
      onSubmit() {
        let that = this;
        let formData = new FormData();
        for (var key in this.form) {
          formData.append(key, this.form[key]);
        }

        //console.log("userName:"+this.$session.get("userName"));
        this.$axios.post( '/witty-main/userInfo/updateUserInfo', formData).then(function (res) {
          //let resultJson = res.data;
          //that.form = resultJson.data[0];
          that.$message({message: '成功', type: 'success'});
        });
      }
    }
  }
</script>

