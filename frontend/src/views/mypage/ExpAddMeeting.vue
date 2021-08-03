<template>
  <v-container id="exp-add-meeting">
    전문가 프로그램 등록 페이지 | 
    프로그램명, 전문가소개 => user정보에서 가져오기, 프로그램소개, 카테고리설정, 기간, 시간, 진행차시, 비용
    <v-form
      ref="form"
      v-model="valid"
      lazy-validation
    >
      <v-text-field
        v-model="program.title"
        :counter="10"
        :rules="titleRules"
        label="Title"
        required
      ></v-text-field>

      <v-text-field
        v-model="program.content"
        :rules="contentRules"
        label="Content"
        required
      ></v-text-field>

      <!-- 가능하면 캘린더 사용 -->
      <v-text-field
        v-model="program.period"
        :counter="10"
        :rules="periodRules"
        label="2021-01-01/2021-12-31"
        required
      ></v-text-field> 

      <v-text-field
        v-model="program.time"
        :counter="10"
        :rules="timeRules"
        label="월, 목/19:30~21:00"
        required
      ></v-text-field>   
      
      <v-text-field
        v-model="program.price"
        :counter="10"
        :rules="priceRules"
        label="Price"
        required
      ></v-text-field>   

      <!-- 카테고리 -->
      <v-sheet
        class="py-4 px-1"
      >
        <v-chip-group
          multiple
          active-class="primary--text"
        >
          <v-chip
            v-for="item in categories"
            :key="item"
          >
            {{ item }}
          </v-chip>
        </v-chip-group>
      </v-sheet> 
      
      <v-checkbox
        v-model="program.checkbox"
        :rules="[v => !!v || 'You must agree to continue!']"
        label="Do you agree?"
        required
      ></v-checkbox>

      <v-btn
        :disabled="!valid"
        color="success"
        class="mr-4"
        @click="addProgram"
      >
        Submit
      </v-btn>

      <v-btn
        color="error"
        class="mr-4"
        @click="reset"
      >
        Reset Form
      </v-btn>
    </v-form>
  </v-container>
</template>

<script>
export default {
  name: 'ExpAddMeeting',
  data: () => ({
    valid: true,
    categories: ['우울', '불안', '성격문제', '애착', 
          '대인기피', '분노조절', '자존감', 
          '중독', '대인관계', '부부', '가족상담',
        ],
    program: {
      title: '',
      content: '',
      period: '',
      time: '',
      price: '',
      categories: '우울',
      checkbox: false,
    },
    titleRules: [
      v => !!v || 'Name is required',
      v => (v && v.length <= 10) || 'Name must be less than 10 characters',
    ],
    contentRules: [
      v => !!v || 'Content is required',
      v =>  v.length > 10 || 'Content must be more than 10 characters',
    ],
    periodRules: [
      v => !!v || 'Period is required',
      v =>  v.length == 21 || 'Period must be 21 characters ex)2021-01-01/2021-12-31',
    ],
    timeRules: [
      v => !!v || 'Time is required',
      v =>  v.length > 0 || 'Time must be 21 characters ex)월, 목/19:30~21:00',
    ],
    priceRules: [
      v => !!v || 'Period is required',
      v =>  v.length > 0 || 'Period must be more than 0 characters',
    ],
  }),

  methods: {
    addProgram: function () {
      if (this.$refs.form.validate()) {
        console.log(this.program)
      }
    },
    reset () {
      this.$refs.form.reset()
    },
  },
}
</script>

<style>

</style>