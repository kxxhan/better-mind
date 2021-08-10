<template>
  <div>
    <v-container>
      <v-card>
        <v-container>
          <v-row>
            <v-col
              v-for="(item, n) in dummy"
              :key="n"
              cols="12"
              md="6"
            >
              <v-item>
                <v-card min-height="250px">
                  <v-img
                    src="https://images.unsplash.com/photo-1529156069898-49953e39b3ac?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1"
                    height="150px"
                  ></v-img>

                  <v-card-title>
                    {{ n+1 }}번 자조모임 제목
                  </v-card-title>

                  <v-card-subtitle>
                    {{ item }}
                  </v-card-subtitle>

                  <v-card-actions v-if="n === 1">
                    <v-btn
                      color="error"
                      text
                    >
                      마감 임박
                    </v-btn>
                  </v-card-actions>
                  <v-card-actions v-else-if="n === 0 || n === 4">
                    <v-btn
                      color="warning"
                      text
                    >
                      4/7
                    </v-btn>
                  </v-card-actions>
                  <v-card-actions v-else>
                    <v-btn
                      color="green"
                      text
                    >
                      3/8
                    </v-btn>
                  </v-card-actions>

                </v-card>
              </v-item>
            </v-col>
          </v-row>
        </v-container>
        <v-divider></v-divider>
        <v-row justify="center" align="center">
          <v-col
            cols="12"
            sm="10"
          >
            <v-card
              class="my-4"
              flat
            >
              <div class="pa-4">
                <v-chip-group
                  active-class="primary--text"
                  column
                >
                  <v-chip
                    v-for="item in category"
                    :key="item"
                  >
                    {{ item }}
                  </v-chip>
                </v-chip-group>
              </div>
            </v-card>
          </v-col>
          <v-col cols="12" sm="2">
            <v-btn x-large>신청</v-btn>
          </v-col>
        </v-row>
      </v-card>
    </v-container>
    <CircleBtn/>
    <Footer/>
  </div>
</template>

<script>
import Footer from '@/components/footer/Footer.vue'
import CircleBtn from '@/components/footer/CircleBtn.vue'

export default {
  name: 'SelfGroupMeeting',
  components: {
    Footer,
    CircleBtn
  },
  data: () => ({
    category: [
      '우울', '불안', '성격문제', '애착', 
      '대인기피', '분노조절', '자존감', 
      '중독', '대인관계', '부부', '가족상담',
    ],
    dummy: ['#우울 #불안', '#성격문제', '#부부 #가족상담', '#분노조절 #대인기피', '#중독 #우울']
  }),

}
</script>

<style>

</style>