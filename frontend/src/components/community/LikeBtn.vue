<template>
  <div>
    <v-btn v-if="post.like" text class="mx-2" color="grey darken-2" @click="unlikePost(post)">
      <v-icon class="mr-1">mdi-heart</v-icon>
      <span>{{ post.likeCount }}</span>
    </v-btn>
    <v-btn v-else text class="mx-2" color="grey darken-2" @click="likePost(post)">
      <v-icon class="mr-1">mdi-heart-outline</v-icon>
      <span>{{ post.likeCount }}</span>
    </v-btn>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'LikeBtn',
  methods: {
    // 좋아요 기능 확인하기
    likePost: function (post) {
      axios({
        method: 'get',
        url: `/api/v1/article/like/${this.post.id}`,
        headers: {
          Authorization: `Bearer ${localStorage.getItem('jwt')}`
        },
      })
      .then(res => {
        this.$emit('likeRender')
      })
    },
    unlikePost: function (post) {
      axios({
        method: 'get',
        url: `/api/v1/article/hate/${this.post.id}`,
        headers: {
          Authorization: `Bearer ${localStorage.getItem('jwt')}`
        },
      })
      .then(res => {
        this.$emit('likeRender')
      })
    },
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