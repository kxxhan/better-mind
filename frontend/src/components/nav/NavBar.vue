<template>
  <nav>
    <v-row>
      <v-col cols="12">
        <!-- 상단 네브바 -->
        <v-toolbar flat app>
          <v-toolbar-title
            class="text-uppercase grey--text"
            style="cursor: pointer"
            @click="$router.push({ name: 'Main' })"
          >
            <span class="font-weight-light">Better</span>
            <span>Mind</span>
          </v-toolbar-title>
          <v-spacer></v-spacer>
          <v-btn text color="grey" :to="{ name: 'Signup' }">
            <span>Signup</span>
          </v-btn>
          <LoginModal/>
        </v-toolbar>
        <v-divider></v-divider>
      </v-col>
      

      <v-col cols="12">
        <!-- 하단 네브바 -->
        <v-toolbar flat>
          <v-row align="center" justify="center">
            <v-col cols="6" md="3">
              <v-btn text color="grey">
                <span>Personal-Counseling</span>
              </v-btn>
            </v-col>

            <v-col cols="6" md="3">
              <v-menu offset-y rounded="lg">
                <template v-slot:activator="{ on, attrs }">
                  <v-btn
                    text
                    v-bind="attrs"
                    v-on="on"
                  >
                    <span class="grey--text">
                      Group-Counseling
                    </span>
                  </v-btn>
                </template>
                <v-list>
                  <v-list-item router :to="{ name: 'ProgramItems' }">
                    <v-list-item-title>Expert Consultation</v-list-item-title>
                  </v-list-item>
                  <v-list-item>
                    <v-list-item-title>Self-help group</v-list-item-title>
                  </v-list-item>
                </v-list>
              </v-menu>
            </v-col>

            <v-col cols="6" md="3">
              <v-btn text color="grey" :to="{ name : 'PostItems' }">
                <span>Community</span>
              </v-btn>
            </v-col>

            <v-col cols="6" md="3">
              <v-btn text color="grey">
                <span>Post-it</span>
              </v-btn>
            </v-col>
          </v-row>
        </v-toolbar>
      </v-col>
    </v-row>
  </nav>
</template>

<script>
import LoginModal from '../LoginModal.vue'

export default {
  name: 'NavTop',
  components: {
    LoginModal
  },
  methods: {
  }
}
</script>

<style>

</style>