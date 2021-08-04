<template>
  <v-container id="comment">
    <v-list>
      <v-subheader>Comment List</v-subheader>
        <v-divider></v-divider>
        <v-container>
          <v-list-item
            v-for="(comment, i) in comments"
            :key="i"
          >
            
            <v-list-item-content>
              <v-list-item-subtitle v-text="comment.userId"></v-list-item-subtitle>
              <v-list-item-title v-text="comment.content"></v-list-item-title>
            </v-list-item-content>
            <v-list-item-action v-show="comment.userId === userInfo.id">
              <!-- 삭제하려면 comment id가 필요하지만 알 방법이 없음 -->
              <v-btn icon>
                <v-icon>mdi-window-close</v-icon>
              </v-btn>
            </v-list-item-action>
          </v-list-item>
        </v-container>
    </v-list>
  </v-container>
</template>

<script>
export default {
  name: 'Comment',
  methods: {

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