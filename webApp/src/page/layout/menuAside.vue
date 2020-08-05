<template>
    <div style="height: 100%">
      <el-scrollbar wrap-class="page-component__scroll">
        <el-menu
          :background-color="variables.menuBg"
          :text-color="variables.menuText"
          :unique-opened="false"
          :active-text-color="variables.menuActiveText"
          :collapse-transition="false"
          mode="vertical"
        >
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-setting"></i>系统设置
            </template>
            <el-menu-item index="/menu1" @click="goTo('/menu')">
              <i class="el-icon-burger"></i>
              <span slot="title">功能定义1</span>
            </el-menu-item>
            <el-menu-item index="/menu2" @click="goTo('/menu')">
              <i class="el-icon-burger"></i>
              <span slot="title">功能定义2</span>
            </el-menu-item>
            <el-menu-item index="/menu3" @click="goTo('/menu')">
              <i class="el-icon-burger"></i>
              <span slot="title">功能定义3</span>
            </el-menu-item>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title"><i class="el-icon-setting"></i>系统设置
            </template>
            <el-menu-item index="/menu4" @click="goTo('/menu')">
              <i class="el-icon-burger"></i>
              <span slot="title">功能定义4</span>
            </el-menu-item>
            <el-menu-item index="/menu5" @click="goTo('/menu')">
              <i class="el-icon-burger"></i>
              <span slot="title">功能定义5</span>
            </el-menu-item>
            <el-menu-item index="/menu6" @click="goTo('/menu')">
              <i class="el-icon-burger"></i>
              <span slot="title">功能定义6</span>
            </el-menu-item>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title"><i class="el-icon-setting"></i>系统设置
            </template>
            <el-menu-item index="/menu7" @click="goTo('/menu')">
              <i class="el-icon-burger"></i>
              <span slot="title">功能定义7</span>
            </el-menu-item>
            <el-menu-item index="/menu8" @click="goTo('/menu')">
              <i class="el-icon-burger"></i>
              <span slot="title">功能定义8</span>
            </el-menu-item>
            <el-menu-item index="/menu9" @click="goTo('/menu')">
              <i class="el-icon-burger"></i>
              <span slot="title">功能定义9</span>
            </el-menu-item>
          </el-submenu>
          <el-submenu index="4">
            <template slot="title"><i class="el-icon-setting"></i>系统设置
            </template>
            <el-menu-item index="/menu7" @click="goTo('/menu')">
              <i class="el-icon-burger"></i>
              <span slot="title">功能定义7</span>
            </el-menu-item>
            <el-menu-item index="/menu8" @click="goTo('/menu')">
              <i class="el-icon-burger"></i>
              <span slot="title">功能定义8</span>
            </el-menu-item>
            <el-menu-item index="/menu9" @click="goTo('/menu')">
              <i class="el-icon-burger"></i>
              <span slot="title">功能定义9</span>
            </el-menu-item>
          </el-submenu>
          <el-submenu index="5">
            <template slot="title"><i class="el-icon-setting"></i>系统设置
            </template>
            <el-menu-item index="/menu7" @click="goTo('/menu')">
              <i class="el-icon-burger"></i>
              <span slot="title">功能定义7</span>
            </el-menu-item>
            <el-menu-item index="/menu8" @click="goTo('/menu')">
              <i class="el-icon-burger"></i>
              <span slot="title">功能定义8</span>
            </el-menu-item>
            <el-menu-item index="/menu9" @click="goTo('/menu')">
              <i class="el-icon-burger"></i>
              <span slot="title">功能定义9</span>
            </el-menu-item>
          </el-submenu>
          <el-submenu index="6">
            <template slot="title"><i class="el-icon-setting"></i>系统设置
            </template>
            <el-menu-item index="/menu7" @click="goTo('/menu')">
              <i class="el-icon-burger"></i>
              <span slot="title">功能定义7</span>
            </el-menu-item>
            <el-menu-item index="/menu8" @click="goTo('/menu')">
              <i class="el-icon-burger"></i>
              <span slot="title">功能定义8</span>
            </el-menu-item>
            <el-menu-item index="/menu9" @click="goTo('/menu')">
              <i class="el-icon-burger"></i>
              <span slot="title">功能定义9</span>
            </el-menu-item>
          </el-submenu>
        </el-menu>
      </el-scrollbar>
      <!--        <el-menu-->
      <!--          :background-color="variables.menuBg"-->
      <!--          :text-color="variables.menuText"-->
      <!--          :active-text-color="variables.menuActiveText"-->
      <!--          :unique-opened="false"-->
      <!--        >-->
      <!--          <el-submenu v-for="mData in menuData" :key="mData.functionId" :index="mData.functionCode">-->
      <!--            <template slot="title"><i :class="mData.icon"></i>{{mData.functionName}}</template>-->
      <!--            <el-menu-item :index="detailData.functionCode" v-for="detailData in mData.detail"-->
      <!--                          :key="detailData.functionId" @click="goTo(detailData.router)">-->
      <!--              <i :class="detailData.icon"></i>-->
      <!--              <span>{{detailData.functionName}}</span>-->
      <!--            </el-menu-item>-->
      <!--          </el-submenu>-->
      <!--        </el-menu>-->

    </div>
</template>

<script>
  import router from "@/router"
  import variables from "@/styles/variables.scss"

  export default {
    name: "menuAside",
    data() {
      return {
        menuData: [],
        user: []
      };
    },
    created() {
      //查询菜单信息显示
      let that = this;
      this.$axios.get('/witty-main/menu/queryMenuTree').then(function (res) {
        that.menuData = res.data;
      }).catch(function (e) {
        console.log(e);
      })
    },
    computed: {
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
        this.$axios.get('/logout').then(function (res) {
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

<style lang="scss">
  .page-component__scroll{
    height:100%
  }
  .page-component__scroll .page-component__wrap{
    overflow-x: auto;
  }
</style>
