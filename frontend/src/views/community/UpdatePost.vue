<template>
  <v-container id="update-post">
    <BackBtn/>
    <h1 class="d-flex justify-center">Update Post</h1>
    <v-form
      class="mt-5"
      ref="form"
      v-model="valid"
      lazy-validation
    >      
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
        class="mr-4"
        @click="submit"
      >
        Submit
      </v-btn>

      <v-btn
        @click="movePost()"
      >
        Back
      </v-btn>
    </v-form>
    <CircleBtn/>
    <Footer/>
  </v-container>
</template>

<script>
import axios from 'axios'
import BackBtn from '@/components/BackBtn.vue'
import Footer from '@/components/footer/Footer.vue'
import CircleBtn from '@/components/footer/CircleBtn.vue'

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
      category: [
        '일반고민', '취업진로', '직장', '연애', 
        '성추행', '대인관계', '외모', 
        '가족', '학업', '금전', '이별이혼', 
        '육아', '중독', '건강', '성격'
      ],
    }
  },
  components: {
    BackBtn,
    Footer,
    CircleBtn,
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

<style scoped>
#update-post {
  max-width: 1200px;
  margin: 0 auto;
}
</style>