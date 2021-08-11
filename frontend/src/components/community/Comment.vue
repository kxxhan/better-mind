<template>
  <v-container id="comment">
    <v-list color="transparent">
      <v-container>
        <v-list-item
          v-for="comment in comments"
          :key="comment.id"
        >
          <v-list-item-content>
            <v-list-item-subtitle v-text="comment.userId"></v-list-item-subtitle>
            <v-list-item-title v-text="comment.content"></v-list-item-title>
          </v-list-item-content>
          <v-list-item-action v-show="comment.userId === userInfo.userid">
            <v-btn icon @click="deleteComment(comment)">
              <v-icon>mdi-window-close</v-icon>
            </v-btn>
          </v-list-item-action>
        </v-list-item>
      </v-container>
    </v-list>
  </v-container>
</template>

<script>
import axios from 'axios'

export default {
  name: 'Comment',
  methods: {
    // 댓글 삭제 Axios 및 삭제 후 댓글 컴포넌트 reload를 위한 emit 전달
    deleteComment: function (comment) {
      axios({
        method: 'delete',
        url: `/api/v1/article/${this.$route.params.post_pk}/${comment.id}`,
        headers: {
          Authorization: `Bearer ${localStorage.getItem('jwt')}`
        }
      })
      .then(() => {
        this.$emit('render')
      })
    }
  },
  computed: {
    comments: function () {
      return this.$store.state.post.comments
    },
    userInfo: function () {
      return this.$store.state.userInfo
    }
  },
  created: function () {
    this.$store.dispatch('getPost', this.$route.params.post_pk)
  }
}
</script>

<style>

</style>