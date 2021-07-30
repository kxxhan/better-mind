<template>
  <v-container id="exp-meetings">
    <NavSide/>
    전문가의 모임 정보
    여러개 있을 수 있고
    각 프로그램은 모달로 등장
  </v-container>
</template>

<script>
import NavSide from '@/components/nav/NavSide.vue'

export default {
  name: 'ExpMeetings',
  components: {
    NavSide,
  }
}
</script>

<style>

</style>