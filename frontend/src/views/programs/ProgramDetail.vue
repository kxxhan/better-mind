<template>
  <div>
    <v-container id="program-detail">
      <BackBtn/>
      <v-card class="mt-5" color="transparent" flat>
        <v-row>
          <v-col class="d-flex justify-center px-6">
            <v-img
              style="border-radius: 20px;"
              max-height="239px"
              max-width="400px"
              src="https://images.unsplash.com/photo-1604881990409-b9f246db39da?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTF8fGNvdW5zZWxpbmd8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
            >
            </v-img>
          </v-col>
          <v-col>
            <v-card-title>{{ program.name }}</v-card-title>
            <v-card-subtitle>
              <p class="mb-0 grey--text text--darken-2">{{ program.date}} | {{ program.time }}</p>
              <p class="grey--text text--darken-2">{{ program.userId }} 상담사</p>
            </v-card-subtitle>
            <v-card-text>
              <div class="d-flex justify-space-between mb-3">
                <span># {{ program.category }}</span>
                <span>최대 신청 가능 인원 : {{ program.count }}</span>
              </div>
            </v-card-text>
            <v-divider class="me-4"></v-divider>
            <v-card-actions class="pt-4">
              <p class="my-auto">프로그램 가격 : {{ program.price }}</p>
              <v-spacer></v-spacer>
              <v-btn text class="me-4" @click="registrateProgram(program)">
                APPLY
              </v-btn>
            </v-card-actions>
          </v-col>
        </v-row>
      </v-card>

      <v-tabs
        class="mt-16"
        background-color="transparent"
        color="grey darken-2"
        fixed-tabs
        v-model="tab"
      >
        <v-tabs-slider color="#E1BEE7"></v-tabs-slider>
        <v-tab>전문가 소개</v-tab>
        <v-tab>프로그램 소개</v-tab>
        <v-tab>프로그램 후기</v-tab>
      </v-tabs>

      <v-tabs-items 
        v-model="tab"
      >
        <v-tab-item>
          <v-card color="tab-card-item" flat>
            <v-card-text style="background-color: transparent;">{{ program.description }}</v-card-text>
          </v-card>
        </v-tab-item>
        <v-tab-item>
          <v-card color="tab-card-item" flat>
            <v-card-text>{{ program.report }}</v-card-text>
          </v-card>
        </v-tab-item>
        <v-tab-item>
          <v-card color="tab-card-item" flat>
            <v-card-text>{{ program.review }}</v-card-text>
          </v-card>
        </v-tab-item>
      </v-tabs-items>

      <!-- <div>
        <v-app-bar class="mt-16" color="transparent" flat>
          <v-tabs class="d-flex justify-space-around" align-with-title>
            <v-tab class="me-5" @click="clickProgramIntroduce()">프로그램 소개</v-tab>
            <v-tab class="me-5" @click="clickExpertIntroduce()">전문가 소개</v-tab>
            <v-tab class="me-5" @click="clickProgramReview()">후기</v-tab>
          </v-tabs>
        </v-app-bar>
        <br>

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
      </div> -->
    </v-container>
    <Footer/>
    <CircleBtn/>
  </div>
</template>

<script>
import Footer from '@/components/footer/Footer.vue'
import CircleBtn from '@/components/footer/CircleBtn.vue'
// import axios from 'axios'
import BackBtn from '@/components/BackBtn.vue'

export default {
  name: 'ProgramDetail',
  components: {
    Footer,
    CircleBtn,
    BackBtn,
  },
  data: function () {
    return {
      tab: null,
    }
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
/* .thumnail {
  height: 400px;
  width: 400px;
} */
#program-detail {
  max-width: 1200px;
}
.tab-card-item {
  background-color: transparent !important;
}
</style>