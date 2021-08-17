<template>
  <div>
    <v-container id="pub-meetings">
      <v-btn 
        @click="moveBack()"
        icon
        x-large
      >
        <v-icon>mdi-arrow-left-thick</v-icon>
      </v-btn>
      <v-container id="pub-meetings">
        <v-item-group>
          <v-row>
            <v-col
              v-for="(program, n) in programlist"
              :key="n"
              cols="12"
              sm="6"
              md="4"
            >
              <v-item class="d-flex flex-column justify-center mb-2">
                <v-card
                  class="mx-auto"
                  max-width="350"
                  @click="openDetail(program)"
                >
                  <v-img
                    class="white--text align-end"
                    height="250px"
                    src="https://images.unsplash.com/photo-1542338347-4fff3276af78?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NXx8Y291bnNlbGluZ3xlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
                  >
                    <v-card-title>
                      <span v-if="program.type === '0'">개인 상담 - </span>
                      <span v-else-if="program.type === '1'">그룹 상담 - </span>
                      <span v-else>자조 모임 - </span>
                      {{ program.category }}
                    </v-card-title>
                  </v-img>

                  <v-card-subtitle 
                    v-if="program.type === '2'"
                    class="pb-0 text-subtitle-1"
                  >
                    {{ program.category }}
                  </v-card-subtitle>
                  <v-card-subtitle 
                    v-else
                    class="pb-0 text-subtitle-1"
                  >
                    {{ program.name }}
                  </v-card-subtitle>

                  <v-card-text class="text--primary">
                    <div>미팅주소</div>
                    <div v-if="program.type === '2'">{{ program.time }}</div>
                    <div v-else>{{ program.date }} | {{ program.time }}</div>
                    <div>{{ program.userId }}</div>
                  </v-card-text>
                </v-card>
              </v-item>
              <!-- 클릭 시 모달폼 -->
              <v-dialog
                v-model="dialog"
                max-width="600"
              >
                <v-card>
                  <v-card-title class="text-h5">
                    {{ selectprogram.name }}
                  </v-card-title>

                  <!-- 후기작성 폼 -->
                  <v-row 
                    class="mt-5 px-5 d-flex align-center"
                  >
                    <v-textarea
                      auto-grow
                      prepend-inner-icon="mdi-comment"
                      class="mx-2"
                      label="review"
                      rows="1"
                      cols="10"
                      v-model="reviewContent"
                    ></v-textarea>
                    <v-btn 
                      text
                      cols="1"
                      @click="createReview(selectprogram)"
                    >
                      SUBMIT
                    </v-btn>
                  </v-row>
                  <br>
                  <v-card-text>상담 활성화 상태 : </v-card-text>

                  <v-card-actions>
                    <v-btn 
                      color="green"
                      text
                    >
                      화상 상담 ON
                    </v-btn>
                    <v-btn 
                      color="orange"
                      text
                    >
                      화상 상담 OFF (조건부 렌더링)
                    </v-btn>
                  </v-card-actions>
                  <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn
                      color="indigo"
                      text
                      @click="dialog = false"
                    >
                      Close
                    </v-btn>
                  </v-card-actions>
                </v-card>
              </v-dialog>
            </v-col>
          </v-row>
        </v-item-group>
      </v-container>
      <CircleBtn/>
      <Footer/>
    </v-container>
  </div>
</template>

<script>
import axios from 'axios'
import Footer from '@/components/footer/Footer.vue'
import CircleBtn from '@/components/footer/CircleBtn.vue'

export default {
  name: 'PubMeetings',
  components: {
    Footer,
    CircleBtn,
  },
  data: function () {
    return {
      dialog: false,
      selectprogram: {},
      reviewContent: ''
    }
  },
  methods: {
    openDetail: function (program) {
      this.selectprogram = program
      this.dialog = !this.dialog
    },
    // 후기 등록
    createReview: function () {
      if (this.reviewContent.length > 0) {
        const reviewItem = { 
          content: this.reviewContent, 
          userId: this.$store.state.userInfo.userid 
        }
        axios({
          method: 'post',
          url: `/api/v1/program/${this.selectprogram.id}`,
          data: reviewItem
        })
        .then(res => {
          if (res.data.statusCode === 200) {
            this.reviewContent = ''
          }
        })
      }
    },
    moveBack: function () {
      this.$router.push({ name: 'Main' })
    }
  },
  computed: {
    programlist: function () {
      return this.$store.state.myprogramlist
    }
  },
  created: function () {
    this.$store.dispatch('getMyPrograms')
  }
}
</script>

<style scoped>
.backbtn {
  text-decoration-line:line-through;
  background-color: none;
}
#pub-meetings {

  max-width: 1200px;
  margin: 0 auto;
}
</style>