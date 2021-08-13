<template>
  <div class="page-layout">
    <v-container>   
      <BackBtn/>
      <h1 class="d-flex justify-center">Community</h1>
      <header>
        <div class="banner">
          <h2>We help you achieve your goals</h2>
        </div>
      </header>

      <v-row class="mt-5">
        <!-- 분류 키워드 Chips Group -->
        <v-col
          cols="10"
        >
          <v-sheet
            color= transparent
          >
            <div class="pa-4">
              <v-chip-group
                active-class="primary--text"
                column
                multiple
              >
                <v-chip
                  large
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
        <v-col 
          cols="2"
          class="d-flex align-center justify-end text-h6"
          @click="createPost()"
        >
          <v-btn
            outlined 
            color="indigo"
          >
            NEW
          </v-btn>
        </v-col>
      </v-row>
      
      <!-- 게시글 리스트 -->
      <v-container>
        <!-- 선택 카테고리에 대한 게시글 렌더링 -->
        <v-row v-if="selectCategories.length">
          <v-col
            v-for="post in selectPosts"
            :key="post.id"
            cols="12"
            md="6"
          >
            <v-card
              class="d-flex flex-column justify-center px-5"
              height="250"
              @click="showDetail(post)"
            >
              <v-card-title class="mb-1 card-title text-h5">
                {{ post.title }}
              </v-card-title>

              <v-card-subtitle class="card-content text-overline">
                #{{ post.category }}
              </v-card-subtitle>

              <v-card-text class="card-content text-subtitle-1 text-truncate">
                {{ post.content }}
              </v-card-text>

              <v-card-actions>
                <v-spacer></v-spacer>
                <div>
                  <v-icon>mdi-comment</v-icon>
                  <span class="ms-1 text-overline grey--text text--darken-2">{{ post.commentCount }}</span>
                </div>
                <div class="ms-3" v-if="post.like">
                  <v-icon>mdi-heart</v-icon>
                  <span class="ms-1 text-overline grey--text text--darken-2">{{ post.likeCount }}</span>
                </div>
                <div class="ms-3" v-else>
                  <v-icon>mdi-heart-outline</v-icon>
                  <span class="ms-1 text-overline grey--text text--darken-2">{{ post.likeCount }}</span>
                </div>
              </v-card-actions>
            </v-card>
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
            <v-card
              class="d-flex flex-column justify-center px-5"
              height="250"
              @click="showDetail(post)"
            >
              <v-card-title class="mb-1 card-title text-h5">
                {{ post.title }}
              </v-card-title>

              <v-card-subtitle class="card-content text-overline">
                #{{ post.category }}
              </v-card-subtitle>

              <v-card-text class="card-content text-subtitle-1 text-truncate">
                {{ post.content }}
              </v-card-text>

              <v-card-actions>
                <v-spacer></v-spacer>
                <div>
                  <v-icon>mdi-comment</v-icon>
                  <span class="ms-1 text-overline grey--text text--darken-2">{{ post.commentCount }}</span>
                </div>
                <div class="ms-3" v-if="post.like">
                  <v-icon>mdi-heart</v-icon>
                  <span class="ms-1 text-overline grey--text text--darken-2">{{ post.likeCount }}</span>
                </div>
                <div class="ms-3" v-else>
                  <v-icon>mdi-heart-outline</v-icon>
                  <span class="ms-1 text-overline grey--text text--darken-2">{{ post.likeCount }}</span>
                </div>
              </v-card-actions>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
      <Footer/>
      <CircleBtn/>
    </v-container>
  </div>
</template>

<script>
import BackBtn from '@/components/BackBtn.vue'
import Footer from '@/components/footer/Footer.vue'
import CircleBtn from '@/components/footer/CircleBtn.vue'

export default {
  name: 'PostItems',
  data: () => ({
    category: [
      '일반고민', '취업진로', '직장', '연애', 
      '성추행', '대인관계', '외모', 
      '가족', '학업', '금전', '이별이혼', 
      '육아', '중독', '건강', '성격'
    ],
    selectCategories: [],
    selectPosts: []
  }),
  components: {
    BackBtn,
    Footer,
    CircleBtn,
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

<style scoped>
@font-face {
    font-family: 'NEXON Lv1 Gothic OTF';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@2.1/NEXON Lv1 Gothic OTF.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

@font-face {
    font-family: 'NEXON Lv1 Gothic OTF Bold';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@2.1/NEXON Lv1 Gothic OTF Bold.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
.v-card {
	background-color: transparent;
}
.page-layout {
  max-width: 1200px;
  margin: 0 auto;
}
header{
  background:#ededed;
}
.banner{
  background:#B5C3D5;
  height:280px;
  margin-top: 20px;
}
.banner>h2{
  /* height:50px; */
  line-height:50px;
  position:relative;
  text-align:center;
  top:115px;
  margin:0 auto;  
  width:50%;
  font-size:2.5em;
  color:#25271E;
}
.card-title {
  font-family: 'NEXON Lv1 Gothic OTF Bold' !important;
}
.card-content {
  font-family: 'NEXON Lv1 Gothic OTF' !important;
}
</style>