<template>
  <v-app style="background-image: linear-gradient(-20deg, #e9defa 0%, #fbfcdb 100%);">
    <v-container>
      <NavBar/>
      <v-main class="my-4">
        <router-view/>
      </v-main>
    </v-container>
  </v-app>
</template>

<script>
import NavBar from '@/components/nav/NavBar.vue'

export default {
  name: 'App',
  components: {
    NavBar,
  },
  created: function () {
    // 현재 사용자의 로그인 상태
    const token = localStorage.getItem('jwt')
    if (token) {
      this.$store.commit('ON_LOGIN')     
      this.$store.dispatch('getMyInfo')
    }
  }
};
</script>
<style>

</style>