<template>
  <div id="my-page">
    <MypageNav/>
    마이페이지
    <div>
      <PubActivities/>
      <PubMeetings/>
    </div>
    <p>------------------------</p>
    <div>
      <ExpAddMeeting/>
      <ExpMeetings/>
    </div>
    <p>------------------------</p>
    <UpdateUserInfo/>
  </div>
</template>

<script>
import MypageNav from '@/components/nav/MypageNav.vue'
import PubActivities from '@/components/mypage/PubActivities.vue'
import PubMeetings from '@/components/mypage/PubMeetings.vue'
import ExpAddMeeting from '@/components/mypage/ExpAddMeeting.vue'
import ExpMeetings from '@/components/mypage/ExpMeetings.vue'
import UpdateUserInfo from '@/components/mypage/UpdateUserInfo.vue'

export default {
  components: {
    MypageNav,
    PubActivities,
    PubMeetings,
    UpdateUserInfo,
    ExpAddMeeting,
    ExpMeetings
  }
}
</script>

<style>

</style>