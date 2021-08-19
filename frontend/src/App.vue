<template>
  <v-app style="background-image: linear-gradient(-20deg, #e9defa 0%, #fbfcdb 100%);">
    <router-view/>
  </v-app>
</template>

<script>
export default {
  name: 'App',
  components: {
  },
  // created: function () {
  //   if (this.$route.path !== '/') {
  //     // 현재 사용자의 로그인 상태
  //     const token = localStorage.getItem('jwt')
  //     if (token) {
  //       this.$store.commit('ON_LOGIN')     
  //       this.$store.dispatch('getMyInfo')
  //     }
  //     // 로그아웃 상태이면 로그인 페이지로 이동
  //     else {
  //       this.$router.push({ name: 'Login' })
  //     }
  //   }
  // }
};
</script>
<style>

</style>