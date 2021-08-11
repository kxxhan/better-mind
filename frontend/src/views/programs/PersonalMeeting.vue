<template>
  <div class="page-content">
    <v-container>
      <BackBtn/>
      <h1 class="d-flex justify-center">Personal Counseling</h1>

      <header>
        <div class="banner">
          <h2>We help you achieve your goals</h2>
        </div>
      </header>

      <v-row class="my-5">
        <v-col
          v-for="n in 6"
          :key="n"
          cols="12"
          md="6"
        >
          <!-- <div class="card">
            <div class="content">
              <h2 class="title">To The Beach</h2>
              <p class="copy">Plan your next beach trip with these fabulous destinations</p>
              <button class="btn">View Trips</button>
            </div>
          </div> -->
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
                  프로그램 이름
                </v-card-title>
                <v-card-subtitle>
                  # 카테고리
                </v-card-subtitle>
                <v-card-text class="grey--text">간단한 전문가 소개가 작성되는 공간입니다.</v-card-text>
                <v-divider></v-divider>
                <v-card-text class="card-content text-body-1">간단한 프로그램 소개가 작성되는 공간입니다.</v-card-text>
                <v-card-actions class="pe-6">
                  <v-btn outlined color="indigo">APPLY</v-btn>
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
import BackBtn from '@/components/BackBtn.vue'
import Footer from '@/components/footer/Footer.vue'
import CircleBtn from '@/components/footer/CircleBtn.vue'

export default {
  name: 'PersonalMeeting',
  components: {
    BackBtn,
    Footer,
    CircleBtn,
  },
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
.page-content {
  padding: 1rem;
  max-width: 1200px;
  margin: 0 auto;
}

.card-title {
  font-family: 'NEXON Lv1 Gothic OTF Bold' !important;
}

.card-content {
  font-family: 'NEXON Lv1 Gothic OTF' !important;
}
</style>