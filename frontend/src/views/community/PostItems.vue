<template>
  <v-container id="post-items">   
    <v-row justify="center">
      <!-- 분류 키워드 Chips Group -->
      <v-col
        cols="11"
        sm="10"
        md="9"
        lg="8"
      >
        <v-sheet
          elevation="10"
          rounded="xl"
        >
          <div class="pa-4">
            <v-chip-group
              active-class="primary--text"
              column
              multiple
            >
              <v-chip
              v-for="tag in tags"
              :key="tag"
              >
                {{ tag }}
              </v-chip>
            </v-chip-group>
          </div>
        </v-sheet>
      </v-col>
      <!-- 게시글 생성 페이지 이동 버튼 -->
      <v-col cols="1">
        <v-btn @click="createPost()">create</v-btn>
      </v-col>
    </v-row>

    <!-- 게시글 리스트 -->
    <v-item-group>
      <v-container>
        <v-row>
          <v-col
            v-for="n in 6"
            :key="n"
            cols="12"
            md="6"
          >
            <v-item v-slot="{ toggle }">
              <v-card
                class="d-flex flex-column justify-center"
                height="250"
                @click="toggle"
              >
                <v-card-title>
                  Card title
                </v-card-title>

                <v-card-subtitle>
                  Subtitle text
                </v-card-subtitle>

                <v-card-text>
                  Greyhound divisively hello coldly wonderfully marginally far upon excluding.
                </v-card-text>

                <v-card-actions>
                  <v-spacer></v-spacer>

                  <v-btn icon>
                    <v-icon>mdi-heart</v-icon>
                    <span>3</span>
                  </v-btn>

                  <v-btn icon>
                    <v-icon>mdi-message-text</v-icon>
                    <span>2</span>
                  </v-btn>

                </v-card-actions>
              </v-card>
            </v-item>
          </v-col>
        </v-row>
      </v-container>
    </v-item-group>

  </v-container>
</template>

<script>
export default {
  name: 'PostItems',
  data: () => ({
    tags: [
      '학교',
      '직장',
      '대인 관계',
      '가족',
      '외모',
      '등'
    ]
  }),
  methods: {
    showDetail: function () {
      this.$router.push({ name: 'PostDetail' })
    },
    createPost: function () {
      this.$router.push({ name: 'CreatePost' })
    }
  },
  // 전체 게시글 호출 API 연결 store
  // computed: {
  //   postList: function () {
  //     return this.$store.state.postlist
  //   }
  // },
  // created: function () {
  //   this.$store.dispatch('getPosts')
  // },
}
</script>

<style>

</style>