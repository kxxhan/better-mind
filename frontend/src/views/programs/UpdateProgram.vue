<template>
  <div>
    <v-container id="exp-add-meeting">
      <v-btn 
        @click="moveBack()"
        icon
        x-large
      >
        <v-icon>mdi-arrow-left-thick</v-icon>
      </v-btn>

      <h1 class="d-flex justify-center">Edit Program</h1>

      <v-form
        ref="form"
        v-model="valid"
        lazy-validation
        class="mt-5"
      >
        <v-text-field
          v-if="program.type == '0'"
          value="1:1 상담"
          label="Personal or Group"
          readonly
        >
        </v-text-field>
        <v-text-field
          v-else
          value="그룹 상담"
          label="Personal or Group"
          readonly
        >
        </v-text-field>

        <v-text-field
          v-model="program.name"
          :rules="nameRules"
          label="Program Name"
          required
        ></v-text-field>

        <v-text-field
          v-model="program.report"
          :rules="reportRules"
          label="Program Content"
          required
        ></v-text-field>

        <v-text-field
          v-model="program.description"
          :rules="descriptionRules"
          label="Expert Description"
          required
        ></v-text-field>

        <!-- 가능하면 캘린더 사용 -->
        <v-text-field
          v-model="program.date"
          :rules="dateRules"
          label="2021-01-01/2021-12-31"
          required
        ></v-text-field> 

        <v-text-field
          v-model="program.time"
          :rules="timeRules"
          label="월, 목/19:30~21:00"
          required
        ></v-text-field>  

        <v-text-field
          v-if="program.type == '1'"
          v-model="program.count"
          :rules="countRules"
          label="Number of participants"
          required
        ></v-text-field>   
        
        <v-text-field
          v-model="program.price"
          :rules="priceRules"
          label="Price"
          required
        ></v-text-field>   

        <!-- 카테고리 -->
        <v-sheet
          class="py-4 px-1"
          color="transparent"
        >
          <v-chip-group
            active-class="primary--text"
          >
            <v-chip
              v-for="item in category"
              :key="item"
              @click="choiceCategory(item)"
            >
              {{ item }}
            </v-chip>
          </v-chip-group>
        </v-sheet> 
        
        <v-btn
          :disabled="!valid"
          class="mr-4"
          @click="addProgram"
        >
          Submit
        </v-btn>

        <!-- <v-btn
          text
          :disabled="!valid"
          color="warning"
          class="mr-4"
          @click="movePost()"
        >
          Back
        </v-btn> -->

      </v-form>
    </v-container>
    <Footer/>
    <CircleBtn/>
  </div>
</template>

<script>
import axios from 'axios'
import Footer from '@/components/footer/Footer.vue'
import CircleBtn from '@/components/footer/CircleBtn.vue'

export default {
  name: 'UpdateProgram',
  components: {
    Footer,
    CircleBtn
  },
  data: () => ({
    valid: true,
    category: [
      '일반고민', '취업진로', '직장', '연애', 
      '성추행', '대인관계', '외모', 
      '가족', '학업', '금전', '이별이혼', 
      '육아', '중독', '건강', '성격'
    ],
    program: {
      name: '',
      report: '',
      description: '',
      date: '',
      time: '',
      count: 0,
      price: 0,
      category: '',
      userId: '',
      type: ''
    },
    nameRules: [
      v => !!v || 'Name is required',
      v => v.length > 0 || 'Name must be more than 0 characters',
    ],
    reportRules: [
      v => !!v || 'Program content is required',
      v =>  v.length > 10 || 'Program content must be more than 10 characters',
    ],
    descriptionRules: [
      v => !!v || 'Expert description is required',
      v =>  v.length > 10 || 'Expert description must be more than 10 characters',
    ],
    dateRules: [
      v => !!v || 'Date is required',
      v =>  v.length == 21 || 'Date must be 21 characters ex)2021-01-01/2021-12-31',
    ],
    timeRules: [
      v => !!v || 'Time is required',
      v =>  v.length > 0 || 'Time must be 21 characters ex)월, 목/19:30~21:00',
    ],
    countRules: [
      v => !!v || 'Number of participants is required',
      v =>  v > 0 || 'Number of participants must be more than 0',
    ],
    priceRules: [
      v => !!v || 'Period is required',
      v =>  v > 0 || 'Price must be more than 0',
    ],
    categoryRules: [
      v => !!v || 'Category is required',
      v => v.length > 0 || 'Category must be 1 item',
    ],
  }),
  methods: {
    addProgram: function () {
      if (this.$refs.form.validate()) {
        this.program.userId = this.$store.state.userInfo.userid
        axios({
          method: 'put',
          url: `/api/v1/program/${this.$route.params.program_pk}`,
          data: this.program
        })
        .then (() => {
          this.$router.push({ name: 'ExpMeetings' })
        })
        .catch((err) => {
          console.log(err)
        })
      }
    },
    choiceCategory: function (item) {
      this.program.category = item
    },
    movePost: function () {
      this.$router.push({ name: 'ExpMeetings' })
    },
    moveBack: function () {
      this.$router.push({ name: 'ExpMeetings' })
    }
  },
  created: function () {
    this.$store.dispatch('getProgram', this.$route.params.program_pk)
    this.program.name = this.$store.state.program.name
    this.program.report = this.$store.state.program.report
    this.program.description = this.$store.state.program.description
    this.program.date = this.$store.state.program.date
    this.program.time = this.$store.state.program.time
    this.program.count = this.$store.state.program.count
    this.program.price = this.$store.state.program.price    
    this.program.category = this.$store.state.program.category
    this.program.type = this.$store.state.program.type
  },
}
</script>

<style scoped>
.container {
  padding-left: 100px;
  padding-right: 100px;
}
.backbtn {
  text-decoration-line:line-through;
  background-color: none;
}
</style>