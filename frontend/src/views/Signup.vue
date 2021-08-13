<template>
  <div>
    <v-container>
      <BackBtn/>
      <h1 class="d-flex justify-center">Singup</h1>
      <v-form
        class="mt-5"
        ref="form"
        v-model="valid"
        lazy-validation
      >
        <!-- 아이디 -->
        <v-text-field
          v-model="credentials.id"
          :counter="20"
          :rules="idRules"
          label="ID"
          required
        ></v-text-field>
        
        <!-- 패스워드 -->
        <v-text-field
          v-model="credentials.password"
          :append-icon="show ? 'mdi-eye' : 'mdi-eye-off'"
          :rules="passwordRules"
          :type="show ? 'text' : 'password'"
          label="Password"
          counter
          required
          @click:append="show = !show"
        ></v-text-field>
        
        <!-- 패스워드 확인 -->
        <v-text-field
          v-model="confirmPassword"
          :append-icon="show ? 'mdi-eye' : 'mdi-eye-off'"
          :rules="confirmPasswordRules"
          :type="show ? 'text' : 'password'"
          label="Confirm Password"
          counter
          required
          @click:append="show = !show"
        ></v-text-field>

        <!-- 이메일 -->
        <v-text-field
          v-model="credentials.email"
          :rules="emailRules"
          label="E-mail"
          required
        ></v-text-field>

        <!-- 이름 -->
        <v-text-field
          v-model="credentials.name"
          :rules="nameRules"
          label="Name"
          required
        ></v-text-field>

        <!-- 핸드폰 -->
        <v-text-field
          v-model="credentials.phone"
          :rules="phoneRules"
          label="Phone Number"
          :counter="13"
          hint="ex) 010-1234-5678"
          required
        ></v-text-field>
        
        <!-- 일반인 / 전문가  -->
        <v-row>
          <v-col cols="5">
            <v-radio-group
              label="Common or Expert"
              v-model="credentials.role"
              row
              :rules="roleRules"
              required
            >
              <v-radio
                label="Common User"
                value="0"
              ></v-radio>
              <v-radio
                label="Expert User"
                value="1"
              ></v-radio>
            </v-radio-group>
          </v-col>
          <v-col cols="3" v-if="credentials.role === '1'">
            <v-text-field
              v-model="credentials.certificate"
              label="Expert Certificate Num"
            ></v-text-field>
          </v-col>
        </v-row>

        <!-- 카테고리 -->
        <v-select
          v-model="credentials.category"
          :items="categories"
          :rules="[v => !!v || 'Category is required']"
          label="Category"
          required
        ></v-select>

        <!-- 약관 동의 -->
        <v-checkbox
          v-model="checkbox"
          :rules="[v => !!v || 'You must agree to continue!']"
          label="Do you agree?"
          required
        ></v-checkbox>

        <v-btn
          class="mr-4"
          :disabled="!valid && checkbox"
          @click="submit"
        >
          submit
        </v-btn>

        <v-btn @click="clear">
          clear
        </v-btn>
      </v-form>
    </v-container>
    <Footer/>
  </div>
</template>

<script>
import axios from 'axios'
import Footer from '@/components/footer/Footer.vue'
import BackBtn from '@/components/BackBtn.vue'

export default {
  name: 'Signup',
  components: {
    Footer,
    BackBtn
  },
  data: function () {
    return {
      valid: true,
      show: false,
      category: [
        '일반고민', '취업진로', '직장', '연애', 
        '성추행', '대인관계', '외모', 
        '가족', '학업', '금전', '이별이혼', 
        '육아', '중독', '건강', '성격'
      ],
      credentials: {
        id: '',
        password: '',
        email: '',
        name: '', 
        phone: '',
        role: '',
        category: '',
        certificate: '',
      },
      checkbox: false,
      idRules: [
        v => !!v || 'ID is required',
        v => v.length >= 6 || 'ID must be over than 6 characters',
        v => v.length <= 20 || 'ID must be less than 20 cahracters'
      ],
      passwordRules: [
        v => !!v || 'Password is required',
        v => v.length >= 8 || 'Password must be over than 8 characters',
      ],
      confirmPassword: '',
      confirmPasswordRules: [
        v => !!v || 'Password is required',
        v => v === this.credentials.password || 'Password confirmation does not match' 
      ],
      emailRules: [
        v => !!v || 'E-mail is required',
        v => /.+@.+\..+/.test(v) || 'E-mail must be valid',
      ],
      nameRules: [
        v => !!v || 'Name is required',
      ],
      phoneRules: [
        v => !!v || 'Phone Number is required',
        v => v.length >= 12 || 'Phone Number must be over than 12 characters',
        v => v.length <= 13 || 'Phone Number must be less than 13 characters'
      ],
      roleRules: [
        v => !!v || 'You must choose one to continue'
      ],
    }
  },
  methods: {
    submit: function () {
      if (this.$refs.form.validate()) {
        axios({
          method: 'post',
          url: '/api/v1/users',
          data: this.credentials
        })
        .then (() => {
          // 회원가입 후 로그인 상태로, 메인 페이지 이동
          const loginData = { id: this.credentials.id, password: this.credentials.password }
          axios({
            method: 'post',
            url: '/api/v1/auth/login',
            data: loginData
          })
          .then((res) => {
            localStorage.setItem('jwt', res.data.accessToken)
            this.$store.commit('ON_LOGIN')
            this.$router.push({ name: 'Main' })
          })
          .catch((err) => {
            console.log(err)
          })
        })
        .catch(error => {
          console.log(error)
        })
      }
    },
    clear: function () {
      this.credentials.id = ''
      this.credentials.password = ''
      this.confirmPassword = ''
      this.credentials.email = ''
      this.credentials.name = ''
      this.credentials.phone = ''
      this.credentials.role = ''
      this.credentials.address = ''
    }
  }
}
</script>

<style scoped>
.container {
  padding-left: 100px;
  padding-right: 100px;
}
</style>