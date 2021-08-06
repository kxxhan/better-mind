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
          <v-card class="d-flex flex-column justify-space-around" min-height="260px" max-width="260px" min-width="260px">
            <v-card flat class="d-flex justify-space-between align-center" min-height="36px">
              <div>
                <span class="pl-5">{{ answer.userId }}</span>
              </div>
              <div >
                <span class="pr-3">10분 전</span>
                <v-btn v-show="answer.userId == userInfo.userid" icon @click="deleteComment(answer)">
                  <v-icon>mdi-window-close</v-icon>
                </v-btn>
              </div>
            </v-card>
            <v-card flat>
              <p class="text-center">{{ answer.content }}</p>
            </v-card>
            <v-card flat>
              <p></p>
            </v-card>
          </v-card>
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

<style>

</style>