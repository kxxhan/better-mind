<template>
  <v-container id="exp-meetings">
    <BackBtn/>
    <h1>전문가의 모임 정보</h1>
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
                src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
              >
                <v-card-title>{{ program.category }}</v-card-title>
              </v-img>

              <v-card-subtitle class="pb-0 text-subtitle-1">
                {{ program.name }}
              </v-card-subtitle>

              <v-card-text class="text--primary">
                <div>미팅주소</div>
                <div>미팅시간</div>
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

              <v-card-text>
                참가자목록
              </v-card-text>
              <v-card-text>
                사람선택 체크박스
              </v-card-text>
              <v-card-text>
                메세지나 메일 알람...??
              </v-card-text>

              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn 
                  color="green darken-1"
                  text
                  @click="updateProgram(selectprogram)"
                >
                  Update
                </v-btn>

                <v-btn 
                  color="green darken-1"
                  text
                  @click="deleteProgram(selectprogram)"
                >
                  Delete
                </v-btn>

                <v-btn
                  color="green darken-1"
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
</template>

<script>
import axios from 'axios'
import BackBtn from '@/components/BackBtn.vue'

export default {
  name: 'ExpMeetings',
  data: function () {
    return {
      dialog: false,
      selectprogram: {},
    }
  },
  components: {
    BackBtn,
  },
  methods: {
    openDetail: function (program) {
      this.selectprogram = program
      this.dialog = !this.dialog
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
    }
  },
  computed: {
    myprogramlist: function () {
      const myprogramlist = []
      for (const program of this.$store.state.programlist) {
        if (program.userId === this.$store.state.userInfo.userid){
          myprogramlist.push(program)
        }
      }
      return myprogramlist
    },
  },
  created: function () {
    this.$store.dispatch('getPrograms')
  }
}
</script>

<style>

</style>