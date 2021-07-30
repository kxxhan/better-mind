<template>
  <v-container>
    <v-card id="payment">
      <v-card-title>
        <h2>프로그램 이름</h2>
        <v-spacer></v-spacer>
        <v-card-subtitle>전문가</v-card-subtitle>
      </v-card-title>
      <hr class="mx-3">
      <v-card-text>일정</v-card-text>
      <v-card-text>시간</v-card-text>
      <v-card-text>회차</v-card-text>
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
              v-model="price"
            ></v-text-field>
          </v-col>
        </v-row>
        <v-spacer></v-spacer>
        <v-btn @click="onPayment">
          결제하기
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-container>
</template>

<script>
export default {
  name: 'Payment',
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
        pg: 'html5_inicis',                           // PG사
        pay_method: this.pay_method,                           // 결제수단
        merchant_uid: `mid_${new Date().getTime()}`,   // 주문번호
        amount: this.price,                                 // 결제금액
        name: '테스트',                  // 주문명
        buyer_name: '김싸피',                           // 구매자 이름
        buyer_tel: '01012341234',                     // 구매자 전화번호
        buyer_email: 'ssafy@ssafy.com',               // 구매자 이메일
        buyer_addr: '대전 유성구 삼성연수원',                    // 구매자 주소
        buyer_postcode: '12345',                      // 구매자 우편번호
      }

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
  }
}
</script>

<style>

</style>