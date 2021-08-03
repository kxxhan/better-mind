<template>
  <nav>
    <v-row>
      <v-col cols="12">
        <!-- 상단 네브바 -->
        <v-toolbar flat app>
          <v-toolbar-title
            class="text-uppercase grey--text"
            style="cursor: pointer"
            @click="$router.push({ name: 'Main' })"
          >
            <span class="font-weight-light">Better</span>
            <span>Mind</span>
          </v-toolbar-title>
          <v-spacer></v-spacer>
          <v-btn v-if="!isLogin" text color="grey" :to="{ name: 'Signup' }">
            <span>Signup</span>
          </v-btn>
          <LoginModal v-if="!isLogin"/>

          <v-menu v-if="isLogin" offset-y rounded="lg">
            <template v-slot:activator="{ on, attrs }">
              <v-btn
                text
                v-bind="attrs"
                v-on="on"
              >
                <span class="grey--text">
                  MyPage
                </span>
              </v-btn>
            </template>
            <!-- 일반 사용자 마이페이지 리스트 -->
            <v-list v-if="isCommon">
              <v-list-item router :to="{ name: 'PubActivities' }">
                <v-list-item-title class="grey--text">Activities</v-list-item-title>
              </v-list-item>
              <v-list-item router :to="{ name: 'PubMeetings' }">
                <v-list-item-title class="grey--text">Counselings</v-list-item-title>
              </v-list-item>
              <v-list-item router :to="{ name: 'UpdateUserInfo' }">
                <v-list-item-title class="grey--text">Edit Profile</v-list-item-title>
              </v-list-item>
            </v-list>
            <!-- 전문가 마이페이지 리스트 -->
            <v-list v-else>
              <v-list-item router :to="{ name: 'ExpMeetings' }">
                <v-list-item-title class="grey--text">Counselings</v-list-item-title>
              </v-list-item>
              <v-list-item router :to="{ name: 'ExpAddMeeting' }">
                <v-list-item-title class="grey--text">Add Counseling</v-list-item-title>
              </v-list-item>
              <v-list-item router :to="{ name: 'UpdateUserInfo' }">
                <v-list-item-title class="grey--text">Edit Profile</v-list-item-title>
              </v-list-item>
            </v-list>
          </v-menu>

          <v-btn v-if="isLogin" text color="grey" @click="onLogout">
            <span>Logout</span>
          </v-btn>
        </v-toolbar>
        <v-divider></v-divider>
      </v-col>
      
      <v-col cols="12">
        <!-- 하단 네브바 -->
        <v-toolbar flat>
          <v-row align="center" justify="center">
            <v-col cols="6" md="3">
              <v-btn text color="grey">
                <span>Personal-Counseling</span>
              </v-btn>
            </v-col>

            <v-col cols="6" md="3">
              <v-menu offset-y rounded="lg">
                <template v-slot:activator="{ on, attrs }">
                  <v-btn
                    text
                    v-bind="attrs"
                    v-on="on"
                  >
                    <span class="grey--text">
                      Group-Counseling
                    </span>
                  </v-btn>
                </template>
                <v-list>
                  <v-list-item router :to="{ name: 'ProgramItems' }">
                    <v-list-item-title class="grey--text">Expert Consultation</v-list-item-title>
                  </v-list-item>
                  <v-list-item>
                    <v-list-item-title class="grey--text">Self-help group</v-list-item-title>
                  </v-list-item>
                </v-list>
              </v-menu>
            </v-col>

            <v-col cols="6" md="3">
              <v-btn text color="grey" :to="{ name : 'PostItems' }">
                <span>Community</span>
              </v-btn>
            </v-col>

            <v-col cols="6" md="3">
              <v-btn text color="grey">
                <span>Post-it</span>
              </v-btn>
            </v-col>
          </v-row>
        </v-toolbar>
      </v-col>
    </v-row>
  </nav>
</template>

<script>
import LoginModal from '../LoginModal.vue'
import axios from 'axios'

export default {
  name: 'NavTop',
  components: {
    LoginModal
  },
  methods: {
    onLogout: function () {
      localStorage.removeItem('jwt')
      this.$store.commit('ON_LOGOUT')
      if (this.$route.path !== '/') {
        this.$router.push({ name: 'Main' })
      }
    }
  },
  created: function () {
    // 현재 사용자의 로그인 상태
    const token = localStorage.getItem('jwt')
    if (token) {
      this.$store.commit('ON_LOGIN')
      
      // 일반 전문가 사용자 판단
      axios({
        method: 'get',
        url: '/api/v1/users/me',
        headers: {
          Authorization: `Bearer ${localStorage.getItem('jwt')}`
        }
      })
      .then((res) => {
        const role = res.data.role
        if (role === '1') {
          this.$store.state.isCommon = false
        }
        else {
          this.$store.state.isCommon = true
        }
      })
    }

  },
  computed: {
    isLogin: function () {
      return this.$store.state.isLogin
    },
    isCommon: function () {
      return this.$store.state.isCommon
    }
  }
}
</script>

<style>

</style>