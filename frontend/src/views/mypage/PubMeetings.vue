<template>
  <div class="page-layout">
    <v-container>
      <v-btn 
        @click="moveBack()"
        icon
        x-large
      >
        <v-icon>mdi-arrow-left-thick</v-icon>
      </v-btn>
      <v-container id="pub-meetings">
        <v-item-group>
          <v-row>
            <v-col
              v-for="(program, n) in programlist"
              :key="n"
              cols="12"
              sm="6"
              md="4"
            >
              <v-item class="d-flex flex-column justify-center mb-2">
                <v-card
                  class="mx-auto"
                  max-width="350"
                  @click="showDetail(program)"
                >
                  <v-img
                    class="white--text align-end"
                    height="250px"
                    src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
                  >
                    <v-card-title>{{ program.category }}</v-card-title>
                  </v-img>

                  <v-card-subtitle class="pb-0 text-subtitle-1">
                    {{ program.name }}
                  </v-card-subtitle>

                  <v-card-text class="text--primary">
                    <div>미팅주소</div>
                    <div>{{ program.time }}</div>
                    <div>{{ program.userId }}</div>
                  </v-card-text>
                </v-card>
              </v-item>
            </v-col>
          </v-row>
        </v-item-group>
      </v-container>
      <CircleBtn/>
      <Footer/>
    </v-container>
  </div>
</template>

<script>
import Footer from '@/components/footer/Footer.vue'
import CircleBtn from '@/components/footer/CircleBtn.vue'

export default {
  name: 'PubMeetings',
  components: {
    Footer,
    CircleBtn,
  },
  methods: {
    showDetail: function (program) {     
      this.$router.push({ name: 'ProgramDetail', params: { program_pk: program.id }})
    },
    moveBack: function () {
      this.$router.push({ name: 'Main' })
    }
  },
  computed: {
    programlist: function () {
      return this.$store.state.myprogramlist
    }
  },
  created: function () {
    this.$store.dispatch('getMyPrograms')
  }
}
</script>

<style scoped>
.backbtn {
  text-decoration-line:line-through;
  background-color: none;
}
.page-layout {
  padding: 1rem;
  max-width: 1200px;
  margin: 0 auto;
}
</style>