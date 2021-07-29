<template>
  <v-container id="create-post">
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
        v-model="select"
        :items="category"
        :rules="[v => !!v || 'Category is required']"
        label="Category"
        required
      ></v-select>

      <v-text-field
        v-model="hashtag"
        :rules="hashtagRules"
        label="Hashtag"
        required
      ></v-text-field>

      <v-btn
        :disabled="!valid"
        color="success"
        class="mr-4"
        @click="submit"
      >
        Submit
      </v-btn>

      <!-- <v-btn
        color="error"
        class="mr-4"
        @click="reset"
      >
        Reset Form
      </v-btn> -->

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
export default {
  data: () => ({
    valid: true,
    title: '',
    titleRules: [
      v => !!v || 'Title is required',
      v => (v && v.length <= 50) || 'Title must be less than 50 characters',
    ],
    content: '',
    contentRules: [
      v => !!v || 'Content is required',
      v => (v && v.length > 0) || 'Content must be valid',
    ],
    select: null,
    category: [
      '학교',
      '직장',
      '대인 관계',
      '가족',
      '외모',
      '등'
    ],
    hashtag: '',
    hashtagRules: [
      v => !!v || 'Hashtag is required',
      v => (v && v.length > 0) || 'Hashtag must be valid',
    ],
  }),

  methods: {
    submit () {
      if (this.$refs.form.validate()) {
        console.log('submit')
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