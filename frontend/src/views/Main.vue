<template>
  <div id="main">
    <div>
      <v-container class="body">
        <v-row>
          <v-col>
            <button class="noselect" @click="movePersonalMeeting()">One-To-One</button>
          </v-col>
          <v-col>
            <button class="noselect" @click="moveProgramItems()">Group</button>
          </v-col>
          <v-col>
            <button class="noselect" @click="moveSelfGroupMeeting()">Self</button>
          </v-col>
          <v-col>
            <button class="noselect" @click="movePostItems()">Community</button>
          </v-col>
          <v-col>
            <button class="noselect" @click="movePostit()">Post-It</button>
          </v-col>
          <v-col>
            <button class="noselect" @click="movePubMeetings()">Mine</button>
          </v-col>
        </v-row>
      </v-container>
      <!-- <v-img
        class="white--text align-end mt-2"
        height="400px"
        src="https://cdn.vuetifyjs.com/images/parallax/material.jpg"
      >
        <v-card-title>환영인사</v-card-title>
      </v-img>
    </div>
    <div>
      <v-img
        class="white--text align-end mt-2"
        height="500px"
        src="https://cdn.vuetifyjs.com/images/parallax/material.jpg"
      >
        <v-card-title>그룹테라피 - 전문가모임, 자조모임 소개 글</v-card-title>
      </v-img>
    </div>
    <div>
      <v-img
        class="white--text align-end mt-2"
        height="250px"
        src="https://cdn.vuetifyjs.com/images/parallax/material.jpg"
      >
        <v-card-title>커뮤니티</v-card-title>
      </v-img> -->
    </div>
  </div>
</template>

<script>
export default {
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
    movePubMeetings: function () {
        this.$router.push({ name: 'PubMeetings' })
      },
  }
}
</script>

<style scoped>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

.body {
	height: 100vh;
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

button {
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

button:hover {
	background-position: left;
	color: rgb(238, 177, 219);
	box-shadow: inset 0px 3px 5px rgba(255,255,255,1), 0px 0px 10px rgba(0,0,0,0.25);
}

button:focus {
	outline: none;
}
</style>