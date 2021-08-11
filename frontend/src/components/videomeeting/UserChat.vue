<template>
  <div style="overflow:auto; width:500px; height:150px;">
    <h1>Chat Here</h1>
    <div>
      <form @submit.prevent="chatOccur(msg)" action="#">
        <input type="text" v-model="msg" placeholder="chat here">
        <button type="submit">전송</button>
      </form>
    </div>
    <p v-for="chat in chatLog" :key="chat.id">{{ chat[0] }} from {{ chat[1].clientData }}</p>
  </div>  
</template>

<script>
export default {
	name: 'UserChat',

  data: function () {
    return {
      msg: ''
    }
  },

	props: {
    chatLog: Array,
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
