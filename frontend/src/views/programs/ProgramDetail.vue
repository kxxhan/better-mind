<template>
  <div id="program-detail">
    <h3>프로그램 디테일</h3>
    <p>소개소개소개소개소개소개</p>
    <button @click="registratePrograme()">신청하기</button>
    <button @click="previousPage()">이전</button>
  </div>
</template>

<script>
export default {
  name: 'ProgramDetail',
  methods: {
    previousPage: function () {
      this.$router.push({ name: 'ProgramItems' })
    },
    registratePrograme: function () {
      this.$router.push({ name: 'Payment' })
    }
  }
}
</script>

<style>

</style>