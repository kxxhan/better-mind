<template>
  <!-- video height width 조정  -->
  <video autoplay height="180" width="288" />
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
