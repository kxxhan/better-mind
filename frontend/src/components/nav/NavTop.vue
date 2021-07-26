<template>
  <div id="nav-top">
    <router-link :to="{ name: 'Main' }">로고</router-link> | 
    <router-link :to="{ name: 'Signup' }">회원가입</router-link> | 
    <span>로그인 | </span>
    <router-link :to="{ name: 'MyPage' }">마이 페이지</router-link>
  </div>
</template>

<script>
export default {
  name: 'NavTop',
}
</script>

<style>

</style>