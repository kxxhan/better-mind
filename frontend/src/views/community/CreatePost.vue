<template>
  <v-container id="create-post">
    <BackBtn/>
    <v-form
      ref="form"
      v-model="valid"
      lazy-validation
    >
      <div class="text-h6">게시글 작성</div>
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
        @click="movePostItems"
      >
        Back
      </v-btn>
    </v-form>
  </v-container>
</template>

<script>
import axios from 'axios'
import BackBtn from '@/components/BackBtn.vue'

export default {
  data: () => ({
    valid: true,
    title: '',
    content: '',
    category: null,
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
  }),
  components: {
    BackBtn,
  },
  methods: {
    submit () {
      if (this.$refs.form.validate()) {
        const postItem = {
          title: this.title,
          content: this.content,
          category: this.category,
          userId: this.$store.state.userInfo.userid,
          // like 값은 왜 보내주는 이유? read only로 전환 필요
          like: true,
        }
        axios({
          method: 'post',
          url: '/api/v1/article',
          headers: {
            Authorization: `Bearer ${localStorage.getItem('jwt')}`
          },
          data: postItem
        })
        .then(() => {
          this.$router.push({ name: 'PostItems' })
        })
      }
    },
    // reset () {
    //   this.$refs.form.reset()
    // },
    movePostItems () {
      this.$router.push({ name: 'PostItems' })
    },
  },
}
</script>

<style>

</style>