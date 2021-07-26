<template>
  <div id="nav-bottom">
    <ul>
      <router-link :to="{ name: 'ProgramItems' }">그룹 테라피</router-link> | 
      <router-link :to="{ name : 'PostItems' }">커뮤니티</router-link>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'NavBottom',
}
</script>

<style>

</style>