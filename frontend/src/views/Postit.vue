<template>
  <v-container id="post-it">
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
      </v-row>
    </v-sheet>

    <!-- 오늘의 질문 -->
    <v-card class="mx-auto" max-width="1000px">
      <div>
        <p class="text-h4 text-center pt-8">지금 가장 먹고싶은 음식은 무엇인가요?</p>
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
            v-model="question"
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
      </v-row>
    </v-sheet>

    <v-item-group>
      <v-container>
        <v-row>
          <v-col
            v-for="n in 12"
            :key="n"
            cols="12"
            sm="6"
            md="4"
            lg="3"
          >
            <v-card class="d-flex flex-column justify-space-around" min-height="260px" max-width="260px" min-width="260px">
              <v-card flat class="d-flex justify-space-between">
                <p class="pl-5">oh</p>
                <p class="pr-3">10분전</p>
              </v-card>
              <v-card flat>
                <p class="text-center">고기</p>
              </v-card>
              <v-card flat>
                <p></p>
              </v-card>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-item-group>
  </v-container>
</template>

<script>
export default {
  name: 'Postit',
  data: function () {
    return {
      show: false,
      question: '',
    }
  },
  methods: {
    submit: function () {
      console.log(this.question)
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
    }
  },
  created: function () {
    // 포스트잇 리스트 GET API 요청
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