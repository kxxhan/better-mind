<template>
<div v-if="streamManager">
	<ov-video :stream-manager="streamManager" :class="{startSpeaking: hasSpeaker, stopSpeaking: !hasSpeaker}"/>
	<div><p>{{ clientData }}</p></div>
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
	},


	methods: {
    getConnectionData () {
      const { connection } = this.streamManager.stream;
			return JSON.parse(connection.data);
		},
	},

  computed: {
    clientData () {
      const { clientData } = this.getConnectionData();
      return clientData;
    },
    // isSpeaking () {
    //   return this.$store.state.isSpeaking
    // },
    // 이 UV에 있는 사람이 발언중인가?
    hasSpeaker () {
      const { clientData } = this.getConnectionData()
      if (this.$store.state.speakers.includes(clientData)) {
        return true
      } else {
        return false
      }
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
    border-color: transparent;
    border-radius: 2em;
  }
</style>
