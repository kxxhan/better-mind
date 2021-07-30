import Vue from 'vue'
import VueRouter from 'vue-router'
import Main from '../views/Main.vue'
import Signup from '../views/Signup.vue'
import MyPage from '../views/MyPage.vue'
import PubActivities from '../views/mypage/PubActivities.vue'
import PubMeetings from '../views/mypage/PubMeetings.vue'
import ExpMeetings from '../views/mypage/ExpMeetings.vue'
import ExpAddMeeting from '../views/mypage/ExpAddMeeting.vue'
import UpdateUserInfo from '../views/mypage/UpdateUserInfo.vue'
import ProgramItems from '../views/programs/ProgramItems.vue'
import ProgramDetail from '../views/programs/ProgramDetail.vue'
import PostItems from '../views/community/PostItems.vue'
import PostDetail from '../views/community/PostDetail.vue'
import CreatePost from '../views/community/CreatePost.vue'
import UpdatePost from '../views/community/UpdatePost.vue'
import Payment from '../views/Payment.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Main',
    component: Main
  },
  {
    path: '/signup',
    name: 'Signup',
    component: Signup
  },
  {
    path: '/mypage',
    name: 'MyPage',
    component: MyPage
  },
  {
    path: '/mypage/pubactivities',
    name: 'PubActivities',
    component: PubActivities
  },
  {
    path: '/mypage/pubmeetings',
    name: 'PubMeetings',
    component: PubMeetings
  },
  {
    path: '/mypage/expmeetings',
    name: 'ExpMeetings',
    component: ExpMeetings
  },
  {
    path: '/mypage/expaddmeeting',
    name: 'ExpAddMeeting',
    component: ExpAddMeeting
  },
  {
    path: '/mypage/updateuserinfo',
    name: 'UpdateUserInfo',
    component: UpdateUserInfo
  },
  {
    path: '/programs',
    name: 'ProgramItems',
    component: ProgramItems
  },
  {
    // pk값으로 넘겨주기
    path: '/programs/1',
    name: 'ProgramDetail',
    component: ProgramDetail
  },
  {
    // pk값으로 넘겨주기
    path: '/community',
    name: 'PostItems',
    component: PostItems
  },
  {
    // pk값으로 넘겨주기
    path: '/community/1',
    name: 'PostDetail',
    component: PostDetail
  },
  {
    path: '/community/create',
    name: 'CreatePost',
    component: CreatePost
  },
  {
    // pk값으로 넘겨주기
    path: '/community/update/1',
    name: 'UpdatePost',
    component: UpdatePost
  },
  {
    // pk값으로 넘겨주기
    path: '/payment/1',
    name: 'Payment',
    component: Payment
  },
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
