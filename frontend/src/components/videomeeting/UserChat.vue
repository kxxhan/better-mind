<template>
  <div style="overflow:auto; width:500px; height:150px;">
    <h1>Chat Here</h1>
    <div>
      <form @submit.prevent="chatOccur(msg)" action="#">
        <input type="text" v-model="msg">
        <button type="submit">전송</button>
      </form>
    </div>
    <p v-for="chat in chatLog" :key="chat[1]">{{ chat[0] }}</p>
  </div>  
</template>

<script>
export default {
	name: 'UserChat',

  data: function () {
    return {

    }
  },

	props: {
    chatLog: Object,
	},

  methods: {
    chatOccur(msg) {
      this.$emit('sendMessage', msg)
      console.log('에밋 발새애애애애애앵')
    }
  },
	mounted () {
		console.log("hello! it's UserChat.vue!!")
	},
};
</script>
