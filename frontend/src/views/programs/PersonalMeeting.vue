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

      <h1 class="d-flex justify-center text-h2 font-weight-medium mb-7">MIND ONE</h1>

      <v-row>
        <v-col
          cols="12"
        >
          <v-img
            src="../../assets/banner_personal.png"
          ></v-img>
        </v-col>
      </v-row>

      <v-row class="mt-5">
        <!-- 분류 키워드 Chips Group -->
        <v-col>
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
          <v-card class="mt-4" color="transparent" rounded="lg" outlined max-height="584px">
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
                <v-card-text class="grey--text">{{ program.description }}</v-card-text>
                <v-divider></v-divider>
                <v-card-text class="card-content text-body-1">{{ program.report }}</v-card-text>
                <v-card-actions class="pe-6">
                  <v-spacer></v-spacer>
                  <!-- 결제 페이지로 바로 연결 -->
                  <v-btn text color="indigo" @click="registrateProgram(program)">신청</v-btn>
                </v-card-actions>
              </v-col>
            </v-row>
          </v-card>
        </v-col>
      </v-row>

      <!-- 카테고리 미 선택 시 전체 프로그램 렌더링 -->
      <v-row v-else>
        <v-col
          v-for="program in programlist"
          :key="program.id"
          cols="12"
          md="6"
        >
          <v-card class="mt-4" color="transparent" rounded="lg" outlined>
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
                <v-card-text class="grey--text">{{ program.description }}</v-card-text>
                <v-divider></v-divider>
                <v-card-text class="card-content text-body-1">{{ program.report }}</v-card-text>
                <v-card-actions class="pe-6">
                  <v-spacer></v-spacer>
                  <!-- 결제 페이지로 바로 연결 -->
                  <v-btn text color="indigo" @click="registrateProgram(program)">신청</v-btn>
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
  name: 'PersonalMeeting',
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
  components: {
    Footer,
    CircleBtn,
  },
  methods: {
    registrateProgram: function (program) {
      this.$router.push({ name: 'Payment', params: { program_pk: program.id }})
    },
    // 선택한 카테고리에 해당하는 게시글 필터링
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
            if (program.category === category && program.type === '0'){
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
        if (program.type === '0'){
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
/* @import '../css/PersonalMeeting.css'; */
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
.card-img {
  border-radius: 20px;
}
.card-title {
  font-family: 'NEXON Lv1 Gothic OTF Bold' !important;
}
.card-content {
  font-family: 'NEXON Lv1 Gothic OTF' !important;
}
</style>