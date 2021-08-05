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
                v-for="item in category"
                :key="item"
                @click="selectCategory(item)"
              >
                {{ item }}
              </v-chip>
            </v-chip-group>
          </div>
        </v-sheet>
      </v-col>
    </v-row>

    <!-- 프로그램 리스트 -->
    <v-item-group>
      <v-row v-if="selectcategories.length">
        <!-- 카테고리 미 선택 시 전체 프로그램 렌더링 -->
        <v-col
          v-for="program in selectprograms"
          :key="program.id"
          cols="12"
          sm="6"
          md="4"
          lg="3"
        >
          <v-item class="d-flex flex-column justify-center mb-2">
            <v-card
              class="mx-auto"
              max-width="350"
              @click="showDetail(program)"
            >
              <v-img
                class="white--text align-end"
                height="250px"
                src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
              >
                <v-card-title>프로그램 이미지</v-card-title>
              </v-img>

              <v-card-subtitle class="pb-0 text-subtitle-1">
                {{ program.name }} 
              </v-card-subtitle>

              <v-card-text class="text--primary">
                <div>전문가: {{ program.userId }}</div>
                <div>제한인원: {{ program.count }}명</div>
                <div>{{ program.time }}</div>
              </v-card-text>
            </v-card>
          </v-item>
        </v-col>
      </v-row>
      <v-row v-else>  
        <!-- 선택 카테고리에 대한 프로그램 렌더링 -->
        <v-col
          v-for="program in programlist"
          :key="program.id"
          cols="12"
          sm="6"
          md="4"
          lg="3"
        >
          <v-item class="d-flex flex-column justify-center mb-2">
            <v-card
              class="mx-auto"
              max-width="350"
              @click="showDetail(program)"
            >
              <v-img
                class="white--text align-end"
                height="250px"
                src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
              >
                <v-card-title>프로그램 이미지</v-card-title>
              </v-img>

              <v-card-subtitle class="pb-0 text-subtitle-1">
                {{ program.name }} 
              </v-card-subtitle>

              <v-card-text class="text--primary">
                <div>전문가: {{ program.userId }}</div>
                <div>제한인원: {{ program.count }}명</div>
                <div>{{ program.time }}</div>
              </v-card-text>
            </v-card>
          </v-item>
        </v-col>
      </v-row>
    </v-item-group>
  </v-container>
</template>

<script>

export default {
  name: 'ProgramItems',
  data: () => ({
    category: ['우울', '불안', '성격문제', '애착', 
          '대인기피', '분노조절', '자존감', 
          '중독', '대인관계', '부부', '가족상담',
        ],
    selectcategories: [],
    selectprograms: []
  }),
  methods: {
    showDetail: function (program) {     
      this.$router.push({ name: 'ProgramDetail', params: { program_pk: program.id }})
    },
    // 선택한 카테고리에 해당하는 프로그램만 렌더링
    selectCategory: function (item) {
      this.selectprograms = []
      if (this.selectcategories.includes(item)){
        const idx = this.selectcategories.indexOf(item)
        this.selectcategories.splice(idx, 1)
      } else {
        this.selectcategories.push(item)
      }      
      for (const category of this.selectcategories) {
        for (const program of this.$store.state.programlist) {
            if (program.category === category){
            this.selectprograms.push(program)
          }
        }
      }
    },
  },
  computed: {
    programlist: function () {
      return this.$store.state.programlist
    }
  },
  created: function () {
    this.$store.dispatch('getPrograms')
  }
}
</script>

<style scoped>
/* #program-items {
  margin-top: 3vw !important;
} */
</style>