<template>
  <div>
    <v-container id="post-it">
      <v-btn 
        @click="moveBack()"
        icon
        x-large
      >
        <v-icon>mdi-arrow-left-thick</v-icon>
      </v-btn>
      <h1 class="d-flex justify-center">Post it</h1>

      <!-- 관리자 질문 등록용 -->
      <v-sheet v-if="isAdmin" class="mx-auto my-5" max-width="1000px" color="transparent">
        <v-row>
          <v-text-field
            v-model="question"
            prepend-icon="mdi-chat-question"
            outlined 
            clearable
            required
          ></v-text-field>
          <v-btn
            text
            x-large
            @click="submit"
          >
            Submit
          </v-btn>

          <EditBtn :key="renderComponent"/>
        </v-row>
      </v-sheet>

      <!-- 오늘의 질문 -->
      <v-card class="mx-auto" max-width="1000px" rounded="lg" color="transparent" outlined>
        <div>
          <p class="text-center pt-8 td-question">{{ this.$store.state.lastQuestion.content }}</p>
        </div>
        
        <div class="d-flex justify-center">
          <v-btn
            icon
            @click="show = true"
            disabled
          >
            <v-icon>mdi-chevron-down</v-icon>
          </v-btn>
        </div>
      </v-card>
    
      <!-- 포스트잇 작성란 -->
      <v-sheet class="mx-auto mt-10" max-width="800px" color="transparent">
        <v-row>
          <v-text-field
            v-model="postContent"
            clearable
            required
          ></v-text-field>
          <v-btn
            text
            x-large
            @click="postSubmit"
          >
            Submit
          </v-btn>

          <EditBtn v-if="isAdmin" :key="renderComponent"/>
        </v-row>
      </v-sheet>
      <PostList :key="renderComponent" @render="deleteRender"/>
    </v-container>
    <Footer/>
    <CircleBtn/>
  </div>
</template>

<script>
import axios from 'axios'
import EditBtn from '@/components/postit/EditBtn.vue'
import PostList from '@/components/postit/PostList.vue'
import Footer from '@/components/footer/Footer.vue'
import CircleBtn from '@/components/footer/CircleBtn.vue'

export default {
  name: 'Postit',
  components: {
    EditBtn,
    PostList,
    Footer,
    CircleBtn,
  },
  data: function () {
    return {
      show: false,
      question: '',
      postContent: '',
      renderComponent: 0,
    }
  },
  methods: {
    submit: function () {
      axios({
        method: 'post',
        url: `/api/v1/postit`,
        data: { content: this.question }
      })
      .then((res) => {
        this.question = ''
        this.renderComponent += 1
      })
      .catch((err) => {
        console.log(err)
      })
    },
    postSubmit: function () {
      axios({
        method: 'post',
        url: `/api/v1/postit/${this.$store.state.lastQuestion.id}`,
        data: { 
          content: this.postContent,
          userId: this.$store.state.userInfo.userid
        }
      })
      .then(() => {
        console.log(this.renderComponent)
        this.postContent = ''
        this.renderComponent += 1
      })
    },
    deleteRender: function () {
      this.renderComponent += 1
    },
    moveBack: function () {
      this.$router.push({ name: 'Main' })
    }
  },
  computed: {
    isAdmin: function () {
      if (this.$store.state.userInfo.role === '2') {
        return true
      }
      else {
        return false
      }
    },
  },
  created: function () {
    // 포스트잇 질문 리스트 및 답변 GET API 요청
    this.$store.dispatch('getQuestions')
    
  }
}
</script>

<style>
@font-face {
    font-family: 'MapoFlowerIsland';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/MapoFlowerIslandA.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
.td-question {
  font-family: 'MapoFlowerIsland';
  font-size: 32px;
}
.backbtn {
  text-decoration-line:line-through;
  background-color: none;
}
#post-it {
  max-width: 1200px;
  margin: 0 auto;
}

</style>