<template>
  <div>
    <v-box class="box">   
      <v-container class="container"> 
        <div class="form"> 
          <h2>LOGIN to BetterMind</h2>
          <div class="inputBx">
            <input 
              v-model="credentials.id"
              type="text" 
              required="required"
            >
            <span>ID</span>
            <img src="https://www.flaticon.com/svg/static/icons/svg/709/709699.svg" alt="user">
          </div>
          <div class="inputBx password">
            <input 
              v-model="credentials.password" 
              id="password-input" 
              type="password" 
              name="password" 
              required="required"
            >
            <span>Password</span>
            <img src="https://www.flaticon.com/svg/static/icons/svg/1828/1828471.svg" alt="lock">
          </div>
          <div
            @click="login()" 
            class="inputBx"
          >
            <input type="submit" value="Log in"> 
          </div>
          <p>Don't have an account <a href="#" @click="moveSignup()">Sign up</a></p>
        </div>
      </v-container>
    </v-box>
    <Footer/>
  </div>
</template>

<script>
import axios from 'axios'
import Footer from '@/components/footer/Footer.vue'

export default {
  name: 'Login',
  components: {
    Footer
  },
  data: function () {
    return {
      credentials: {
        id: '',
        password: '',
      }
    }
  },
  methods: {
    moveSignup: function () {
      this.$router.push({ name: 'Signup' })
    },
    login: function () {
      axios({
        console.log('/api/v1/auth/login')
        method: 'post',
        url: '/api/v1/auth/login',
        data: this.credentials,
      })
      .then((res) => {
        localStorage.setItem('jwt', res.data.accessToken)
        this.$store.dispatch('getMyInfo')
        this.$router.push({ name: 'Main' })
      })
      .catch(() => {
        alert('The id or password is incorrect')
        this.credentials.password = ''
      })
    }
  }
}
</script>


<style scoped>
* {
  margin: 0;
  padding: 0;
  box-shadow: border-box;
}

img {
  width: 32px;
}

.box {
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 90vh;
}

.container {
  position: relative;
  padding: 50px;
  width: 330px;
  min-height: 480px;
  display: flex;
  justify-content: center;
  align-items: center;
  backdrop-filter: blur(5px);
  border-radius: 10px;
  box-shadow: 0 25px 45px rgba(0, 0, 0, 0.2);
}

h2 {
  color: rgb(56, 55, 55);
  letter-spacing: 2px;
  margin-bottom: 30px;
}

.inputBx {
  position: relative;
  width: 100%;
  margin-bottom: 20px;
}
    
input {
  width: 100%;
  outline: none;
  border: none;
  border: 1px solid rgba(255, 255, 255, 0.2);
  background: rgba(255, 255, 255, 0.2);
  padding: 8px 10px;
  padding-left: 40px;
  border-radius: 15px;
  color: rgb(56, 55, 55);
  font-size: 16px;
  box-shadow: 0 5px 15px rgba(0, 0, 0, 0.05);
}
  
img {
  position: absolute;
  top: 6px;
  left: 8px;
  transform: scale(0.6);
  filter: invert(.4);
}
    
input[type="submit"] {
  background: #fff;
  max-width: 100px;
  padding: 8px 10px;
  box-shadow: none;
  letter-spacing: 1px;
  cursor: pointer;
  transition: 1.5s;
}

input[type="submit"]:hover {
  background: linear-gradient(115deg, 
    rgba(0,0,0,0.10), 
    rgba(255,255,255,0.25));
  color: rgb(56, 55, 55);
  transition: .5s;
}
    
span {
    position: absolute;
    left: 30px;
    padding: 10px;
    display: inline-block;
    color: rgb(56, 55, 55);
    transition: .5s;
    pointer-events: none;
  }

input:focus ~ span,
input:valid ~ span {
  transform: translateX(-30px) translateY(-25px);
  font-size: 12px;
}

p {
  color: rgb(56, 55, 55);
  font-size: 15px;
  margin-top: 5px;
}
</style>