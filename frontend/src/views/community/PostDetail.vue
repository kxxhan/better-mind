<template>
  <v-container id="post-detail">
    <BackBtn/>
    <!-- 게시글 상세내용 -->
    <v-card
      class="mx-auto mb-5"
    >
      <v-container id="post">

        <v-card-text>
          <p class="text-h4 text--primary">{{ post.title }}</p>
          <p class="text-subtitle-1">{{ post.userId }}</p>
          <v-divider></v-divider>
          <p class="text--primary mt-4">{{ post.content }}</p>
        </v-card-text>

        <v-card-actions>
          <span class="text-subtitle-2"># {{ post.category }}</span>
          <v-spacer></v-spacer>
          <v-btn icon class="mx-2">
            <v-icon>mdi-heart</v-icon>
            <span>{{ post.likeCount }}</span>
          </v-btn>
        </v-card-actions>
        
        <v-card-actions v-show="post.userId === this.$store.state.userInfo.userid">
          <v-btn @click="updatePost(post)">수정</v-btn>
          <v-btn @click="deletePost(post)">삭제</v-btn>
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
    <Comment :key="renderComponent" @render="deleteRender"/>
  </v-container>
</template>

<script>
import axios from 'axios'
import Comment from '@/components/community/Comment.vue'
import BackBtn from '@/components/BackBtn.vue'

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
    BackBtn,
  },
  methods: {
    // 게시글 업데이트 링크 이동
    updatePost: function () {
      this.$router.push({ name: 'UpdatePost', params: { post_pk: this.post.id }})
    },
    // 게시글 삭제 Axios
    deletePost: function () {
      axios({
        method: 'delete',
        url: `/api/v1/article/${this.post.id}`,
        headers: {
          Authorization: `Bearer ${localStorage.getItem('jwt')}`
        },
      })
      .then(() => {
        this.$router.push({ name: 'PostItems' })
      })
    },
    // 댓글 작성 Axios + 작성 후 댓글 컴포넌트 reload
    createComment: function () {
      if (this.commentContent.length > 0) {
        const commentItem = { 
          content: this.commentContent, 
          userId: this.$store.state.userInfo.userid 
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
    // 삭제후 댓글 컴포넌트만 reload
    deleteRender: function () {
      this.renderComponent += 1
    }
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