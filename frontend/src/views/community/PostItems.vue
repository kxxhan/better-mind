<template>
  <div id="post-items">
    <p>키워드 필터</p>
    <p @click="showDetail()">작성된 글 리스트 (클릭하면 디테일로 이동)</p>
    <button @click="createPost">작성</button>
  </div>
</template>

<script>
export default {
  name: 'PostItems',
  methods: {
    showDetail: function () {
      this.$router.push({ name: 'PostDetail' })
    },
    createPost: function () {
      this.$router.push({ name: 'CreatePost' })
    }
  }
}
</script>

<style>

</style>