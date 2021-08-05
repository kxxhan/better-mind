<template>
  <v-container id="update-user-info">
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
          <v-text-field
            v-if="credentials.role == '1'"
            value="Expert User"
            label="Common or Expert"
            readonly
          ></v-text-field>
          <v-text-field
            v-else
            value="Common User"
            label="Common or Expert"
            readonly
          ></v-text-field>
        </v-col>
        <!-- certificate 번호는 넘어오지 않음 (요청필요)-->
        <v-col cols="3" v-if="credentials.role === '1'">
          <v-text-field
            v-model="credentials.certificate"
            label="Expert Certificate Num"
            readonly
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

      <v-btn
        class="mr-4"
        :disabled="!valid && checkbox"
        @click="updateInfo"
      >
        Edit Profile
      </v-btn>

    </v-form>
  </v-container>
</template>

<script>
import axios from 'axios'

export default {
  name: 'UpdateUserInfo',
  data: function () {
    return {
      valid: true,
      show: false,
      categories: ['우울', '불안', '성격문제', '애착', 
          '대인기피', '분노조절', '자존감', 
          '중독', '대인관계', '부부', '가족상담',
        ],
      credentials: {
        id: this.$store.state.userInfo.id,
        password: this.$store.state.userInfo.password,
        email: this.$store.state.userInfo.email,
        name: this.$store.state.userInfo.name, 
        phone: this.$store.state.userInfo.phone,
        role: this.$store.state.userInfo.role,
        category: this.$store.state.userInfo.category,
        certificate: this.$store.state.userInfo.certificate,
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
    updateInfo: function () {
      if (this.$refs.form.validate()) {
        axios({
          method: 'put',
          // 유저의 ID가 아니라 키값을 넣어줘야함, 받아오는 데이터 없음 요청 필요
          url: `/api/v1/users/4`,
          headers: {
            Authorization: `Bearer ${localStorage.getItem('jwt')}`
          },
          data: this.credentials,
        })
        .then((res) => {
          console.log(res)
        })
      }
    },
  },
  computed: {
    
  }
}
</script>

<style>

</style>