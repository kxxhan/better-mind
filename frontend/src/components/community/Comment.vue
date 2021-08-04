<template>
  <v-container id="comment">
    <v-list disabled>
      <v-subheader>Comment List</v-subheader>
        <v-list-item
          v-for="(comment, i) in comments"
          :key="i"
        >
          <v-list-item-content>
            <v-list-item-title v-text="comment.content"></v-list-item-title>
            <hr>
          </v-list-item-content>
        </v-list-item>
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
    }
  },
  created: function () {
    this.$store.dispatch('getPost', this.$route.params.post_pk)
  }
}
</script>

<style>

</style>