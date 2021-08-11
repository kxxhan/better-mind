<template>
  <v-footer padless color="transparent">
    <v-card flat tile class="text-center flex" color="transparent" height="15vh">
      <v-card-text>
        <v-btn icon class="mx-4">
          <v-icon size="24px">mdi-gitlab</v-icon>
        </v-btn>
        <v-btn icon class="mx-4">
          <v-icon size="24px">mdi-github</v-icon>
        </v-btn>
        <v-btn icon class="mx-4">
          <v-icon size="24px">mdi-youtube</v-icon>
        </v-btn>
      </v-card-text>

      <v-card-text>
        © 2021. <strong>BetterMind</strong> all rights reserved
      </v-card-text>
    </v-card>
  </v-footer>
</template>

<script>
export default {

}
</script>

<style>
.footer {
  background-color: transparent !important;
}
</style>