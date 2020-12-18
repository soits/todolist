import Vue from 'vue'
import VueRouter from 'vue-router'


import Home from '../views/Home.vue'
import About from '../views/About.vue'
import ApiCall from '../views/ApiGetTest.vue'

 
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    component: About
  },{

    path : '/apiCall',
    name : 'ApiCall',
    component : ApiCall 
  }
]

const router = new VueRouter({
  routes
})

export default router
