<template>
  <div>
    <v-container id="program-detail">
      <div>
        <!-- 프로그램 소개 -->
        <v-container>
          <v-row>
            <v-col class="d-flex justify-center">
              <v-img
                :src="`https://picsum.photos/500/300?image=20`"
                class="thumnail"        
              >
              </v-img>
            </v-col>
            <v-col>
              <!-- <div class="text-h4 d-flex justify-center">상처없이 이야기하기 (가족편)</div> -->
              <div class="text-h4 d-flex justify-center">{{ program.name }}</div>
              <br>
              <div class="text-h6 d-flex justify-center">By {{ program.userId }} 상담사</div>
              <br>
              <div class="text-h6 d-flex justify-center">{{ program.date }}</div>
              <br>
              <div class="text-h6 d-flex justify-center">{{ program.time }}</div>
              <br>
              <div class="text-h6 d-flex justify-center">{{ program.category }}</div>
              <!-- <br>
              <div class="text-h6 d-flex justify-center">by 김싸피 상담사</div>
              <br>
              <div class="text-h6 d-flex justify-center">7월 26일 ~ 8월 16일</div>
              <br>
              <div class="text-h6 d-flex justify-center">주 2회 (월, 목) 19:00 ~ 21:00</div>
              <br>
              <div class="text-h6 d-flex justify-center">#가족 #대인관계</div> -->
            </v-col>
          </v-row>
        </v-container>

        <!-- 중간 네비게이션바 -->
        <v-app-bar class="mt-5">
          <v-tabs align-with-title>
            <v-tab @click="clickProgramIntroduce()">프로그램 소개</v-tab>
            <v-tab @click="clickExpertIntroduce()">전문가 소개</v-tab>
            <v-tab @click="clickProgramReview()">후기</v-tab>
            <v-tab @click="clickProgramResistraion()">신청하기</v-tab>
          </v-tabs>
        </v-app-bar>
        <br>

        <!-- 프로그램 디테일 소개 -->
        <v-container>
          <div class="text-h6" id="program-introduce">프로그램 내용 소개 글</div>
          <div>{{ program.report }}</div>
        </v-container>
        <br>
        <v-container>
          <div class="text-h6" id="expert-introduce">전문가 소개 글</div>
          <div>{{ program.description }}</div>
        </v-container>
        <br>
        <v-container>
          <div class="text-h6" id="program-review">프로그램 이용 후기</div>
          <div>{{ program.review }}</div>


        </v-container>
        <br>
        <v-container>
        <div class="text-h6" id="program-registration">프로그램 신청하기</div>
        <span>{{ program.price }}</span>
        </v-container>
        <br>
        <v-btn @click="registrateProgram(program)">신청하기</v-btn>
        <v-btn @click="previousPage()">이전</v-btn>
      </div>
    </v-container>
    <CircleBtn/>
    <Footer/>
  </div>
</template>

<script>
import Footer from '@/components/footer/Footer.vue'
import CircleBtn from '@/components/footer/CircleBtn.vue'

export default {
  name: 'ProgramDetail',
  components: {
    Footer,
    CircleBtn
  },
  methods: {
    previousPage: function () {
      this.$router.push({ name: 'ProgramItems' })
    },
    registrateProgram: function (program) {
      this.$router.push({ name: 'Payment', params: { program_pk: program.id }})
    },
    clickProgramIntroduce: function () {
      const programLocation = document.querySelector("#program-introduce").offsetTop;
      window.scrollTo({top:programLocation-100, left:0, behavior:'auto'})
    },
    clickExpertIntroduce: function () {
      const expertlocation = document.querySelector("#expert-introduce").offsetTop;
      window.scrollTo({top:expertlocation, left:0, behavior:'auto'})
    },
    clickProgramReview: function () {
      const reviewLocation = document.querySelector("#program-review").offsetTop;
      window.scrollTo({top:reviewLocation, left:0, behavior:'auto'})
    },
    clickProgramResistraion: function () {
      const registLocation = document.querySelector("#program-registration").offsetTop;
      window.scrollTo({top:registLocation, left:0, behavior:'auto'})
      // window.location.href = '#program-registration'
    }
  },
  created: function () {
    this.$store.dispatch('getProgram', this.$route.params.program_pk)
  },
  computed: {
    program: function () {
      return this.$store.state.program
    }
  }
}
</script>

<style scoped>
.thumnail {
  height: 400px;
  width: 400px;
}
</style>