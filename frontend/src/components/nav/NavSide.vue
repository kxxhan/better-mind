<template>
    <v-card
      width="256"
    >
      <v-navigation-drawer
        floating
        permanent
      >
        <v-list
          dense
          rounded
        >
          <!-- 개인 항목 -->
          <v-list-item
            v-for="item in pubItems"
            :key="item.title"
            router :to="{ name: item.link }"
          >
            <v-list-item-icon>
              <v-icon>{{ item.icon }}</v-icon>
            </v-list-item-icon>

            <v-list-item-content>
              <v-list-item-title>{{ item.title }}</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <!-- 전문가 항목 -->
          <v-list-item
            v-for="item in expItems"
            :key="item.title"
            router :to="{ name: item.link }"
          >
            <v-list-item-icon>
              <v-icon>{{ item.icon }}</v-icon>
            </v-list-item-icon>

            <v-list-item-content>
              <v-list-item-title>{{ item.title }}</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>
      </v-navigation-drawer>
    </v-card>
</template>

<script>
export default {
  name: "NavSide",
  data () {
    return {
      pubItems: [
        { title: '활동내역', icon: 'mdi-home-city', link: 'PubActivities'},
        { title: '모임정보', icon: 'mdi-account-group-outline', link: 'PubMeetings' },
        { title: '정보수정', icon: 'mdi-account', link: 'UpdateUserInfo'},
      ],
      expItems: [
        { title: '모임정보', icon: 'mdi-home-city', link: 'ExpMeetings'},
        { title: '프로그램 등록', icon: 'mdi-account-group-outline', link: 'ExpAddMeeting'},
        { title: '정보수정', icon: 'mdi-account', link: 'UpdateUserInfo'},
      ],
    }
  },
}
</script>

<style>

</style>