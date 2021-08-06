<template>
  <v-container>
    <h1>Personal Counseling</h1>
    <!-- 전문가 정보 -->
    <v-item-group>
      <v-container>
        <v-row>
          <v-col
            v-for="n in 12"
            :key="n"
            cols="12"
            md="6"
          >
            <v-item>
              <v-card
                class="d-flex flex-column justify-center"
                height="250"
              >
                <v-card-title>
                  전문가 이름
                </v-card-title>

                <v-card-subtitle>
                  전문 분야
                </v-card-subtitle>

                <v-card-text>
                  경력 사항
                </v-card-text>
                
                <v-card-text>
                  상담 소개
                </v-card-text>

                <v-card-actions>
                  <v-spacer></v-spacer>

                  <v-btn>
                    신청하기                    
                  </v-btn>

                </v-card-actions>
              </v-card>
            </v-item>
          </v-col>          
        </v-row>
      </v-container>
    </v-item-group>
  </v-container>
</template>

<script>
export default {
  name: 'PersonalMeeting',
}
</script>

<style>

</style>