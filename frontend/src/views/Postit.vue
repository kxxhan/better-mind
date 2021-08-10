<template>
  <v-container id="post-it">
    <BackBtn/>
    <!-- 관리자 질문 등록용 -->
    <v-sheet v-if="isAdmin" class="mx-auto my-5" max-width="1000px">
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
    <v-card class="mx-auto" max-width="1000px">
      <div>
        <p class="text-h4 text-center pt-8">{{ this.$store.state.lastQuestion.content }}</p>
      </div>
      
      <div class="d-flex justify-center">
        <v-btn
          icon
          @click="show = true"
        >
          <v-icon>mdi-chevron-down</v-icon>
        </v-btn>
      </div>

      <v-expand-transition>
        <v-card 
          v-if="show" 
          class="transition-fast-in-fast-out v-card--reveal" 
          style="height: 100%;"
        >
          <div>
            <p class="text-h5 text-center pt-8">인생은 고기서 고기다. <span class="text-subtitle-1 font-italic text--disabled">&nbsp;&nbsp;김준현</span></p>
          </div>
          <div class="d-flex justify-center">
            <v-btn
              icon
              @click="show = false"
            >
              <v-icon>mdi-chevron-up</v-icon>
            </v-btn>
          </div>
        </v-card>
      </v-expand-transition>
    </v-card>
    
    <!-- 포스트잇 작성란 -->
    <v-sheet class="mx-auto mt-10" max-width="800px">
      <v-row>
          <v-text-field
            v-model="postContent"
            outlined 
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
      </v-row>
    </v-sheet>
    <PostList :key="renderComponent" @render="deleteRender"/>
    
  </v-container>
</template>

<script>
import axios from 'axios'
import EditBtn from '@/components/postit/EditBtn.vue'
import PostList from '@/components/postit/PostList.vue'
import BackBtn from '@/components/BackBtn.vue'

export default {
  name: 'Postit',
  components: {
    EditBtn,
    PostList,
    BackBtn,
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
      .then(() => {
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
        this.postContent = ''
        this.renderComponent += 1
      })
    },
    deleteRender: function () {
      this.renderComponent += 1
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
.v-card--reveal {
  bottom: 0;
  opacity: 1 !important;
  position: absolute;
  width: 100%;
}
</style>