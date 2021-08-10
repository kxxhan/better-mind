<template>
  <div>
    <h1>BootomBar Test</h1>
    <div>
      <button v-if="this.publisher.stream.audioActive" @click="publisher.publishAudio(false);">음소거</button>
      <button v-else @click="publisher.publishAudio(true);">음소거 해제</button>
    </div>
    <div>
      <button v-if="this.publisher.stream.videoActive" @click="publisher.publishVideo(false);">비디오 중지</button>
      <button v-else @click="publisher.publishVideo(true);">비디오 시작</button>
    </div>
    <div>
      <!-- Filter -->
      <button @click="onFilter">Filter On / </button>
      <button @click="offFilter">Filter Off</button>
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
    onFilter() {
      this.$emit('onFilter')
    },
    offFilter() {
      this.$emit('offFilter')
    }
  },

  mounted() {
    console.log("Bottom Bar Mounted!!")
  }
};
</script>
