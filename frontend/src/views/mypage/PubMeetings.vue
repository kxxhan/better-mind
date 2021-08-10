<template>
  <v-container id="pub-meetings">
    <BackBtn/>
    <v-item-group>
      <v-row>
        <v-col
          v-for="n in 6"
          :key="n"
          cols="12"
          sm="6"
          md="4"
        >
          <v-item class="d-flex flex-column justify-center mb-2">
            <v-card
              class="mx-auto"
              max-width="350"
              @click="showDetail()"
            >
              <v-img
                class="white--text align-end"
                height="250px"
                src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
              >
                <v-card-title>프로그램 이미지</v-card-title>
              </v-img>

              <v-card-subtitle class="pb-0 text-subtitle-1">
                프로그램 이름
              </v-card-subtitle>

              <v-card-text class="text--primary">
                <div>미팅주소</div>
                <div>미팅시간</div>
              </v-card-text>
            </v-card>
          </v-item>
        </v-col>
      </v-row>
    </v-item-group>
  </v-container>
</template>

<script>
import BackBtn from '@/components/BackBtn.vue'

export default {
  name: 'PubMeetings',
  components: {
    BackBtn,
  },
  methods: {
    showDetail: function () {
      this.$router.push({ name: 'ProgramDetail' })
    },
  },
}
</script>

<style>

</style>