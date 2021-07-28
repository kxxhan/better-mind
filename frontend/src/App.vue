<template>
  <v-app>
    <NavTop/>
    <NavBottom/>
    <v-main
      class="box">
      <router-view/>
    </v-main>
  </v-app>
</template>

<script>
import NavTop from '@/components/nav/NavTop.vue'
import NavBottom from '@/components/nav/NavBottom.vue'

export default {
  name: 'App',
  components: {
    NavTop,
    NavBottom,
  },

  data: () => ({
    //
  }),
};
</script>
<style scoped>
.box {
  margin: 80px 30px
}
</style>