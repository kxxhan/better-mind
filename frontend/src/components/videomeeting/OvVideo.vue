<template>
  <!-- video height width 조정  -->
  <video autoplay height="100%" width="100%"/>
  <!-- video speech detection border test -->
  <!-- <video id="vd" autoplay/> -->
  <!-- <video autoplay/> -->
</template>

<script>
export default {
	name: 'OvVideo',

	props: {
		streamManager: Object,
	},

	mounted () {
		this.streamManager.addVideoElement(this.$el);	
	},
};
</script>
