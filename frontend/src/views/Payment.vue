<template>
  <v-card id="payment">
    <v-card-title>
      <h2>결제 페이지</h2>
    </v-card-title>
    <v-card-actions>
      <v-spacer></v-spacer>
      <v-btn @click="onPayment">
        결제하기
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
export default {
  name: 'Payment',
  methods: {
    onPayment() {
      // 가맹점 식별
      const { IMP } = window
      IMP.init('imp79702928')

      // 결제 데이터 정보
      const data = {
        pg: 'kakaopay',                           // PG사
        pay_method: 'card',                           // 결제수단
        merchant_uid: `mid_${new Date().getTime()}`,   // 주문번호
        amount: 1000,                                 // 결제금액
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