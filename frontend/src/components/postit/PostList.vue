<template>
  <v-item-group>
    <v-container>
      <v-row>
        <v-col
          v-for="n in 12"
          :key="n"
          cols="12"
          sm="6"
          md="4"
          lg="3"
        >
          <v-card class="d-flex flex-column justify-space-around" min-height="260px" max-width="260px" min-width="260px">
            <v-card flat class="d-flex justify-space-between">
              <p class="pl-5">oh</p>
              <p class="pr-3">10분전</p>
            </v-card>
            <v-card flat>
              <p class="text-center">고기</p>
            </v-card>
            <v-card flat>
              <p></p>
            </v-card>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-item-group>
</template>

<script>
export default {
  name: 'PostList',
  methods: {

  },
  created: function () {
    this.$store.dispatch('getAnswer', this.$store.state.lastQuestion.id)
  }
}
</script>

<style>

</style>