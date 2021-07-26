<template>
  <div id="programs-items">
    <p>전문가 프로그램 페이지</p>
    <p @click="showDetail()">프로그램 1 (클릭하면 디테일로 이동)</p>
  </div>
</template>

<script>

export default {
  name: 'ProgramItems',
  methods: {
    showDetail: function () {
      this.$router.push({ name: 'ProgramDetail' })
    },
  }
}
</script>

<style>

</style>