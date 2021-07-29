<template>
  <v-app-bar
    app
    color="#8BC34A"
    style="height: 40px;"
  >
    <router-link :to="{ name: 'Main' }" class="navlink mx-3">로고</router-link>
    <div class="ms-auto">
      <router-link :to="{ name: 'Signup' }" class="navlink mx-3">회원가입</router-link>
      <span class="navlink mx-3">로그인</span>
      <span class="navlink mx-3">로그아웃</span>
      <router-link :to="{ name: 'MyPage' }" class="navlink mx-3">마이 페이지</router-link>
    </div>
  </v-app-bar>
</template>

<script>
export default {
  name: 'NavTop',
}
</script>

<style>
.navlink {
  text-decoration: none;
  /* 스타일이 안먹어서 !important 속성 사용했습니다ㅠㅠ */
  color: white !important; 
}
</style>
