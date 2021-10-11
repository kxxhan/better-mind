<template>
  <v-container id="create-post">
    <v-btn 
      @click="moveBack()"
      icon
      x-large
    >
      <v-icon>mdi-arrow-left-thick</v-icon>
    </v-btn>

    <h1 class="d-flex justify-center">Create Post</h1>
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
        @click="movePostItems"
      >
        Back
      </v-btn>
    </v-form>
    <Footer/>
    <CircleBtn/>
  </v-container>
</template>

<script>
import axios from 'axios'
import Footer from '@/components/footer/Footer.vue'
import CircleBtn from '@/components/footer/CircleBtn.vue'

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
      '일반고민', '취업진로', '직장', '연애', 
      '성추행', '대인관계', '외모', 
      '가족', '학업', '금전', '이별이혼', 
      '육아', '중독', '건강', '성격'
    ],
  }),
  components: {
    Footer,
    CircleBtn,
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
    moveBack: function () {
      this.$router.push({ name: 'PostItems' })
    }
  },
}
</script>

<style scoped>
#create-post {
  max-width: 1200px;
  margin: 0 auto;
}
.backbtn {
  text-decoration-line:line-through;
  background-color: none;
}
</style>