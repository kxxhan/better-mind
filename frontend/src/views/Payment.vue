<template>
  <div id="payment">
    <v-container>
      <v-btn 
        @click="moveBack()"
        icon
        x-large
      >
        <v-icon>mdi-arrow-left-thick</v-icon>
      </v-btn>
      <v-card color="transparent" >
        <v-card-title>
          <h2>{{ program.name }}</h2>
          <v-spacer></v-spacer>
          <v-card-subtitle>{{ program.userId }} 전문가</v-card-subtitle>
        </v-card-title>
        <hr class="mx-3">
        <v-card-text>일정 : {{ program.date }}</v-card-text>
        <v-card-text>시간 : {{ program.time }}</v-card-text>
        <v-card-text>카테고리 : {{ program.category }}</v-card-text>
        <hr class="mx-3">
        <v-card-actions>
          <v-row class="d-flex flex-column justify-center">
            <v-col
              cols="12"
              md="6"
            >
              <v-select
                :items="pay_methods"
                outlined
                label="지불 방법"
                v-model="pay_method"
              ></v-select>
            </v-col>
            <v-col
              cols="12"
              md="6"  
            >
              <v-text-field
                readonly
                outlined
                label="가격"
                v-model="won"
              ></v-text-field>
            </v-col>
          </v-row>
          <v-spacer></v-spacer>
          <v-btn outlined text color="indigo" @click="onPayment" class="me-5" x-large>
            결제
          </v-btn>
        </v-card-actions>
      </v-card>
      <CircleBtn/>
      <Footer/>
    </v-container>
  </div>
</template>

<script>
import Footer from '@/components/footer/Footer.vue'
import CircleBtn from '@/components/footer/CircleBtn.vue'
import axios from 'axios'

export default {
  name: 'Payment',
  components: {
    Footer,
    CircleBtn,
  },
  data: function () {
    return {
      pay_methods: ['card', 'trans', 'vbank', 'phone', 'samsun', 'kpay', 'kakaopay', 'payco', 'lpay', 'ssgpay', 'tosspay', 'cultureland', 'smartculture', 'happymoney'],
      pay_method: '',
    }
  },
  methods: {
    onPayment() {
      // 가맹점 식별
      const { IMP } = window
      IMP.init('imp79702928')

      // 결제 데이터 정보
      const data = {
        pg: 'html5_inicis',                            // PG사
        pay_method: this.pay_method,                   // 결제수단
        merchant_uid: `mid_${new Date().getTime()}`,   // 주문번호
        amount: this.program.price,                    // 결제금액
        name: this.program.name,                       // 주문명
        buyer_name: this.$store.state.userInfo.name,   // 구매자 이름
        buyer_tel: this.$store.state.userInfo.phone,   // 구매자 전화번호
        buyer_email: this.$store.state.userInfo.email, // 구매자 이메일
      }
      console.log(data)
      // 결제창 호출  
      IMP.request_pay(data, this.callback)
    },
    callback(res) {
      // 콜백 함수 정의
      const {
        success,
        merchant_uid,
        error_msg,
      } = res

      if (success) {
        alert('결제 성공')
        console.log(`${merchant_uid}`)
        // 프로그램 신청 처리
        const applyInfo = {
          program_id: this.program.id,
          user_id: this.$store.state.userInfo.id
        }
        axios ({
          method: 'post',
          url: '/api/v1/userprogram',
          data: applyInfo
        })
        .then(() => {
          console.log('신청성공')
          this.$router.push({ name: 'PersonalMeeting' })
        })
      } else {
        alert(`결제 실패 : ${error_msg}`)
      }
    },
    moveBack: function () {
      if (this.program.type === '1') {
        this.$router.push({ name: 'ProgramDetail', params: {program_pk: this.$route.params.program_pk }})
      } else {
        this.$router.push({ name: 'PersonalMeeting' })
      }
    }
  },
  created: function () {
    this.$store.dispatch('getProgram', this.$route.params.program_pk)
  },
  computed: {
    program: function () {
      return this.$store.state.program
    },
    won: function () {
      return this.$store.state.program.price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    }
  }
}
</script>

<style scoped>
#payment {
  max-width: 1200px;
  margin: 0 auto;
}

</style>