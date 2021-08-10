<template>
  <v-btn 
    @click="moveBack()"
    icon
    x-large
  >
    <v-icon>mdi-arrow-left-thick</v-icon>
  </v-btn>
</template>

<script>
export default {
  name: 'BackBtn',
  methods: {
    moveBack: function () {
      this.$router.go(-1)
    }
  }
}
</script>

<style>
.backbtn {
  text-decoration-line:line-through;
  background-color: none;
}
</style>