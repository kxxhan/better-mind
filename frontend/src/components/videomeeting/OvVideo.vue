<template>
  <!-- video height width 조정  -->
  <!-- <video autoplay height="180" width="288"/> -->
  <!-- video speech detection border test -->
  <video autoplay/>
  <!-- <video autoplay/> -->
</template>

<script>
export default {
	name: 'OvVideo',

	props: {
		streamManager: Object,
	},

  methods: {
    detectSpeech () {
      console.log('OvVideo mounted 여기까지는 되는듯')
    }
  },

	mounted () {
		this.streamManager.addVideoElement(this.$el);
    this.detectSpeech()		
	},
};
</script>
