<template>
<div v-if="streamManager">
	<ov-video :stream-manager="streamManager" class="startSpeaking"/>
	<div @click="getSpeakingState"><p>{{ clientData }}</p></div>
</div>
</template>

<script>
import OvVideo from './OvVideo';

export default {
	name: 'UserVideo',

	components: {
		OvVideo,
	},

	props: {
		streamManager: Object,
		speaking: Boolean
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
			console.log(this.speaking)
		}
	},
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
