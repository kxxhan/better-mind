<template>
  <v-container id="exp-meetings">
    전문가의 모임 정보
    여러개 있을 수 있고
    각 프로그램은 모달로 등장
    <!-- 프로그램 목록 -->
    <v-item-group>
      <v-row>
        <v-col
          v-for="n in 6"
          :key="n"
          cols="12"
          sm="6"
          md="4"
        >
          <v-item class="d-flex flex-column justify-center mb-2">
            <v-card
              class="mx-auto"
              max-width="350"
              @click="openDetail()"
            >
              <v-img
                class="white--text align-end"
                height="250px"
                src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
              >
                <v-card-title>프로그램 이미지</v-card-title>
              </v-img>

              <v-card-subtitle class="pb-0 text-subtitle-1">
                프로그램 이름
              </v-card-subtitle>

              <v-card-text class="text--primary">
                <div>미팅주소</div>
                <div>미팅시간</div>
              </v-card-text>
            </v-card>
          </v-item>
        </v-col>
        <!-- 클릭 시 모달폼 -->
        <v-dialog
          v-model="dialog"
          max-width="600"
        >
          <v-card>
            <v-card-title class="text-h5">
              프로그램 이름
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
              <v-btn @click="updateProgram()">
                프로그램 수정
              </v-btn>

              <v-btn @click="deleteProgram()">
                프로그램 삭제
              </v-btn>

              <v-btn
                color="green darken-1"
                text
                @click="dialog = false"
              >
                Disagree
              </v-btn>

              <v-btn
                color="green darken-1"
                text
                @click="dialog = false"
              >
                Agree
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-row>
    </v-item-group>
  </v-container>
</template>

<script>
export default {
  name: 'ExpMeetings',
  data: function () {
    return {
      dialog: false,
    }
  },
  methods: {
    openDetail: function () {
      this.dialog = !this.dialog
    },
    updateProgram: function () {
      this.$router.push({ name: 'UpdateProgram'})
    },
    deleteProgram: function () {
      axios ({
        method: 'delete',
        url: `api/v1/program/${program.id}`
      })
      .then(() => {
        this.$router.push({ name: 'ExpMeetings' })
      })
      .catch((err) => {
        console.log(err)
      })
    }
  },
}
</script>

<style>

</style>