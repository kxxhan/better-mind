<template>
  <v-container>
    <BackBtn/>
    <v-card id="payment">
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
              label="결제 수단"
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
              label="결제 금액"
              v-model="program.price"
            ></v-text-field>
          </v-col>
        </v-row>
        <v-spacer></v-spacer>
        <v-btn @click="onPayment">
          결제하기
        </v-btn>
      </v-card-actions>
    </v-card>
    <CircleBtn/>
    <Footer/>
  </v-container>
</template>

<script>
import Footer from '@/components/footer/Footer.vue'
import CircleBtn from '@/components/footer/CircleBtn.vue'
import BackBtn from '@/components/BackBtn.vue'

export default {
  name: 'Payment',
  components: {
    Footer,
    CircleBtn,
    BackBtn
  },
  data: function () {
    return {
      pay_methods: ['card', 'trans', 'vbank', 'phone', 'samsun', 'kpay', 'kakaopay', 'payco', 'lpay', 'ssgpay', 'tosspay', 'cultureland', 'smartculture', 'happymoney'],
      pay_method: '',
      price: 1,
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
      } else {
        alert(`결제 실패 : ${error_msg}`)
      }
    }
  },
  created: function () {
    this.$store.dispatch('getProgram', this.$route.params.program_pk)
  },
  computed: {
    program: function () {
      return this.$store.state.program
    }
  }
}
</script>

<style scoped>
.container {
  padding-left: 100px;
  padding-right: 100px;
}
</style>