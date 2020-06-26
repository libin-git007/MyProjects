import Vue from 'vue'
import Router from 'vue-router'
import main from '@/page/main/main.vue'
import menu from '@/page/main/menu.vue'
import login from '@/page/main/login.vue'
import user from '@/page/main/user.vue'
import userInfo from '@/page/main/userInfo.vue'

Vue.use(Router)
const routerPush = Router.prototype.push
Router.prototype.push = function push(location) {
  return routerPush.call(this, location).catch(error=> error)
}

export default new Router({
  routes: [
    {
      path: '/',
      name: 'main',
      component: main,
      children:[{
        path: '/menu',
        name:'menu',
        component:menu
      },{
        path: '/user',
        name:'user',
        component:user
      },{
        path: '/userInfo',
        name:'userInfo',
        component:userInfo
      }]
    },{
      path:'/login',
      name:'login',
      component: login
    }
  ]
})
