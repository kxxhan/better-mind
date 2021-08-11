<template>
<div v-if="streamManager">
	<ov-video :stream-manager="streamManager" :class="{startSpeaking: isSpeaking, stopSpeaking: !isSpeaking}"/>
	<div @click="getSpeakingState"><p>{{ clientData }}</p></div>
</div>
</template>

<script>
import OvVideo from './OvVideo';

export default {
	name: 'UserVideo',

	data: function () {
		return {
			isSpeaking: this.$store.state.isSpeaking
		}
	},

	components: {
		OvVideo,
	},

	props: {
		streamManager: Object,
	},

	computed: {
		clientData () {
			const { clientData } = this.getConnectionData();
            // console.log("UserVideo 단",this.streamManager)
			return clientData;
		},
	},

	methods: {
		getConnectionData () {
			const { connection } = this.streamManager.stream;
			return JSON.parse(connection.data);
		},
		getSpeakingState () {
			console.log(`isSpaking은 지금 ${this.isSpeaking}`)
		}
	},

	// watch: {
  //   isSpeaking: function () {
  //     console.log(`${this.isSpeaking}이 변경되었습니다.`)
  //   }
};
</script>
<style>
  .startSpeaking {
    border-style: solid;
    border-width: 2px;
    border-color: cyan;
    border-radius: 2em;
  }
  .stopSpeaking {
    border-style: solid;
    border-width: 2px;
    border-color: red;
  }
</style>
