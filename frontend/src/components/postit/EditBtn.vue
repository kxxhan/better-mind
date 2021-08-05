<template>
  <v-dialog
    v-model="dialog"
    width="500"
  >
    <template v-slot:activator="{ on, attrs }">
      <v-btn
        text
        x-large
        v-bind="attrs"
        v-on="on"
      >
        Edit
      </v-btn>
    </template>

    <v-card>
      <v-card-title class="text-h5 grey lighten-2">
        질문 목록
      </v-card-title>

      <v-simple-table>
        <template>
          <thead>
            <tr>
              <th class="text-left">No.</th>
              <th class="text-left">Content</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="list in this.$store.state.questions"
              :key="list.id"
            >
              <td>{{ list.id }}</td>
              <td>{{ list.content }}</td>
            </tr>
          </tbody>
        </template>
      </v-simple-table>
      <v-divider></v-divider>

      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn
          color="primary"
          text
          @click="dialog = false"
        >
          I accept
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  data: function () {
    return {
      dialog: false,
    }
  },
  created: function () {
    // 포스트잇 리스트 GET API 요청
    this.$store.dispatch('getQuestions')
  }
}
</script>

<style>

</style>