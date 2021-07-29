<template>
  <v-container id="program-items">
    <!-- 분류 키워드 Chips Group -->
    <v-row justify="center">
      <v-col
        cols="12"
        sm="10"
        md="9"
        lg="8"
      >
        <v-sheet
          elevation="10"
          rounded="xl"
        >
          <div class="pa-4">
            <v-chip-group
              active-class="primary--text"
              column
              multiple
            >
              <v-chip
              v-for="tag in tags"
              :key="tag"
              >
                {{ tag }}
              </v-chip>
            </v-chip-group>
          </div>
        </v-sheet>
      </v-col>
    </v-row>

    <!-- 프로그램 리스트 -->
    <v-row>
      <v-col
        v-for="n in 12"
        :key="n"
        cols="12"
        sm="6"
        md="4"
        lg="3"
      >
        <v-item class="d-flex flex-column justify-center mb-2">
          <v-card
            class="mx-auto"
            max-width="350"
            @click="showDetail()"
          >
            <v-img
              class="white--text align-end"
              height="250px"
              src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
            >
              <v-card-title>프로그램 이미지</v-card-title>
            </v-img>

            <v-card-subtitle class="pb-0 text-subtitle-1">
              상처없이 이야기하기 (가족편) 
            </v-card-subtitle>

            <v-card-text class="text--primary">
              <div>by 김싸피 상담사</div>
              <div>7월 26일 ~ 8월 16일</div>
              <div>주 2회 (월, 목) 19:00 ~ 21:00</div>
            </v-card-text>

            <!-- <v-card-actions>
              <v-btn
                color="orange"
                text
              >
                Share
              </v-btn>

              <v-btn
                color="orange"
                text
              >
                Explore
              </v-btn>
            </v-card-actions> -->
          </v-card>
        </v-item>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>

export default {
  name: 'ProgramItems',
  data: () => ({
    tags: [
      '학교',
      '직장',
      '대인 관계',
      '가족',
      '외모',
      '등'
    ]
  }),
  methods: {
    showDetail: function () {
      this.$router.push({ name: 'ProgramDetail' })
    },
  }
}
</script>

<style scoped>
/* #program-items {
  margin-top: 3vw !important;
} */
</style>