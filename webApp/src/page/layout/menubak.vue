<template>
  <el-container style="height: 500px;">
    <el-header style="text-align: right; font-size: 12px;vert-align: middle" class="el-header">
      <div style="color: white;display:inline;padding:3px;font-size:medium">{{user.username}}</div>
      <span style="float: right">
        <el-popover
          placement="bottom"
          width="30"
          trigger="click"
          visible-arrow="false"
          style="padding: 0px;">
          <div>
            <el-avatar :size="150" icon="el-icon-user-solid" slot="reference" shape="square"></el-avatar>
            <div style="cursor:pointer;" @click="logOut()">退出</div>

          </div>
          <el-avatar :size="50" icon="el-icon-user-solid" slot="reference"
                     style="margin-top:5px;cursor:pointer;"></el-avatar>
        </el-popover>
      </span>

    </el-header>
    <el-container>
      <el-aside :background-color="variables.menuBg" width="200px" class="el-aside">
        <!-- <el-menu :default-openeds="['1']">
           <el-submenu index="1">
             <template slot="title"><i class="el-icon-setting"></i>系统设置</template>
             <el-menu-item index="/menu" @click="goTo('/menu')">
               <i class="el-icon-burger"></i>
               <span slot="title">功能定义</span>
             </el-menu-item>
           </el-submenu>
         </el-menu>-->

        <el-menu
          :background-color="variables.menuBg"
          :text-color="variables.menuText"
          :active-text-color="variables.menuActiveText"
          :unique-opened="false"
        >
          <el-submenu v-for="mData in menuData" :key="mData.functionId" :index="mData.functionCode">
            <template slot="title"><i :class="mData.icon"></i>{{mData.functionName}}</template>
            <el-menu-item :index="detailData.functionCode" v-for="detailData in mData.detail"
                          :key="detailData.functionId" @click="goTo(detailData.router)">
              <i :class="detailData.icon"></i>
              <span>{{detailData.functionName}}</span>
            </el-menu-item>
          </el-submenu>
        </el-menu>

      </el-aside>

      <el-main style="height: max-content">
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
  import router from "@/router"
  import variables from "@/styles/variables.scss"
  export default {
    data() {
      return {
        menuData: [],
        user: [],
        bgColor:"#304156"
      };
    },
    created() {
      //查询菜单信息显示
      let that = this;
      this.$axios.get( '/witty-main/menu/queryMenuTree').then(function (res) {
        that.menuData = res.data;
      }).catch(function (e) {
        console.log(e);
      })
    },
    computed:{
      variables() {
        return variables
      }
    },
    methods: {
      goTo(path) {
        this.$router.replace(path);
      },
      logOut() {
        //登出
        let that = this;
        this.$axios.get( '/logout').then(function (res) {
          //退出后跳转到登陆页面
          router.replace({
            path: 'login',
            replace: true
            // query: {redirect: router.currentRoute.fullPath}
          })
        }).catch(function (e) {
          console.log(e);
        })
      }
    }

  };
</script>
