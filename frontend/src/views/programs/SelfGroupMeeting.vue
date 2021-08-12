<template>
  <div class="page-layout">
    <v-container>
      <BackBtn/>
      <h1 class="d-flex justify-center">SelfGroup Meeting</h1>

      <header>
        <div class="banner">
          <h2>We help you achieve your goals</h2>
        </div>
      </header>
      <!-- 카드 -->
      <v-row class="mt-5">
        
        <v-col
          class="d-flex justify-center"
          cols="12"
          sm="6"
          md="4"
          lg="3"
        >
          <a href="#" class="card color1">
            
            <div class="overlay"></div>
            <v-icon 
              class="circle"
              x-large
            >
              mdi-account-star
            </v-icon>
            <p class="card-title">취업/진로</p>
          </a>
        </v-col>

        <v-col
          class="d-flex justify-center"
          cols="12"
          sm="6"
          md="4"
          lg="3"
        >
          <a href="#" class="card color2">
            
            <div class="overlay"></div>
            <v-icon 
              class="circle"
              x-large
            >
              mdi-office-building
            </v-icon>
            <p class="card-title">직장</p>
          </a>
        </v-col>

        <v-col
          class="d-flex justify-center"
          cols="12"
          sm="6"
          md="4"
          lg="3"
        >
          <a href="#" class="card color3">
            
            <div class="overlay"></div>
            <v-icon 
              class="circle"
              x-large
            >
              mdi-account-heart
            </v-icon>
            <p class="card-title">연애</p>
          </a>
        </v-col>

        <v-col
          class="d-flex justify-center"
          cols="12"
          sm="6"
          md="4"
          lg="3"
        >
          <a href="#" class="card color4">
            
            <div class="overlay"></div>
            <v-icon 
              class="circle"
              x-large
            >
              mdi-account-group
            </v-icon>
            <p class="card-title">대인관계</p>
          </a>
        </v-col>

        <v-col
          class="d-flex justify-center"
          cols="12"
          sm="6"
          md="4"
          lg="3"
        >
          <a href="#" class="card color5">
            
            <div class="overlay"></div>
            <v-icon 
              class="circle"
              x-large
            >
              mdi-face-woman-shimmer
            </v-icon>
            <p class="card-title">외모</p>
          </a>
        </v-col>

        <v-col
          class="d-flex justify-center"
          cols="12"
          sm="6"
          md="4"
          lg="3"
        >
          <a href="#" class="card color6">
            
            <div class="overlay"></div>
            <v-icon 
              class="circle"
              x-large
            >
              mdi-home-heart
            </v-icon>
            <p class="card-title">가족</p>
          </a>
        </v-col>

        <v-col
          class="d-flex justify-center"
          cols="12"
          sm="6"
          md="4"
          lg="3"
        >
          <a href="#" class="card color7">
            
            <div class="overlay"></div>
            <v-icon 
              class="circle"
              x-large
            >
              mdi-book-open-variant
            </v-icon>
            <p class="card-title">학업</p>
          </a>
        </v-col>

        <v-col
          class="d-flex justify-center"
          cols="12"
          sm="6"
          md="4"
          lg="3"
        >
          <a href="#" class="card color8">
            
            <div class="overlay"></div>
            <v-icon 
              class="circle"
              x-large
            >
              mdi-currency-usd
            </v-icon>
            <p class="card-title">금전</p>
          </a>
        </v-col>

        <v-col
          class="d-flex justify-center"
          cols="12"
          sm="6"
          md="4"
          lg="3"
        >
          <a href="#" class="card color9">
            
            <div class="overlay"></div>
            <v-icon 
              class="circle"
              x-large
            >
              mdi-baby-face-outline
            </v-icon>
            <p class="card-title">육아</p>
          </a>
        </v-col>

        <v-col
          class="d-flex justify-center"
          cols="12"
          sm="6"
          md="4"
          lg="3"
        >
          <a href="#" class="card color10">
            
            <div class="overlay"></div>
            <v-icon 
              class="circle"
              x-large
            >
              mdi-head-sync-outline
            </v-icon>
            <p class="card-title">성격</p>
          </a>
        </v-col>

        <v-col
          class="d-flex justify-center"
          cols="12"
          sm="6"
          md="4"
          lg="3"
        >
          <a href="#" class="card color11">
            
            <div class="overlay"></div>
            <v-icon 
              class="circle"
              x-large
            >
              mdi-hospital-box-outline
            </v-icon>
            <p class="card-title">건강</p>
          </a>
        </v-col>

        <v-col
          class="d-flex justify-center"
          cols="12"
          sm="6"
          md="4"
          lg="3"
        >
          <a href="#" class="card color12">
            
            <div class="overlay"></div>
            <v-icon 
              class="circle"
              x-large
            >
              mdi-emoticon-dead-outline
            </v-icon>
            <p class="card-title">중독</p>
          </a>
        </v-col>

        <v-col
          class="d-flex justify-center"
          cols="12"
          sm="6"
          md="4"
          lg="3"
        >
          <a href="#" class="card color13">
            
            <div class="overlay"></div>
            <v-icon 
              class="circle"
              x-large
            >
              mdi-emoticon-cry-outline
            </v-icon>
            <p class="card-title">성추행</p>
          </a>
        </v-col>

        <v-col
          class="d-flex justify-center"
          cols="12"
          sm="6"
          md="4"
          lg="3"
        >
          <a href="#" class="card color14">
            
            <div class="overlay"></div>
            <v-icon 
              class="circle"
              x-large
            >
              mdi-heart-broken
            </v-icon>
            <p class="card-title">이별/이혼</p>
          </a>
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
import BackBtn from '@/components/BackBtn.vue'

export default {
  name: 'SelfGroupMeeting',
  components: {
    Footer,
    CircleBtn,
    BackBtn,
  },
  data: () => ({
    category: [
      '취업/진로', '직장', '연애', 
      '성추행', '대인관계', '외모', 
      '가족', '학업', '금전', '이별/이혼', 
      '육아', '중독', '건강', '성격'
    ],
  }),
}
</script>

<style scoped>
@import '../css/SelfGroupMeeting.css';

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
</style>