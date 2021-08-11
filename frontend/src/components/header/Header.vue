<template>
  <v-card class="d-flex justify-space-between align-center" flat color="transparent" height="15vh">
    <div class="text-h4 grey--text text--darken-1 ms-16">
      BETTER<strong>MIND</strong>
    </div>
    <div class="me-16 grey--text text--darken-1">
      <v-icon>mdi-account</v-icon>
      {{ $store.state.userInfo.name }}
    </div>
  </v-card>
</template>

<script>
export default {

}
</script>

<style>

</style>