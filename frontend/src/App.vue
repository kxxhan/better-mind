<template>
  <v-app style="background-image: linear-gradient(-20deg, #e9defa 0%, #fbfcdb 100%);">
    <!-- <v-container>
      <NavBar/>
      <v-main class="my-4">
      </v-main>
    </v-container> -->
    <router-view/>
  </v-app>
</template>

<script>
export default {
  name: 'App',
  components: {
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