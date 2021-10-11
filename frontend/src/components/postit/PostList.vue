<template>
  <v-item-group>
    <v-container>
      <v-row>
        <v-col
          v-for="answer in answers"
          :key="answer.id"
          cols="12"
          sm="6"
          md="4"
          lg="3"
        >
          <div class="postit">
            <v-card class="d-flex flex-column justify-space-between" min-height="235px" max-width="235px" min-width="235px" color="transparent" outlined>
              <v-card flat class="d-flex justify-space-between align-center" min-height="36px" color="transparent">
                <div class="pt-1">
                  <span class="pl-5">{{ answer.userId }}</span>
                </div>
                <div class="pt-3">
                  <!-- <span class="pr-3">10분 전</span> -->
                  <v-btn v-show="answer.userId == userInfo.userid" icon @click="deleteComment(answer)">
                    <v-icon>mdi-window-close</v-icon>
                  </v-btn>
                </div>
              </v-card>
              <v-card flat color="transparent">
                <p class="text-center">{{ answer.content }}</p>
              </v-card>
              <v-card flat color="transparent">
                <p></p>
              </v-card>
            </v-card>
          </div>          
        </v-col>
      </v-row>
    </v-container>
  </v-item-group>
</template>

<script>
import axios from 'axios'

export default {
  name: 'PostList',
  methods: {
    deleteComment: function (answer) {
      axios({
        method: 'delete',
        url: `/api/v1/postit/${this.$store.state.lastQuestion.id}/${answer.id}`
      })
      .then(() => {
        this.$emit('render')
      })
    }
  },
  computed: {
    answers: function () {
      return this.$store.state.answers
    },
    userInfo: function () {
      return this.$store.state.userInfo
    }
  },
}
</script>

<style scoped>
@import '../css/PostList.css';
</style>