<template>
  <div id="main">
    <div class="d-none d-lg-flex" style="position: absolute; top: 150px; left: 0px">
      <img src="../assets/tree_0.png" width="400px">
    </div>
    <div class="d-none d-lg-flex" style="position: absolute; top: 350px; right: 0px">
      <img src="../assets/tree_1.png" width="400px">
    </div>
    <Header/>
    <div class="page-layout">
      <v-container class="body">
        <v-row>
          <v-col>
            <button class="main-button noselect" @click="movePersonalMeeting()">
              <v-icon x-large>mdi-human-greeting</v-icon>
              <p>One-To-One</p> 
            </button>
          </v-col>
          <v-col>
            <button class="main-button noselect" @click="moveProgramItems()">
              <v-icon x-large>mdi-account-group-outline</v-icon>
              <p>Group</p>               
            </button>
          </v-col>
          <v-col>
            <button class="main-button noselect" @click="moveSelfGroupMeeting()">
              <v-icon x-large>mdi-account-multiple-plus</v-icon>
              <p>Self</p>  
            </button>
          </v-col>
          <v-col>
            <button class="main-button noselect" @click="movePostItems()">
              <v-icon x-large>mdi-tooltip-text-outline</v-icon>
              <p>Community</p>              
            </button>
          </v-col>
          <v-col>
            <button class="main-button noselect" @click="movePostit()">
              <v-icon x-large>mdi-sticker-emoji</v-icon>
              <p>Post-It</p>
            </button>
          </v-col>
          <v-col>
            <button class="main-button noselect" @click="moveMeetings()">
              <v-icon x-large>mdi-heart-plus-outline</v-icon>
              <p>Mine</p>               
            </button>
          </v-col>
        </v-row>
      </v-container>
    </div>
    <Footer/>
    <CircleBtn/>
  </div>
</template>

<script>
import Footer from '@/components/footer/Footer.vue'
import CircleBtn from '@/components/footer/CircleBtn.vue'
import Header from '@/components/header/Header.vue'

export default {  
  components: {
    Footer,
    CircleBtn,
    Header
  },
  methods: {
    movePersonalMeeting: function () {
        this.$router.push({ name: 'PersonalMeeting' })
      },
    moveProgramItems: function () {
        this.$router.push({ name: 'ProgramItems' })
      },
    moveSelfGroupMeeting: function () {
        this.$router.push({ name: 'SelfGroupMeeting' })
      },
    movePostItems: function () {
        this.$router.push({ name: 'PostItems' })
      },
    movePostit: function () {
        this.$router.push({ name: 'Postit' })
      },
    moveMeetings: function () {
      if (this.$store.state.userInfo.role === '0') {
        this.$router.push({ name: 'PubMeetings' })
      } else {
        this.$router.push({ name: 'ExpMeetings' })
      }
    }
  }
}
</script>

<style scoped>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}
.page-layout {
  padding: 1rem;
  max-width: 1200px;
  margin: 0 auto;
}
.body {
	height: 70vh;
	overflow: hidden;
	display: flex;
  justify-content: center;
	align-items: center;
	justify-content: center;
}
.noselect {
  -webkit-touch-callout: none;
  -webkit-user-select: none;
  -khtml-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
	-webkit-tap-highlight-color: transparent;
}
.main-button {
	width: 150px;
	height: 150px;
	cursor: pointer;
	border: none;
	color: rgba(55, 54, 55);
	font-size: 20px;
	border-radius: 4px;
	box-shadow: inset 0px 3px 5px rgba(255,255,255,0.5), 0px 0px 10px rgba(0,0,0,0.15);
	background: rgb(2,0,36);
  background: linear-gradient(45deg, rgba(2,0,36,0) 5%, rgba(255,255,255,.5) 6%, rgba(255,255,255,0) 9%, rgba(255,255,255,.5) 10%, rgba(255,255,255,0) 17%, rgba(255,255,255,.5) 19%, rgba(255,255,255,0) 21%);
	background-size: 150%;
	background-position: right;
	transition: 1s;
}
.main-button:hover {
	background-position: left;
	color: rgb(238, 177, 219);
	box-shadow: inset 0px 3px 5px rgba(255,255,255,1), 0px 0px 10px rgba(0,0,0,0.25);
}
.main-button:focus {
	outline: none;
}
</style>