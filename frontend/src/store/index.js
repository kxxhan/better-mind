import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    programlist: [],
    postlist: [1],
  },
  mutations: {
    //프로그램 관련
    GET_PROGRAMS: function (state, programlist) {
      state.programlist = programlist
    },
    // 커뮤니티 관련
    GET_POSTS: function (state, postlist) {
      state.postlist = postlist
    },    
  },
  actions: {
    // 프로그램 리스트
    getPrograms: function ({ commit }) {
      axios({
        method: 'get',
        url: '/api/v1/program/all',
      })
      .then(res => {
        // null값으로 옴!
        console.log(res.data)
        commit('GET_PROGRAMS', res.data)
      })
      .catch(err => {
        console.log(err)
      })
    },
    // 커뮤니티 리스트
    getPosts: function ({ commit }) {
      axios({
        method: 'get',
        url: '/api/v1/article/all',
        headers: {
          Authorization: `Bearer ${localStorage.getItem('jwt')}`
        }
      })
      .then(res => {
        console.log(res.data)
        commit('GET_POSTS', res.data)
      })
      .catch(err => {
        console.log(err)
      })
    }
  },
  modules: {
  }
})
