import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    postlist: [1],
  },
  mutations: {
    // 커뮤니티 관련
    GET_POSTS: function (state, postlist) {
      state.postlist = postlist
    },    
  },
  actions: {
    getPosts: function () {
      axios({
        method: 'get',
        url: 'https://localhost:8443/api/v1/article/all',
      })
      .then(res => {
        console.log(res.data)
        // commit('GET_POSTS', res.data)
      })
      .catch(err => {
        console.log(err)
      })
    }
  },
  modules: {
  }
})
