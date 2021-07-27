<template>
<!-- <v-card class="overflow-hidden"> -->
  <v-app-bar
    class="d-flex flex-row mb-6"
    absolute
    color="#8BC34A"
    shrink-on-scroll
    scroll-target="#scrolling-techniques-7"
  >
    <v-btn class="px-7"><router-link :to="{ name: 'Main' }">로고</router-link> | </v-btn>
    <v-btn class="px-7"><router-link :to="{ name: 'Signup' }">회원가입 | </router-link></v-btn>
    <v-btn class="px-7"><span>로그인 | </span></v-btn>
    <v-btn class="px-7"><router-link :to="{ name: 'MyPage' }">마이 페이지</router-link></v-btn>

    <v-spacer></v-spacer>

    <v-btn icon>
      <v-icon>mdi-magnify</v-icon>
    </v-btn>

    <v-btn icon>
      <v-icon>mdi-heart</v-icon>
    </v-btn>

    <v-btn icon>
      <v-icon>mdi-dots-vertical</v-icon>
    </v-btn>
  </v-app-bar>
<!-- </v-card> -->
</template>

<script>
export default {
  name: 'NavTop',
}
</script>

<style>

</style>
