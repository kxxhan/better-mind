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
        '학교',
        '직장',
        '대인 관계',
        '가족',
        '외모',
        '등'
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
    // 카테고리 값 넘어와야 적용 가능
    // this.category = this.$store.state.post.category
  }
}
</script>

<style>

</style>