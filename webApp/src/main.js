// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App'
import router from './router'
import axios from 'axios'
import VueSession from "vue-session"
import http from './router/http'

Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.use(VueSession)
Vue.prototype.$axios = axios
axios.defaults.withCredentials=true;//让ajax携带cookie
axios.defaults.baseURL="http://127.0.0.1:1003"
Vue.config.productionTip = false



// // http request 拦截器
// axios.interceptors.request.use(
//   config => {
//     if (stoken) {  // 判断是否存在token，如果存在的话，则每个http header都加上token
//       config.headers.Authorization = `token ${store.state.token}`;
//     }
//     return config;
//   },
//   err => {
//     return Promise.reject(err);
//   });
//

// http response 拦截器
/*axios.interceptors.response.use(
  response => {
    //console.log("success");

    var data=response.data;
    var code=data.code;
    if(code=='2001'){
      //用户未登陆
      router.replace({
        path: 'login',
        query: {redirect: router.currentRoute.fullPath}
      });
    }/!*else if(code=='200'){
      router.replace({
        path: '/',
        query: {redirect: router.currentRoute.fullPath}
      });
    }*!/
    return response;
  },
  error => {
    if (error.response) {
      switch (error.response.status) {
        case 403:
          // 返回 401 清除token信息并跳转到登录页面
          router.replace({
            path: 'login'
            //query: {redirect: router.currentRoute.fullPath}
          })
      }
    }
    //console.log("打印："+error.response.status);
    return Promise.reject(error.response.data)   // 返回接口返回的错误信息
  });*/

Vue.mixin({
  data () {
    return {
      service: ''
    }
  },
  created() {
   // this.service = http;
  }
})
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
