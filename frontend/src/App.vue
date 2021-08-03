<template>
  <v-app>
    <v-container>
      <NavBar/>
      <v-main class="my-4">
        <router-view/>
      </v-main>
    </v-container>
  </v-app>
</template>

<script>
import NavBar from '@/components/nav/NavBar.vue'

export default {
  name: 'App',
  components: {
    NavBar,
  },

  data: () => ({
    //
  }),
};
</script>
<style scoped>

</style>