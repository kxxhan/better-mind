<template>
  <div>
    <h1>BootomBar Test</h1>
    <div>
      <v-btn outlined color="indigo" v-if="this.publisher.stream.audioActive" @click="publisher.publishAudio(false);">음소거</v-btn>
      <v-btn outlined color="indigo" v-else @click="publisher.publishAudio(true);">음소거 해제</v-btn>
    </div>
    <div>
      <v-btn outlined color="indigo" v-if="this.publisher.stream.videoActive" @click="publisher.publishVideo(false);">비디오 중지</v-btn>
      <v-btn outlined color="indigo" v-else @click="publisher.publishVideo(true);">비디오 시작</v-btn>
    </div>
    <div>
      <!-- Filter -->
      <v-btn outlined color="indigo" @click="onFilter">Filter On / </v-btn>
      <v-btn outlined color="indigo" @click="offFilter">Filter Off</v-btn>
    </div>
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
    }
  },

  mounted () {
    console.log("Bottom Bar Mounted!!")
  }
};
</script>
