<template>
  <!-- <div class="page-layout"> -->
    <v-container id="post-detail">
      <v-btn 
      @click="moveBack()"
        icon
        x-large
      >
        <v-icon>mdi-arrow-left-thick</v-icon>
      </v-btn>
      <!-- 게시글 상세내용 -->
      <v-card
        class="mx-auto mb-5"
        color="transparent"
        shaped
      >
        <v-container id="post">

          <v-card-text>
            <p class="text-h4 text--primary my-font-bold">{{ post.title }}</p>
            <p class="grey--text my-font-reg">{{ post.userId }}</p>
            <v-divider></v-divider>
            <v-card flat min-height="250px" color="transparent">
              <p class="mt-4 my-font-reg">{{ post.content }}</p>
            </v-card>
          </v-card-text>
          <v-divider class="mx-3"></v-divider>
          <v-card-actions>
            <span class="grey--text my-font-reg ms-3"># {{ post.category }}</span>
            <v-spacer></v-spacer>
            <LikeBtn :key="renderComponent" @likeRender="updateLike"/>
          </v-card-actions>
          
          <v-card-actions class="mt-3" v-show="post.userId === this.$store.state.userInfo.userid">
            <v-spacer></v-spacer>
            <v-btn text @click="updatePost(post)" color="grey darken-1">
              <v-icon>
                mdi-file-edit-outline
              </v-icon>
              EDIT
            </v-btn>
            <v-btn text @click="deletePost(post)" color="grey darken-1">
              <v-icon>
                mdi-delete
              </v-icon>
              DELETE
            </v-btn>
          </v-card-actions>
        </v-container>
      </v-card>
      
      <!-- 댓글작성 폼 -->
      <v-row 
        class="mt-5 px-5 d-flex align-center"
      >
        <v-textarea
          auto-grow
          prepend-inner-icon="mdi-comment"
          class="mx-2"
          label="comment"
          rows="1"
          cols="10"
          v-model="commentContent"
        ></v-textarea>
        <!-- <input type="text" id="comment" name="comment" required> -->
        <v-btn 
          text
          cols="1"
          @click="createComment(post)"
        >
          SUBMIT
        </v-btn>
      </v-row>

      <!-- 댓글 리스트 -->
      <Comment :key="renderComponent" @render="deleteRender"/>
      <Footer/>
      <CircleBtn/>
    </v-container>
  <!-- </div> -->
</template>

<script>
import axios from 'axios'
import Comment from '@/components/community/Comment.vue'
import LikeBtn from '@/components/community/LikeBtn.vue'
import Footer from '@/components/footer/Footer.vue'
import CircleBtn from '@/components/footer/CircleBtn.vue'

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
    Footer,
    CircleBtn,
    LikeBtn
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
    // 좋아요 클릭 후 컴포넌트만 reload
    updateLike: function () {
      this.renderComponent += 1
    },
    // 삭제후 댓글 컴포넌트만 reload
    deleteRender: function () {
      this.renderComponent += 1
    },
    moveBack: function () {
      this.$router.push({ name: 'PostItems' })
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

<style scoped>
@font-face {
    font-family: 'NEXON Lv1 Gothic OTF';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@2.1/NEXON Lv1 Gothic OTF.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
@font-face {
    font-family: 'NEXON Lv1 Gothic OTF Bold';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@2.1/NEXON Lv1 Gothic OTF Bold.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
.my-font-bold {
  font-family: 'NEXON Lv1 Gothic OTF Bold' !important;
}
.my-font-reg {
  font-family: 'NEXON Lv1 Gothic OTF' !important;
}
#post-detail {
  max-width: 1200px;
  margin: 0 auto;
}
</style>