<template>
  <v-dialog
    v-model="dialog"
    max-width="600px"
  >
    <template v-slot:activator="{ on, attrs }">
      <v-btn
        color="white"
        v-bind="attrs"
        v-on="on"
        text
      >
        로그인
      </v-btn>
    </template>

    <v-card>
      <v-card-text>
        <v-container>
          <v-row>
            <v-col
              cols="12"
            >
              <v-text-field
                v-model="credentials.userid"
                label="ID"
                required
              ></v-text-field>
            </v-col>

            <v-col
              cols="12"
            >
              <v-text-field
                v-model="credentials.password"
                label="Password*"
                type="password"
                required
              ></v-text-field>
            </v-col>
          </v-row>
        </v-container>
      </v-card-text>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn
          @click="dialog = false"
        >
          Close
        </v-btn>
        <v-btn
          @click="login()"
        >
          Login
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  name: 'LoginModal',
  data: function () {
    return {
      dialog: false,
      credentials: {
        userid: '',
        password: '',
      }
    }
  },
  methods: {
    login: function () {
      console.log(this.credentials)
    }
  }
}
</script>

<style>

</style>