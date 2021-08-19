<template>
  <div>
    <v-container id="btm-bar">
      <!-- <v-row>
        <v-col>
          <v-btn class="mx-1 mt-3" outlined color="indigo" @click="leaveSession">세션나가기</v-btn>
        </v-col>
        <v-col>
          <v-btn class="mx-1 mt-3" outlined color="indigo" v-if="this.publisher.stream.audioActive" @click="publisher.publishAudio(false);">음소거</v-btn>
          <v-btn class="mx-1 mt-3" outlined color="indigo" v-else @click="publisher.publishAudio(true);">음소거 해제</v-btn>
        </v-col>
        <v-col>
          <v-btn class="mx-1 mt-3" outlined color="indigo" v-if="this.publisher.stream.videoActive" @click="publisher.publishVideo(false);">비디오 중지</v-btn>
          <v-btn class="mx-1 mt-3" outlined color="indigo" v-else @click="publisher.publishVideo(true);">비디오 시작</v-btn>
        </v-col>
        <v-col>
          <v-btn class="mx-1 mt-3" outlined color="indigo" @click="onFilter">Filter On</v-btn>
        </v-col>
        <v-col>
          <v-btn class="mx-1 mt-3" outlined color="indigo" @click="offFilter">Filter Off</v-btn>
        </v-col>
      </v-row> -->
      <span>
        <v-icon>fa-microphone-alt</v-icon>
        <v-btn class="mx-1 mt-3"  color="primary" v-if="this.publisher.stream.audioActive" @click="publisher.publishAudio(false);">Mute</v-btn>
        <v-btn class="mx-1 mt-3"  color="primary" v-else @click="publisher.publishAudio(true);">Unmute</v-btn>
      </span>
      <span>
        <v-btn class="mx-1 mt-3"  color="primary" v-if="this.publisher.stream.videoActive" @click="publisher.publishVideo(false);">Video off</v-btn>
        <v-btn class="mx-1 mt-3"  color="primary" v-else @click="publisher.publishVideo(true);">Video on</v-btn>
      </span>
      <span>  
        <v-btn class="mx-1 mt-3"  color="primary" @click="onFilter">Filter On</v-btn>
        <v-btn class="mx-1 mt-3"  color="primary" @click="offFilter">Filter Off</v-btn>
      </span>
      <span>
        <v-btn class="mx-1 mt-3"  color="error"  @click="leaveSession">Exit</v-btn>
      </span>
    </v-container>
  </div>
</template>

<script>
export default {
	name: 'BottomBar',

  props: {
    publisher: Object
  },

  methods: {
    onFilter () {
      this.$emit('onFilter')
    },
    offFilter () {
      this.$emit('offFilter')
    },
    leaveSession () {
      this.$emit('leaveSession')
    }
  },

  mounted () {
    console.log("Bottom Bar Mounted!!")
  }
};
</script>
<style>
/* #btm-bar {
  display: flex;
  justify-content: center;
	align-items: center;
	justify-content: center;
} */
</style>
