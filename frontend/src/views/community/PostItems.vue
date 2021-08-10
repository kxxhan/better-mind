<template>
  <v-container id="post-items">   
    <BackBtn/>
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
                v-for="item in category"
                :key="item"
                @click="selectCategory(item)"
              >
                {{ item }}
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
        <!-- 선택 카테고리에 대한 게시글 렌더링 -->
        <v-row v-if="selectCategories.length">
          <v-col
            v-for="post in selectPosts"
            :key="post.id"
            cols="12"
            md="6"
          >
            <v-item>
              <v-card
                class="d-flex flex-column justify-center"
                height="250"
                @click="showDetail(post)"
              >
                <v-card-title>
                  {{ post.title }}
                </v-card-title>

                <v-card-subtitle>
                  {{ post.category }}
                </v-card-subtitle>

                <v-card-text>
                  {{ post.content }}
                </v-card-text>

                <v-card-actions>
                  <v-spacer></v-spacer>

                  <v-btn icon>
                    <v-icon>mdi-heart</v-icon>
                    <span>-</span>
                  </v-btn>

                  <v-btn icon>
                    <v-icon>mdi-message-text</v-icon>
                    <span>-</span>
                  </v-btn>

                </v-card-actions>
              </v-card>
            </v-item>
          </v-col>
        </v-row>
        <!-- 카테고리 미 선택 시 전체 게시글 렌더링 -->
        <v-row v-else>
          <v-col
            v-for="post in postList"
            :key="post.id"
            cols="12"
            md="6"
          >
            <v-item>
              <v-card
                class="d-flex flex-column justify-center"
                height="250"
                @click="showDetail(post)"
              >
                <v-card-title>
                  {{ post.title }}
                </v-card-title>

                <v-card-subtitle>
                  {{ post.category }}
                </v-card-subtitle>

                <v-card-text>
                  {{ post.content }}
                </v-card-text>

                <v-card-actions>
                  <v-spacer></v-spacer>

                  <v-btn icon>
                    <v-icon>mdi-heart</v-icon>
                    <span>-</span>
                  </v-btn>

                  <v-btn icon>
                    <v-icon>mdi-message-text</v-icon>
                    <span>-</span>
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
import BackBtn from '@/components/BackBtn.vue'

export default {
  name: 'PostItems',
  data: () => ({
    category: ['우울', '불안', '성격문제', '애착', 
          '대인기피', '분노조절', '자존감', 
          '중독', '대인관계', '부부', '가족상담',
        ],
    selectCategories: [],
    selectPosts: []
  }),
  components: {
    BackBtn,
  },
  methods: {
    showDetail: function (post) {
      this.$router.push({ name: 'PostDetail', params: { post_pk: post.id }})
    },
    createPost: function () {
      this.$router.push({ name: 'CreatePost' })
    },
    // 선택한 카테고리에 해당하는 게시글 필터링
    selectCategory: function (item) {
      this.selectPosts = []
      if (this.selectCategories.includes(item)){
        const idx = this.selectCategories.indexOf(item)
        this.selectCategories.splice(idx, 1)
      } else {
        this.selectCategories.push(item)
      }      
      for (const category of this.selectCategories) {
        for (const post of this.$store.state.postlist) {
            if (post.category === category){
            this.selectPosts.push(post)
          }
        }
      }
    },
  },
  // 전체 게시글 호출 API 연결 store
  computed: {
    postList: function () {
      return this.$store.state.postlist
    }
  },
  created: function () {
    this.$store.dispatch('getPosts')
  },
}
</script>

<style>

</style>