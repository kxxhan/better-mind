<template>
  <v-app>
    <NavTop/>
    <NavBottom/>
    <v-main>
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
