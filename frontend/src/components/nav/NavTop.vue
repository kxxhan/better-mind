<template>
  <div id="nav-top">
    <ul>
      <router-link :to="{ name: 'Main' }">로고</router-link>
      <router-link :to="{ name: 'Signup' }">회원가입</router-link>
      <li>로그인</li>
      <router-link :to="{ name: 'MyPage' }">마이 페이지</router-link>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'NavTop',
}
</script>

<style>

</style>