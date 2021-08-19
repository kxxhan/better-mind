<template>
  <div>
    <!-- <div class="chatbox">
      <h1>Chat Here</h1>
      <p v-for="chat in chatLog" :key="chat.id">{{ chat[0] }} from {{ chat[1].clientData }}</p> 
    </div>
    <div>
      <form @submit.prevent="chatOccur(msg)" action="#">
        <input type="text" v-model="msg" placeholder="chat here">
        <button type="submit">전송</button>
      </form>
    </div> -->
    <!-- <p v-for="chat in chatLog" :key="chat.id">{{ chat[0] }} from {{ chat[1].clientData }}</p> -->

    <!-- <hr> -->
    <div class="chat">      
      <div class="chat-history">
        <ul>
          <li v-for="chat in chatLog" :key="chat.id" class="clearfix">
            <div class="message-data align-right">
              <span class="message-data-name" >{{ chat[1].clientData }}</span>              
            </div>
            <div 
              class="message other-message float-right"
            >
              {{ chat[0] }}
            </div>
          </li>
        </ul>
      </div>
      
      <div class="chat-message clearfix">
        <form @submit.prevent="chatOccur(msg)" id="chatForm" action="#">
          <textarea 
            name="message-to-send" 
            id="message-to-send" 
            v-model="msg" 
            placeholder ="Type your message" 
            rows="3"
          ></textarea>       
          <button type="submit">전송</button>
        </form>
      </div>
    </div>
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
      this.msg = ''
      console.log('에밋 발새애애애애애앵')
    },
  },
	mounted () {
		console.log("hello! it's UserChat.vue!!")
	},
};
</script>
<style scoped>
@import url(https://fonts.googleapis.com/css?family=Lato:400,700);
*, *:before, *:after {
  box-sizing: border-box;
}
.chat {
  width: 490px;
  float: left;
  background: #F2F5F8;
  border-top-right-radius: 5px;
  border-bottom-right-radius: 5px;
  color: #434651;
}

.chat {
  padding: 20px;
  border-bottom: 2px solid white;
}
.chat {
  float: left;
}
.chat {
  float: left;
  padding-left: 10px;
  margin-top: 6px;
}
.chat {
  font-weight: bold;
  font-size: 16px;
}
.chat {
  color: #92959E;
}
.chat .fa-star {
  float: right;
  color: #D8DADF;
  font-size: 20px;
  margin-top: 12px;
}
.chat .chat-history {
  padding: 30px 30px 20px;
  border-bottom: 2px solid white;
  overflow-y: scroll;
  height: 575px;
}
.chat .chat-history .message-data {
  margin-bottom: 15px;
}
.chat .chat-history .message-data-time {
  color: #a8aab1;
  padding-left: 6px;
}
.chat .chat-history .message {
  color: white;
  padding: 18px 20px;
  line-height: 26px;
  font-size: 16px;
  border-radius: 7px;
  margin-bottom: 30px;
  width: 90%;
  position: relative;
}
.chat .chat-history .message:after {
  bottom: 100%;
  left: 7%;
  border: solid transparent;
  content: " ";
  height: 0;
  width: 0;
  position: absolute;
  pointer-events: none;
  border-bottom-color: #86BB71;
  border-width: 10px;
  margin-left: -10px;
}
.chat .chat-history .my-message {
  background: #86BB71;
}
.chat .chat-history .other-message {
  background: #94C2ED;
}
.chat .chat-history .other-message:after {
  border-bottom-color: #94C2ED;
  left: 93%;
}
.chat .chat-message {
  padding: 30px;
}
.chat .chat-message textarea {
  width: 100%;
  border: none;
  padding: 10px 20px;
  font: 14px/22px "Lato", Arial, sans-serif;
  margin-bottom: 10px;
  border-radius: 5px;
  resize: none;
}
.chat .chat-message .fa-file-o, .chat .chat-message .fa-file-image-o {
  font-size: 16px;
  color: gray;
  cursor: pointer;
}
.chat .chat-message button {
  float: right;
  color: #94C2ED;
  font-size: 16px;
  text-transform: uppercase;
  border: none;
  cursor: pointer;
  font-weight: bold;
  background: #F2F5F8;
}
.chat .chat-message button:hover {
  color: #75b1e8;
}

.clearfix:after {
  visibility: hidden;
  display: block;
  font-size: 0;
  content: " ";
  clear: both;
  height: 0;
}
</style>