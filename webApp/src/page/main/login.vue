<template>
  <div>
    <el-form :model="user">
      <el-card style="width: 400px;margin:0 auto;">
        <div slot="header" class="clearfix">
          <span>登录</span>
        </div>
        <table>
          <tr>
            <td>用户名</td>
            <td>
              <el-input v-model="user.username" placeholder="用户名"></el-input>
            </td>
            <td><span style="color:red;font-size: 10px">{{user.message}}</span></td>
          </tr>
          <tr>
            <td>密码</td>
            <td>
              <el-input type="password" v-model="user.password" placeholder="密码"
                        @keydown.enter.native="doLogin"></el-input>
              <!-- @keydown.enter.native="doLogin"当按下enter键的时候也会执行doLogin方法-->
            </td>
          </tr>
          <tr>
            <!-- 占两行-->
            <td colspan="2">
              <!-- 点击事件的两种不同的写法v-on:click和 @click-->
              <el-button style="width: 300px" type="primary" @click="doLogin">登录</el-button>
            </td>
          </tr>
        </table>
      </el-card>
    </el-form>
  </div>
</template>

<script>

  import router from "../../router";

  export default {
    data() {
      return {
        user: {
          "username": "",
          "password": "",
          "message": ""
        }
      }
    },
    methods: {
      doLogin() {
        let that = this;
        this.$axios.post('/login?username=' + this.user.username + '&password=' + this.user.password).then(function (res) {
            var result = res.data;
            var code = result.code;
            if (code == '999') {
              that.user.message = result.message;
            } else {
              console.log(result);
              that.$session.set("userName", result.data.username);
              that.$session.set("userId", result.data.userId);
              router.replace({
                path: '/',
                //query: {redirect: router.currentRoute.fullPath}
              });
            }

          }
        );
      }
    }
  }
</script>

<style scoped>

</style>
