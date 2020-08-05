<template>
  <div class="app-wrapper">
    <!--菜单-->
    <menu-aside class="sidebar-container"/>
    <div class="main-container" style="border:1px solid #000000">
      <div :class="{'fixed-header':fixedHeader}">
        <!--菜单树-->
        <navbar />
        <!--tab页签-->
        <tags-view v-if="needTagsView" />
      </div>
    </div>
  </div>
</template>
<style lang="scss" scoped>
  @import "~@/styles/mixin.scss";
  @import "~@/styles/variables.scss";
  @import "~@/styles/sidebar.scss";
  .app-wrapper {
    position: relative;
    height: 100%;
    width: 100%;

    &.mobile.openSidebar {
      position: fixed;
      top: 0;
    }
  }
</style>

<script>
  import menuAside from "@/page/layout/menuAside"
  import navbar from "@/page/layout/Navbar"

  export default{
    components:{menuAside,navbar},
    data(){
      return{};
    }

  }
</script>
