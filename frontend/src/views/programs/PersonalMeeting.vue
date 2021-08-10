<template>  
  <v-container>
    <BackBtn/>
    <h1 class="d-flex justify-center">Personal Counseling</h1>
  
    <main class="page-content">
      <v-col
        v-for="n in 12"
        :key="n"
        cols="12"
      >
        <div class="card">
          <div class="content">
            <h2 class="title">To The Beach</h2>
            <p class="copy">Plan your next beach trip with these fabulous destinations</p>
            <button class="btn">View Trips</button>
          </div>
        </div>
      </v-col>

      <!-- <div class="card">
        <div class="content">
          <h2 class="title">To The Beach</h2>
          <p class="copy">Plan your next beach trip with these fabulous destinations</p>
          <button class="btn">View Trips</button>
        </div>
      </div>
      <div class="card">
        <div class="content">
          <h2 class="title">Desert Destinations</h2>
          <p class="copy">It's the desert you've always dreamed of</p>
          <button class="btn">Book Now</button>
        </div>
      </div>
      <div class="card">
        <div class="content">
          <h2 class="title">Explore The Galaxy</h2>
          <p class="copy">Seriously, straight up, just blast off into outer space today</p>
          <button class="btn">Book Now</button>
        </div>
      </div> -->
    </main>
  </v-container>
  <!-- <v-container>
    <h1>Personal Counseling</h1>
    <BackBtn/>
    전문가 정보
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
  </v-container> -->
</template>

<script>
import BackBtn from '@/components/BackBtn.vue'

export default {
  name: 'PersonalMeeting',
  components: {
    BackBtn,
  },
}
</script>

<style scoped>
@import '../css/Card.css';
</style>