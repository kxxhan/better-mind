<template>
  <div>
    <v-container id="exp-meetings">
      <v-btn 
        @click="moveBack()"
        icon
        x-large
      >
        <v-icon>mdi-arrow-left-thick</v-icon>
      </v-btn>
      
      <h1 class="d-flex justify-center text-h2 font-weight-medium">MY MEETING</h1>
      <v-card flat color="transparent" class="my-10">
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="indigo" text @click="$router.push({ name: 'ExpAddMeeting'})">프로그램 추가</v-btn>
        </v-card-actions>
      </v-card>
      <!-- 프로그램 목록 -->
      <v-item-group>
        <v-row>
          <v-col
            v-for="program in myprogramlist"
            :key="program.id"
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
                    <span v-else></span>
                    {{ program.category }}</v-card-title>
                </v-img>

                <v-card-subtitle class="pb-0 text-subtitle-1">
                  {{ program.name }}
                </v-card-subtitle>

                <v-card-text class="text--primary">
                  <div>미팅주소</div>
                  <div>{{ program.date }} | {{ program.time }}</div>
                  <div>{{ program.userId }}</div>
                </v-card-text>
              </v-card>
            </v-item>
            <!-- 클릭 시 모달폼 -->
            <v-dialog
              v-if="userList"
              v-model="dialog"
              max-width="600"
              :retain-focus="false"
            >
              <v-card>
                <v-card-title class="text-h5">
                  {{ selectprogram.name }}
                </v-card-title>

                <v-card-text>상담 신청자 수 : {{ userList.length }}</v-card-text>
                <v-card-text>상담 활성화 상태 : {{ selectprogram.isactive }}</v-card-text>

                <v-card-actions>
                  <v-btn 
                    v-if="selectprogram.isactive"
                    color="green"
                    text
                    @click="enterConsult()"
                  >
                    상담 입장
                  </v-btn>
                </v-card-actions>
                <v-card-actions>
                  <v-btn 
                    v-if="selectprogram.isactive"
                    color="orange"
                    text
                    @click="isActive(selectprogram)"
                  >
                    화상 상담 OFF
                  </v-btn>
                  <v-btn 
                    v-else
                    color="green"
                    text
                    @click="isActive(selectprogram)"
                  >
                    화상 상담 ON
                  </v-btn>
                </v-card-actions>
                <v-card-actions>
                  <v-spacer></v-spacer>

                  <v-btn 
                    color="indigo"
                    text
                    @click="updateProgram(selectprogram)"
                  >
                    수정
                  </v-btn>

                  <v-btn 
                    color="indigo"
                    text
                    @click="deleteProgram(selectprogram)"
                  >
                    삭제
                  </v-btn>

                  <v-btn
                    color="indigo"
                    text
                    @click="dialog = false"
                  >
                    닫기
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
  </div>
</template>

<script>
import axios from 'axios'
import Footer from '@/components/footer/Footer.vue'
import CircleBtn from '@/components/footer/CircleBtn.vue'

export default {
  name: 'ExpMeetings',
  components: {
    Footer,
    CircleBtn,
  },
  data: function () {
    return {
      dialog: false,
      selectprogram: {},
      userList : []
    }
  },
  methods: {
    openDetail: function (program) {
      this.selectprogram = program
      axios({
        method: 'get',
        url: `/api/v1/program/programlist/${program.id}`
      })
      .then(res => {
        this.userList = res.data.users
        this.dialog = !this.dialog
      })
    },
    // 프로그램 업데이트 링크
    updateProgram: function (selectprogram) {
      this.$store.commit('GET_PROGRAM', selectprogram)
      this.$router.push({ name: 'UpdateProgram', params: { program_pk: selectprogram.id }})
    },
    // 프로그램 삭제
    deleteProgram: function (selectprogram) {
      axios ({
        method: 'delete',
        url: `/api/v1/program/${selectprogram.id}`,
      })
      .then(() => {
        this.$router.go()
        this.dialog = !this.dialog
      })
      .catch((err) => {
        console.log(err)
      })
    },
    // 미팅 활성화
    isActive: function (selectprogram) {
      this.selectprogram.isactive = !this.selectprogram.isactive
      axios ({
        method: 'put',
        url: `/api/v1/program/${selectprogram.id}`,
        data: this.selectprogram
      })
      .then (() => {
        if (this.selectprogram.isactive) {
          alert('미팅룸이 활성화되었습니다.')
        } else {
          alert('미팅룸이 비활성화되었습니다.')
        }
      })
      .catch((err) => {
        console.log(err)
      })
    },
    moveBack: function () {
      this.$router.push({ name: 'Main' })
    },
    //상담 입장
    enterConsult: function () {
      this.$router.push({ name: 'WebRTC', params:{programName: this.selectprogram.name, programId: this.selectprogram.id} })
    }
  },
  computed: {
    myprogramlist: function () {
      const myprogramList = []
      for (const program of this.$store.state.programlist) {
        if (program.userId === this.$store.state.userInfo.userid){
          myprogramList.push(program)
        }
      }
      return myprogramList
    },
  },
  created: function () {
    this.$store.dispatch('getPrograms')
  }
}
</script>

<style scoped>
.backbtn {
  text-decoration-line:line-through;
  background-color: none;
}
#exp-meetings {
  max-width: 1200px;
  margin: 0 auto;
}
</style>