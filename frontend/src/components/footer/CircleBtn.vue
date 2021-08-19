<template>
  <div>
    <div class="list-container">
      <button class="more-button" aria-label="Menu Button" @click="toggle">
        <div class="menu-icon-wrapper">
          <div class="menu-icon-line half first"></div>
          <div class="menu-icon-line"></div>
          <div class="menu-icon-line half last"></div>
        </div>
      </button>
      <ul class="more-button-list">
        <li class="more-button-list-item" @click="$router.push({ name: 'UpdateUserInfo' })">
          <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-settings">
            <circle cx="12" cy="12" r="3"/>
            <path d="M19.4 15a1.65 1.65 0 00.33 1.82l.06.06a2 2 0 010 2.83 2 2 0 01-2.83 0l-.06-.06a1.65 1.65 0 00-1.82-.33 1.65 1.65 0 00-1 1.51V21a2 2 0 01-2 2 2 2 0 01-2-2v-.09A1.65 1.65 0 009 19.4a1.65 1.65 0 00-1.82.33l-.06.06a2 2 0 01-2.83 0 2 2 0 010-2.83l.06-.06a1.65 1.65 0 00.33-1.82 1.65 1.65 0 00-1.51-1H3a2 2 0 01-2-2 2 2 0 012-2h.09A1.65 1.65 0 004.6 9a1.65 1.65 0 00-.33-1.82l-.06-.06a2 2 0 010-2.83 2 2 0 012.83 0l.06.06a1.65 1.65 0 001.82.33H9a1.65 1.65 0 001-1.51V3a2 2 0 012-2 2 2 0 012 2v.09a1.65 1.65 0 001 1.51 1.65 1.65 0 001.82-.33l.06-.06a2 2 0 012.83 0 2 2 0 010 2.83l-.06.06a1.65 1.65 0 00-.33 1.82V9a1.65 1.65 0 001.51 1H21a2 2 0 012 2 2 2 0 01-2 2h-.09a1.65 1.65 0 00-1.51 1z"/>
          </svg>
          <span>정보수정</span>
        </li>
        <li class="more-button-list-item" @click="onLogout">
          <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-share">
            <path d="M4 12v8a2 2 0 002 2h12a2 2 0 002-2v-8M16 6l-4-4-4 4M12 2v13"/>
          </svg>
          <span>로그아웃</span>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import '../js/CircleBtn.js'

export default {
  methods: {
    toggle: function () {
      document.querySelector('.list-container').classList.toggle('active')
    },
    onLogout: function () {
      localStorage.removeItem('jwt')
      this.$store.commit('ON_LOGOUT')
      if (this.$route.path !== '/login') {
        this.$router.push({ name: 'Login' })
      }
    }
  }
}
</script>

<style scoped>
@import '../css/CircleBtn.css';
</style>