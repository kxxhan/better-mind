<template>
  <v-container id="update-post">
    <v-form
      ref="form"
      v-model="valid"
      lazy-validation
    >
      <div class="text-h6">게시글 수정</div>
      <v-text-field
        v-model="title"
        :counter="50"
        :rules="titleRules"
        label="Title"
        required
      ></v-text-field>

      <v-textarea
        outlined
        v-model="content"
        :rules="contentRules"
        label="Content"
        required
        height="350px"
      ></v-textarea>

      <v-select
        v-model="category"
        :items="categories"
        :rules="[v => !!v || 'Category is required']"
        label="Category"
        required
      ></v-select>

      <v-btn
        :disabled="!valid"
        color="success"
        class="mr-4"
        @click="submit"
      >
        Submit
      </v-btn>

      <v-btn
        color="warning"
        @click="movePost()"
      >
        Back
      </v-btn>
    </v-form>
  </v-container>
</template>

<script>
import axios from 'axios'

export default {
  name: 'UpdatePost',
  data: function () {
    return {
      valid: true,
      title: '',
      content: '',
      category: '',
      titleRules: [
        v => !!v || 'Title is required',
        v => (v && v.length <= 50) || 'Title must be less than 50 characters',
      ],
      contentRules: [
        v => !!v || 'Content is required',
        v => (v && v.length > 0) || 'Content must be valid',
      ],
      categories: [
        '우울', 
        '불안', 
        '성격문제', 
        '애착', 
        '대인기피', 
        '분노조절', 
        '자존감', 
        '중독', 
        '대인관계', 
        '부부', 
        '가족상담',
      ],
    }
  },
  methods: {
    submit: function () {
      if (this.$refs.form.validate()) {
        const postItem = {
          title: this.title,
          content: this.content,
          category: this.category,
          userId: this.$store.state.post.userId,
          like: true,
        }
        axios({
          method: 'put',
          url: `/api/v1/article/${this.$route.params.post_pk}`,
          headers: {
            Authorization: `Bearer ${localStorage.getItem('jwt')}`
          },
          data: postItem
        })
        .then(() => {
          this.$router.push({ name: 'PostDetail', params: {post_pk: this.$route.params.post_pk }})
        })
      }
    },
    movePost: function () {
      this.$router.push({ name: 'PostDetail', params: {post_pk: this.$route.params.post_pk }})
    },
  },
  created: function () {
    this.$store.dispatch('getPost', this.$route.params.post_pk)
    this.title = this.$store.state.post.title
    this.content = this.$store.state.post.content
    this.category = this.$store.state.post.category
  }
}
</script>

<style>

</style>