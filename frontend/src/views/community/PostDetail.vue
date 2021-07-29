<template>
  <v-container id="post-detail">
    <!-- 게시글 상세내용 -->
    <v-card
      class="mx-auto mb-5"
    >
      <v-container id="post">
        <v-card-title>
          Article title
        </v-card-title>

        <v-card-subtitle>
          Subtitle text
        </v-card-subtitle>

        <v-card-text>
          Greyhound divisively hello coldly wonderfully marginally far upon excluding.
        </v-card-text>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn icon class="mx-2">
            <v-icon>mdi-heart</v-icon>
            <span>3</span>
          </v-btn>
          <span>#해시태그</span>
        </v-card-actions>
        
        <v-card-actions>
          <v-btn @click="updatePost()">수정</v-btn>
          <v-btn>삭제</v-btn>
        </v-card-actions>
      </v-container>
    </v-card>
    
    <!-- 댓글작성 폼 -->
    <v-row class="my-5 d-flex align-center">
      <v-textarea
        prepend-inner-icon="mdi-comment"
        class="mx-2"
        label="comment"
        rows="1"
        cols="12"
        v-model="commentItem"
      ></v-textarea>
      <!-- <input type="text" id="comment" name="comment" required> -->
      <v-btn 
        cols="1"
        @click="createComment()"
      >
        작성
      </v-btn>
    </v-row>

    <!-- 댓글 리스트 -->
    <Comment/>
  </v-container>
</template>

<script>
import Comment from '@/components/community/Comment.vue'

export default {
  name: 'PostDetail',
  data: function () {
    return {
      commentItem: '',
    }
  },
  components: {
    Comment,
  },
  methods: {
    updatePost: function () {
      this.$router.push({ name: 'UpdatePost' })
    },
    createComment: function () {
      console.log(this.commentItem)
    }
  }
}
</script>

<style>

</style>