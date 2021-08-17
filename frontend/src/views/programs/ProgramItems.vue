<template>
  <div class="page-layout">
    <v-container>
      <v-btn 
        @click="moveBack()"
        icon
        x-large
      >
        <v-icon>mdi-arrow-left-thick</v-icon>
      </v-btn>
      
      <h1 class="d-flex justify-center">Personal Counseling</h1>

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
      </v-row>

      <!-- 선택 카테고리 프로그램 -->
      <v-row v-if="selectCategories.length">
        <v-col
          v-for="program in selectPrograms"
          :key="program.id"
          cols="12"
          md="6"
        >
          <v-card class="mt-4" color="transparent" rounded="lg" outlined @click="showDetail(program)">
            <v-row>
              <v-col cols="4" class="ps-6 d-flex flex-column justify-center">
                <v-img
                  class="card-img"
                  src="https://images.unsplash.com/photo-1604882355447-02f728a295a2?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTZ8fGNvdW5zZWxpbmd8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
                  width="300px"
                >
                </v-img>
              </v-col>

              <v-col cols="8" class="pe-6 d-flex flex-column justify-center">
                <v-card-title class="card-title text-h5">
                  {{ program.name }}
                </v-card-title>
                <v-card-subtitle>
                  # {{ program.category }}
                </v-card-subtitle>
                <v-card-text class="grey--text">{{ program.userId }} 전문가</v-card-text>
                <v-divider></v-divider>
                <v-card-text class="card-content text-body-1">제한인원: {{ program.count }}</v-card-text>
                <v-card-text class="card-content text-body-1">운영시간: {{ program.time }}</v-card-text>
                <v-card-actions class="pe-6">
                  <!-- 상세 페이지로 연결 -->
                  <v-btn outlined color="indigo">Detail</v-btn>
                </v-card-actions>
              </v-col>
            </v-row>
          </v-card>
        </v-col>
      </v-row>

      <!-- 카테고리 미 선택 시 전체 프로그램 -->
      <v-row v-else>
        <v-col
          v-for="program in programlist"
          :key="program.id"
          cols="12"
          md="6"
        >
          <v-card class="mt-4" color="transparent" rounded="lg" outlined @click="showDetail(program)">
            <v-row>
              <v-col cols="4" class="ps-6 d-flex flex-column justify-center">
                <v-img
                  class="card-img"
                  src="https://images.unsplash.com/photo-1604882355447-02f728a295a2?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTZ8fGNvdW5zZWxpbmd8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
                  width="300px"
                >
                </v-img>
              </v-col>

              <v-col cols="8" class="pe-6 d-flex flex-column justify-center">
                <v-card-title class="card-title text-h5">
                  {{ program.name }}
                </v-card-title>
                <v-card-subtitle>
                  # {{ program.category }}
                </v-card-subtitle>
                <v-card-text class="grey--text">{{ program.userId }} 전문가</v-card-text>
                <v-divider></v-divider>
                <v-card-text class="card-content text-body-1">제한인원: {{ program.count }}</v-card-text>
                <v-card-text class="card-content text-body-1">운영시간: {{ program.time }}</v-card-text>
                <v-card-actions class="pe-6">
                  <!-- 상세 페이지로 연결 -->
                  <v-btn outlined color="indigo">Detail</v-btn>
                </v-card-actions>
              </v-col>
            </v-row>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
    <CircleBtn/>
    <Footer/>
  </div>
</template>

<script>
import Footer from '@/components/footer/Footer.vue'
import CircleBtn from '@/components/footer/CircleBtn.vue'

export default {
  name: 'ProgramItems',
  components: {
    Footer,
    CircleBtn,
  },
  data: () => ({
    category: [
      '일반고민', '취업진로', '직장', '연애', 
      '성추행', '대인관계', '외모', 
      '가족', '학업', '금전', '이별이혼', 
      '육아', '중독', '건강', '성격'
    ],
    selectCategories: [],
    selectPrograms: []
  }),
  methods: {
    showDetail: function (program) {     
      this.$router.push({ name: 'ProgramDetail', params: { program_pk: program.id }})
    },
    // 선택한 카테고리에 해당하는 프로그램만 렌더링
    selectCategory: function (item) {
      this.selectPrograms = []
      if (this.selectCategories.includes(item)){
        const idx = this.selectCategories.indexOf(item)
        this.selectCategories.splice(idx, 1)
      } else {
        this.selectCategories.push(item)
      }      
      for (const category of this.selectCategories) {
        for (const program of this.$store.state.programlist) {
            if (program.category === category && program.type === '1'){
            this.selectPrograms.push(program)
          }
        }
      }
    },
    moveBack: function () {
      this.$router.push({ name: 'Main' })
    }
  },
  computed: {
    programlist: function () {
      const programset = []
      for (const program of this.$store.state.programlist) {
        if (program.type === '1'){
          programset.push(program)
        }        
      }
      return programset
    }
  },
  created: function () {
    this.$store.dispatch('getPrograms')
  }
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
.page-layout {
  padding: 1rem;
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
.card-img {
  border-radius: 20px;
}
.card-title {
  font-family: 'NEXON Lv1 Gothic OTF Bold' !important;
}
.card-content {
  font-family: 'NEXON Lv1 Gothic OTF' !important;
}
.backbtn {
  text-decoration-line:line-through;
  background-color: none;
}
</style>