<template>
  <v-container id="post-detail">
    <!-- 게시글 상세내용 -->
    <v-card
      class="mx-auto mb-5"
    >
      <v-container id="post">
        <v-card-title>
          {{ post.title }}
        </v-card-title>

        <v-card-subtitle>
          {{ post.userId }}
        </v-card-subtitle>

        <v-card-text>
          {{ post.content }}
        </v-card-text>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn icon class="mx-2">
            <v-icon>mdi-heart</v-icon>
            <span>{{ post.likeCount }}</span>
          </v-btn>
          <span>#해시태그</span>
        </v-card-actions>
        
        <v-card-actions v-show="post.userId === this.$store.state.userInfo.id">
          <v-btn @click="updatePost(post)">수정</v-btn>
          <v-btn>삭제</v-btn>
        </v-card-actions>
      </v-container>
    </v-card>
    
    <!-- 댓글작성 폼 -->
    <v-row 
      class="my-5 d-flex align-center"
    >
      <v-textarea
        prepend-inner-icon="mdi-comment"
        class="mx-2"
        label="comment"
        rows="1"
        cols="12"
        v-model="commentContent"
      ></v-textarea>
      <!-- <input type="text" id="comment" name="comment" required> -->
      <v-btn 
        cols="1"
        @click="createComment(post)"
      >
        작성
      </v-btn>
    </v-row>

    <!-- 댓글 리스트 -->
    <Comment :key="renderComponent"/>
  </v-container>
</template>

<script>
import axios from 'axios'
import Comment from '@/components/community/Comment.vue'

export default {
  name: 'PostDetail',
  data: function () {
    return {
      commentContent: '',
      renderComponent: 0,
    }
  },
  components: {
    Comment,
  },
  methods: {
    updatePost: function () {
      this.$router.push({ name: 'UpdatePost', params: { post_pk: this.post.id }})
    },
    createComment: function () {
      if (this.commentContent.length > 0) {
        const commentItem = { 
          content: this.commentContent, 
          userId: this.$store.state.userInfo.id 
        }
        axios({
          method: 'post',
          url: `/api/v1/article/${this.post.id}`,
          headers: {
            Authorization: `Bearer ${localStorage.getItem('jwt')}`
          },
          data: commentItem
        })
        .then(res => {
          if (res.data.statusCode === 200) {
            this.commentContent = ''
            this.renderComponent += 1
          }
        })
      }
    },
  },
  created: function () {
    this.$store.dispatch('getPost', this.$route.params.post_pk)
  },
  computed: {
    post: function () {
      return this.$store.state.post
    }
    
  }
}
</script>

<style>

</style>