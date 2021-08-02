<template>
  <v-container>
    <v-form
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
        :counter="11"
        hint="ex) 01012345678"
        required
      ></v-text-field>
      
      <!-- 주소 -->
      <v-text-field
        v-model="credentials.address"
        label="Address"
        required
      ></v-text-field>
      
      <!-- 일반인 / 전문가  -->
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

      <!-- 카테고리 -->
      <v-sheet
        class="py-4 px-1"
      >
        <v-chip-group
          multiple
          active-class="primary--text"
        >
        <!-- v-model="credentials.category" -->
        <!-- 리스트 형태로 category가 넘어가므로 우선 '우울'을 디폴트 -->

          <v-chip
            v-for="item in categories"
            :key="item"
          >
            {{ item }}
          </v-chip>
        </v-chip-group>
      </v-sheet>

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
</template>

<script>
import axios from 'axios'
export default {
  name: 'Signup',
  data: function () {
    return {
      valid: true,
      show: false,
      categories: ['우울', '불안', '성격문제', '애착', 
          '대인기피', '분노조절', '자존감', 
          '중독', '대인관계', '부부', '가족상담',
        ],
      credentials: {
        id: '',
        password: '',
        email: '',
        name: '', 
        phone: '',
        role: '',
        address: '',
        category: '우울',
        certificate: '000000',
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
        v => v.length >= 10 || 'Phone Number must be over than 10 characters',
        v => v.length <= 11 || 'Phone Number must be less than 11 characters'
      ],
      roleRules: [
        v => !!v || 'You must choose one to continue'
      ],
    }
  },
  methods: {
    submit: function () {
      if (this.$refs.form.validate()) {
        console.log(this.credentials)
        axios({
          method: 'post',
          url: '/api/v1/users',
          data: this.credentials
        })
        .then ((res) => {
          console.log(res)
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

<style>

</style>