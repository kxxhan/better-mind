<template>
  <v-container id="pub-activities">
    <!-- <v-icon>{{ icons.mdiAccountStar }}</v-icon> -->
    <h1>Mind님의 활동내역</h1>
    <v-spacer></v-spacer>
    <v-row class="d-flex mt-5">
      <v-col class="justify-center">
        <v-card style="height:50px;">
          포인트
        </v-card>
      </v-col>
      <v-col class="justify-center">
        <v-card style="height:50px;">
          작성글 수 
        </v-card>
      </v-col>
      <v-col class="justify-center">
        <v-card style="height:50px;">
          작성댓글 수
        </v-card>
      </v-col>
    </v-row>
    <v-row>
      <!-- 작성한 글 -->
      <v-col>
        <v-container fluid>
          <v-row justify="center">
            <!-- <v-subheader>My Article</v-subheader> -->
            <div class="mt-4 mb-5">
              <!-- <span><i class="far fa-newspaper fa-3x" style="color:grey;"></i></span> -->
              <span class="my-4 ms-2 fs-3 fw-bold">My Article</span>
            </div>

            <v-expansion-panels popout>
              <v-expansion-panel
                v-for="(message, i) in messages"
                :key="i"
                hide-actions
              >
                <v-expansion-panel-header>
                  <v-row
                    align="center"
                    class="spacer"
                    no-gutters
                  >
                    <v-col
                      cols="4"
                      sm="2"
                      md="1"
                    >
                      <v-avatar
                        size="36px"
                      >
                        <img
                          v-if="message.avatar"
                          alt="Avatar"
                          src="https://avatars0.githubusercontent.com/u/9064066?v=4&s=460"
                        >
                        <v-icon
                          v-else
                          :color="message.color"
                          v-text="message.icon"
                        ></v-icon>
                      </v-avatar>
                    </v-col>

                    <v-col
                      class="hidden-xs-only"
                      sm="5"
                      md="3"
                    >
                      <strong v-html="message.name"></strong>/
                      <span
                        v-if="message.total"
                        class="grey--text"
                      >
                        ({{ message.total }})
                      </span>
                    </v-col>

                    <v-col
                      class="text-no-wrap"
                      cols="5"
                      sm="3"
                    >
                      <strong v-html="message.title"></strong>
                    </v-col>
                  </v-row>
                </v-expansion-panel-header>

                <v-expansion-panel-content>
                  <v-divider></v-divider>
                  <v-card-text v-text="lorem"></v-card-text>
                </v-expansion-panel-content>
              </v-expansion-panel>
            </v-expansion-panels>
          </v-row>
        </v-container>
      </v-col>

      <!-- 포스트잇 -->
      <v-col>
        <v-container fluid>
          <v-row justify="center">
            <v-subheader>My POST-IT</v-subheader>

            <v-expansion-panels popout>
              <v-expansion-panel
                v-for="(message, i) in messages"
                :key="i"
                hide-actions
              >
                <v-expansion-panel-header>
                  <v-row
                    align="center"
                    class="spacer"
                    no-gutters
                  >
                    
                    <!-- 날짜 -->
                    <v-col
                      class="hidden-xs-only"
                      sm="5"
                      md="3"
                    >
                      <strong v-html="message.name"></strong>
                    </v-col>

                    <!-- 오늘의 질문 -->
                    <v-col
                      class="text-no-wrap"
                      cols="5"
                      sm="3"
                    >                
                      <strong v-html="message.title"></strong>
                    </v-col>
                  </v-row>
                </v-expansion-panel-header>

                <!-- 내 포스트잇 -->
                <v-expansion-panel-content>
                  <v-divider></v-divider>
                  <v-card-text v-text="lorem"></v-card-text>
                </v-expansion-panel-content>
              </v-expansion-panel>
            </v-expansion-panels>
          </v-row>
        </v-container>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
// import { mdiAccountStar } from '@mdi/js'

export default {
  name: 'PubActivities',
  data: () => ({
    // icons: {
    //   mdiAccountStar
    // },
    messages: [
      {
        avatar: 'https://avatars0.githubusercontent.com/u/9064066?v=4&s=460',
        name: 'John Leider',
        title: 'Welcome to Vuetify!',
      },
      {
        color: 'red',
        icon: 'mdi-account-multiple',
        name: 'Social',
        total: 3,
        title: 'Twitter',
      },
      {
        color: 'teal',
        icon: 'mdi-tag',
        name: 'Promos',
        total: 4,
        title: 'Shop your way',
      },
    ],
    lorem: 'Lorem ipsum dolor sit amet, at aliquam vivendum vel, everti delicatissimi cu eos. Dico iuvaret debitis mel an, et cum zril menandri. Eum in consul legimus accusam. Ea dico abhorreant duo, quo illum minimum incorrupte no, nostro voluptaria sea eu. Suas eligendi ius at, at nemore equidem est. Sed in error hendrerit, in consul constituam cum.',
  }),
}
</script>

<style>

</style>