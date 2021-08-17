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

      <h1 class="d-flex justify-center">SelfGroup Meeting</h1>

      <header>
        <div class="banner">
          <h2>We help you achieve your goals</h2>
        </div>
      </header>
      <!-- 카드 -->
      <v-row>
        <!-- 모달폼 -->
        <v-col
          v-for="(item, i) in items"
          :key="i"
          class="d-flex justify-center mt-5"
          cols="12"
          sm="6"
          md="4"
          lg="3"
        >
          <v-dialog
            transition="dialog-bottom-transition"
            max-width="600"
          >
            <!-- 카드 -->
            <template v-slot:activator="{ on, attrs }">
              <a 
                :class="item.class"
                v-bind="attrs"
                v-on="on"
                @click="selectPrograms(item.name)"
              >            
                <div class="overlay"></div>
                <v-icon 
                  class="circle"
                  x-large
                >
                  {{ item.icon }}
                </v-icon>
                <p class="card-title">{{ item.name }}</p>
              </a>
            </template>
            <!-- 폼 -->
            <template v-slot:default="dialog">
              <v-card 
                class="modal-font"
              >
                <v-toolbar
                  color="#D1C4E9"
                  class="text-h5"
                  dark
                >자조모임 신청하기</v-toolbar>
                <v-col
                  v-for= "program in selectprograms"
                  :key="program.id"
                >
                  <v-card-text>
                    <v-icon>mdi-palette-outline</v-icon>
                    <span class="text-h6 m-2">{{ program.time }}</span>
                    <v-btn 
                      outlined 
                      color="#D1C4E9" 
                      class="ms-2"
                      @click="applyProgram(program)"
                    >                    
                      Apply
                    </v-btn>
                    <br>
                  </v-card-text>
                </v-col>
                <v-card-actions class="justify-end">
                  <v-btn
                    text
                    @click="dialog.value = false"
                  >Close</v-btn>
                </v-card-actions>
              </v-card>
            </template>
          </v-dialog>
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
import axios from 'axios'

export default {
  name: 'SelfGroupMeeting',
  components: {
    Footer,
    CircleBtn,
  },
  data: () => ({
    selectcategories: [],
    selectprograms: [],
    items: [
      {
        name: '취업진로',
        class: 'card color1',
        icon: 'mdi-account-star'
      },
      {
        name: '직장',
        class: 'card color2',
        icon: 'mdi-office-building'
      },
      {
        name: '연애',
        class: 'card color3',
        icon: 'mdi-account-heart'
      },
      {
        name: '대인관계',
        class: 'card color4',
        icon: 'mdi-account-group'
      },
      {
        name: '외모',
        class: 'card color5',
        icon: 'mdi-face-woman-shimmer'
      },
      {
        name: '가족',
        class: 'card color6',
        icon: 'mdi-home-heart'
      },
      {
        name: '학업',
        class: 'card color7',
        icon: 'mdi-book-open-variant'
      },
      {
        name: '금전',
        class: 'card color8',
        icon: 'mdi-currency-usd'
      },
      {
        name: '육아',
        class: 'card color9',
        icon: 'mdi-baby-face-outline'
      },
      {
        name: '성격',
        class: 'card color10',
        icon: 'mdi-head-sync-outline'
      },
      {
        name: '건강',
        class: 'card color11',
        icon: 'mdi-hospital-box-outline'
      },
      {
        name: '중독',
        class: 'card color12',
        icon: 'mdi-emoticon-dead-outline'
      },
      {
        name: '성추행',
        class: 'card color13',
        icon: 'mdi-emoticon-cry-outline'
      },
      {
        name: '이별이혼',
        class: 'card color14',
        icon: 'mdi-heart-broken'
      },
    ]
  }),
  methods: {
    // 선택한 카테고리에 해당하는 프로그램만 렌더링
    selectPrograms: function (category) {
      this.selectprograms = []
      for (const program of this.$store.state.programlist) {
        if (program.type === '2' && program.category === category){
          this.selectprograms.push(program)
        }
      }
    },
    moveBack: function () {
      this.$router.push({ name: 'Main' })
    },
    // 프로그램 신청
    applyProgram: function(program) {
      const applyInfo = {
          program_id: program.id,
          user_id: this.$store.state.userInfo.id
        }
        console.log(applyInfo)
        axios ({
          method: 'post',
          url: '/api/v1/userprogram',
          data: applyInfo
        })
        .then(() => {
          console.log('신청성공')
          this.$router.push({ name: 'SelfGroupMeeting' })
          alert('프로그램이 신청되었습니다.')
        })
    }
  },
  computed: {
    programlist: function () {
      return this.$store.state.programlist
    }
  },
  created: function () {
    this.$store.dispatch('getPrograms')
  }
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
.backbtn {
  text-decoration-line:line-through;
  background-color: none;
}
</style>