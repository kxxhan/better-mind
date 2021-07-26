<template>
  <div id="post-detail">
    <h3>제목</h3>
    <h4>내용</h4>
    <button @click="updatePost()">수정</button>
    <button>삭제</button>
    <div>
      <label for="comment">댓글 작성</label>
      <input type="text" id="comment" name="comment" required>
      <button>작성</button>
      <Comment/>
    </div>
  </div>
</template>

<script>
import Comment from '@/components/community/Comment.vue'

export default {
  name: 'PostDetail',
  components: {
    Comment,
  },
  methods: {
    updatePost: function () {
      this.$router.push({ name: 'UpdatePost' })
    }
  }
}
</script>

<style>

</style>