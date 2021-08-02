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
      <v-card-title>
        Login
      </v-card-title>

      <v-card-text>
        <v-container>
          <v-row>
            <v-col
              cols="12"
            >
              <v-text-field
                v-model="credentials.id"
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
          @click="moveSignup"
        >
          Signup
        </v-btn>
        <v-btn
          @click="dialog = false"
        >
          Close
        </v-btn>

        <!-- 아이디, 비밀번호 없을 때 경고문구 띄우기 -->


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
import axios from 'axios'

export default {
  name: 'LoginModal',
  data: function () {
    return {
      dialog: false,
      credentials: {
        id: '',
        password: '',
      }
    }
  },
  methods: {
    moveSignup: function () {
      this.dialog = false
      this.$router.push({ name: 'Signup' })
    },
    login: function () {
      axios({
        method: 'post',
        url: '/api/v1/auth/login',
        data: this.credentials,
      })
      .then((res) => {
        this.dialog = false
        localStorage.setItem('jwt', res.data.accessToken)
        this.$router.go(0)
      })
      .catch(() => {
        alert('The id or password is incorrect')
        this.credentials.password = ''
      })
    }
  }
}
</script>

<style>

</style>