<template>
  <v-app-bar
    app
    color="#8BC34A"
    style="height: 56px;"
    class="mt-11"
  >
    <router-link :to="{ name: 'ProgramItems' }" class="navlink mx-3">그룹 테라피</router-link>
    <router-link :to="{ name : 'PostItems' }" class="navlink mx-3">커뮤니티</router-link>
  </v-app-bar>
</template>

<script>
export default {
  name: 'NavBottom',
}
</script>

<style>
.navlink {
  text-decoration: none;
  /* 스타일이 안먹어서 !important 속성 사용했습니다ㅠㅠ */
  color: white !important; 
}
</style>