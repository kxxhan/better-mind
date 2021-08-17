import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    userInfo: [],
    programlist: [],
    myprogramlist: [],
    program: {},
    postlist: [],
    post: {},
    isLogin: false,
    questions: [],
    answers : [],
    lastQuestion: [],
    // isSpeaking: false,
    speakers: [],
  },
  mutations: {
    //프로그램 관련
    GET_PROGRAMS: function (state, programlist) {
      state.programlist = programlist
    },
    // 내가 신청한 프로그램 리스트
    GET_MYPROGRAMS: function (state, myprogramlist) {
      state.myprogramlist = myprogramlist
    },
    // 프로그램 디테일
    GET_PROGRAM: function (state, program) {
      state.program = program
    },
    // 커뮤니티 관련
    GET_POSTS: function (state, postlist) {
      state.postlist = postlist
    },
    // 커뮤니티 디테일
    GET_POST: function (state, post) {
      state.post = post
    },
    
    // 로그인 상태
    ON_LOGIN: function (state) {
      state.isLogin = true
    },
    // 로그아웃 상태
    ON_LOGOUT: function (state) {
      state.isLogin = false
    },
    // 사용자 정보
    GET_MY_INFO: function (state, info) {
      state.userInfo = info
    },
    // 포스트잇 질문
    GET_QUESTIONS: function (state, questions) {
      state.questions = questions
      state.lastQuestion = questions[questions.length - 1]
    },
    // 포스트잇 답변
    GET_ANSWER: function (state, answers) {
      state.answers = answers
    },
    // // Speaking 시작
    // START_SPEAKING: function (state) {
    //   state.isSpeaking = true
    //   console.log(`isSpeaking ${state.isSpeaking}으로 바뀜`)
    // },
    // // Speaking 멈춤
    // STOP_SPEAKING: function (state) {
    //   state.isSpeaking = false
    //   console.log(`isSpeaking ${state.isSpeaking}으로 바뀜`)
    // },
    // 현재 말하고있는 사람 정보 추가
    ADD_SPEAKER: function (state, data) {
      state.speakers.push(data)
      console.log('speaker 추가된 후 ', state.speakers)
    },
    // 발언 멈춘 사람 정보 삭제
    REMOVE_SPEAKER: function (state, data) {
      state.speakers.splice(state.speakers.indexOf(data))
      console.log('speaker 삭제된 후 ', state.speakers)
    }
  },
  actions: {
    // 프로그램 리스트
    getPrograms: function ({ commit }) {
      axios({
        method: 'get',
        url: '/api/v1/program/all',
      })
      .then(res => {
        commit('GET_PROGRAMS', res.data)
      })
      .catch(err => {
        console.log(err)
      })
    },
    // 내가 신청한 프로그램 리스트
    getMyPrograms: function ({ commit }) {
      const myprogramlist = []
      // userInfo 가져오기
      axios({
        method: 'get',
        url: '/api/v1/users/me',
        headers: {
          Authorization: `Bearer ${localStorage.getItem('jwt')}`
        }
      })
      .then(res => {
        commit('GET_MY_INFO', res.data)
        // 해당 유저의 신청 프로그램 id 가져오기
        axios({
          method: 'get',
          url: `/api/v1/users/${this.state.userInfo.id}`,
        })
        .then(res => {
          // 각 프로그램 상세정보 가져오기
          const myprogram = res.data.programs
          for (const program of myprogram) {
            axios({
              method: 'get',
              url: `/api/v1/program/${program.program_id}`,
            })
            .then(res => {
              myprogramlist.push(res.data)
            })
            .catch(err => {
              console.log(err)
            })
          } 
          commit('GET_MYPROGRAMS', myprogramlist)         
        })
        .catch(err => {
          console.log(err)
        })
      })
      .catch(err => {
        console.log(err)
      })
    },
    // 프로그램 디테일
    getProgram: function ({ commit }, program_pk) {
      axios({
        method: 'get',
        url: `/api/v1/program/${program_pk}`,
      })
      .then(res => {
        console.log(res.data)
        commit('GET_PROGRAM', res.data)
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
        },
      })
      .then(res => {
        commit('GET_POSTS', res.data)
        console.log(res.data)
        console.log(this.state.userInfo)
      })
      .catch(err => {
        console.log(err)
      })
    },
    // 커뮤니티 디테일
    getPost: function ({ commit }, post_pk ) {
      axios({
        method: 'get',
        url: `/api/v1/article/${post_pk}`,
        headers: {
          Authorization: `Bearer ${localStorage.getItem('jwt')}`
        }
      })
      .then(res => {
        commit('GET_POST', res.data)
      })
    },
    // 내 정보 받아오기
    getMyInfo: function ({ commit }) {
      axios({
        method: 'get',
        url: '/api/v1/users/me',
        headers: {
          Authorization: `Bearer ${localStorage.getItem('jwt')}`
        }
      })
      .then(res => {
        commit('GET_MY_INFO', res.data)
      })
      .catch(err => {
        console.log(err)
      })
    },
    // 포스트잇 질문 리스트 받아오기
    getQuestions: function ({ commit }) {
      axios({
        method: 'get',
        url: `/api/v1/postit/all`
      })
      .then(res => {
        commit('GET_QUESTIONS', res.data)
        axios({
          method: 'get',
          url: `/api/v1/postit/${this.state.lastQuestion.id}`
        })
        .then(result => {
          commit('GET_ANSWER', result.data.answer)
        })
      })
    },
    // 포스트잇 답변 리스트 받아오기
    // getAnswer: function ({ commit }, questionId) {
    //   axios({
    //     method: 'get',
    //     url: `/api/v1/postit/${questionId}`
    //   })
    //   .then(res => {
    //     commit('GET_ANSWER', res.data.answer)
    //   })
    // },
    // // Speaking 시작
    // startSpeaking: function(context) {
    //   context.commit('START_SPEAKING')
    // },
    // // Speaking 멈춤
    // stopSpeaking: function(context) {
    //   context.commit('STOP_SPEAKING')
    // },
    // 현재 말하고 있는 사람 정보 추가
    addSpeaker: function(context, data) {
      context.commit('ADD_SPEAKER', data)
    },
    // 발언 멈춘 사람 정보 삭제
    removeSpeaker: function(context, data) {
      context.commit('REMOVE_SPEAKER', data)
    }
  },
  // getters: {
  //   getIsSpeaking() {
  //     return this.state.isSpeaking
  //   }
  // },
  modules: {
  }
})
