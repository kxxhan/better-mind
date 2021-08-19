<template>
  <div>
    <!-- <h1>BootomBar Test</h1> -->
    <span>
      <v-btn class="mx-1 mt-3" outlined color="indigo" v-if="this.publisher.stream.audioActive" @click="publisher.publishAudio(false);">음소거</v-btn>
      <v-btn class="mx-1 mt-3" outlined color="indigo" v-else @click="publisher.publishAudio(true);">음소거 해제</v-btn>
    </span>
    <span>
      <v-btn class="mx-1 mt-3" outlined color="indigo" v-if="this.publisher.stream.videoActive" @click="publisher.publishVideo(false);">비디오 중지</v-btn>
      <v-btn class="mx-1 mt-3" outlined color="indigo" v-else @click="publisher.publishVideo(true);">비디오 시작</v-btn>
    </span>
    <span>
      <!-- Filter -->
      <v-btn class="mx-1 mt-3" outlined color="indigo" @click="onFilter">Filter On</v-btn>
      <v-btn class="mx-1 mt-3" outlined color="indigo" @click="offFilter">Filter Off</v-btn>
    </span>
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
