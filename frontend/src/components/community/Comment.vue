<template>
  <v-container id="comment">
    <v-list disabled>
      <v-subheader>Comment List</v-subheader>
        <v-list-item
          v-for="(item, i) in items"
          :key="i"
        >
          <v-list-item-content>
            <v-list-item-title v-text="item.text"></v-list-item-title>
            <hr>
          </v-list-item-content>
        </v-list-item>
    </v-list>
  </v-container>
</template>

<script>
export default {
  data: () => ({
      items: [
        { text: '댓글1'},
        { text: '댓글2'},
        { text: '댓글3'},
      ],
    }),
}
</script>

<style>

</style>