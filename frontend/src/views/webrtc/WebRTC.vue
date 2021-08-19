<template>
  <div id="main-container" class="container">
    <div id="join" v-if="!session">
      <div id="join-dialog" class="jumbotron vertical-center">
        <h1>Join a video session</h1>
        <div class="form-group">
          <p>
            <label>Participant</label>
            <input v-model="myUserName" class="form-control" type="text" required>
          </p>
          <h2>
            {{ programName }}
          </h2>
          <!-- <p>
            <label>Session</label>
            <input v-model="mySessionId" class="form-control" type="text" required>
          </p> -->
          <p class="text-center">
            <button class="btn btn-lg btn-success" @click="joinSession()">Join!</button>
          </p>
        </div>
      </div>
    </div>
    
    <div id="session" v-if="session">
      <div id="session-header" class="d-flex justify-space-between">

        <h1 id="session-title">{{ mySessionId }}</h1>
        <div class="d-flex justify-center align-center">
          <BottomBar :publisher="publisher" @leaveSession="leaveSession" @onFilter="onFilter" @offFilter="offFilter"/>
        </div>
      </div>
      <!-- <v-container> -->
      <v-row no-gutters>

        <v-col cols="9">
          <v-row>
            <v-col
              v-for="n in 1"
              :key="n"
              cols="12"
              sm="4"
            >
              <!-- 자기자신 보여주는 비디오 -->
              <!-- <div id="main-video" class="col-md-6">
                <user-video :stream-manager="mainStreamManager"/>
              </div> -->
              <!-- 세션 참여자 모두를 보여줌 -->
              <div id="video-container" class="col-md-6">
                <UserVideo :stream-manager="publisher" @click.native="updateMainVideoStreamManager(publisher)"/>
                <UserVideo v-for="sub in subscribers" :key="sub.stream.connection.connectionId" :stream-manager="sub"
                  @click.native="updateMainVideoStreamManager(sub)" />
                <!-- <button v-for="sub in subscribers" :key="sub.stream.connection.connectionId" :stream-manager="sub" @click=subscriber.subscribeToAudio(audioEnabled)></button> -->
              </div>
            </v-col>
          </v-row>
        </v-col>

        <v-col cols="3">
          <UserChat :chatLog="chatLog" @sendMessage="sendMessage"/>
        </v-col>

      </v-row>

        <!-- <v-row no-gutters>
          <BottomBar :publisher="publisher" @onFilter="onFilter" @offFilter="offFilter"/>
        </v-row> -->
      <!-- </v-container> -->
    </div>
  </div>
</template>

<script>
  import axios from 'axios'
  import { OpenVidu } from 'openvidu-browser'
  import UserVideo from '@/components/videomeeting/UserVideo'
  import BottomBar from '@/components/videomeeting/BottomBar'
  import UserChat from '@/components/videomeeting/UserChat'

  axios.defaults.headers.post['Content-Type'] = 'application/json';

  // const OPENVIDU_SERVER_URL = "https://" + location.hostname + ":4443";
  // 한건 로컬 주소
  // const OPENVIDU_SERVER_URL = "https://192.168.0.11:4443";
  // EC2 public ipV4
  const OPENVIDU_SERVER_URL = "https://i5b208.p.ssafy.io:8444";
  const OPENVIDU_SERVER_SECRET = "MY_SECRET";

  export default {
    name: 'WebRTC.vue',
    
    props: {
      programName: {
        type: String,
        default : ''
      },
      programId: {
        type: String,
      }
    },

    components: {
      UserVideo,
      UserChat,
      BottomBar,
    },

    data() {
      return {
        OV: undefined,
        session: undefined,
        mainStreamManager: undefined,
        publisher: undefined,
        subscribers: [],

        mySessionId: 'SessionA',
        myUserName: 'Participant' + Math.floor(Math.random() * 100),

        // chat
        chatLog: [],
      }
    },

    methods: {
      joinSession() {
        // --- Get an OpenVidu object ---
        this.OV = new OpenVidu();

        // --- Init a session ---
        this.session = this.OV.initSession();

        // --- Specify the actions when events take place in the session ---

        // On every new Stream received...
        this.session.on('streamCreated', ({ stream }) => {
          const subscriber = this.session.subscribe(stream);
          this.subscribers.push(subscriber);
        });

        // On every Stream destroyed...
        this.session.on('streamDestroyed', ({ stream }) => {
          const index = this.subscribers.indexOf(stream.streamManager, 0);
          if (index >= 0) {
            this.subscribers.splice(index, 1);
          }
        });

        // On every asynchronous exception...
        this.session.on('exception', ({ exception }) => {
          console.warn(exception);
        });

        // Chat 수신
        this.session.on('signal', (event) => {
          this.chatLog.push([event.data, JSON.parse(event.from.data)])
          console.log("chat 로그",this.chatLog)
          console.log("이벤트", event)
          console.log("이벤트.from.데이터", typeof(JSON.parse(event.from.data)))
        })
        
        // Speech Detection 근데 이게 publisher만 된다는데 여러 유저랑 확인해서 해봐야 할 듯 한데
        this.session.on('publisherStartSpeaking', (event) => {
          console.log(event)
          console.log('User ' + event.connection.data + ' start speaking');
          // this.$store.dispatch('startSpeaking')
          this.$store.dispatch('addSpeaker', JSON.parse(event.connection.data).clientData)
        });

        // Speech Stop Detection
        this.session.on('publisherStopSpeaking', (event) => {
          console.log('User ' + event.connection.connectionId + ' stop speaking');
          // this.$store.dispatch('stopSpeaking')
          this.$store.dispatch('removeSpeaker', JSON.parse(event.connection.data).clientData)
        });

        // --- Connect to the session with a valid user token ---

        // 'getToken' method is simulating what your server-side should do.
        // 'token' parameter should be retrieved and returned by your own backend
        this.getToken(this.mySessionId).then(token => {
          this.session.connect(token, { clientData: this.myUserName })
            .then(() => {

              // --- Get your own camera stream with the desired properties ---
              console.log("got a token!!!", token)
              console.log("세션상태확인", this.session)
              let publisher = this.OV.initPublisher(undefined, {
                audioSource: undefined, // The source of audio. If undefined default microphone
                videoSource: undefined, // The source of video. If undefined default webcam
                publishAudio: true,  	// Whether you want to start publishing with your audio unmuted or not
                publishVideo: true,  	// Whether you want to start publishing with your video enabled or not
                resolution: '640x480',  // The resolution of your video
                frameRate: 30,			// The frame rate of your video
                insertMode: 'APPEND',	// How the video is inserted in the target element 'video-container'
                mirror: true,       	// Whether to mirror your local video or not
              });

              this.mainStreamManager = publisher;
              this.publisher = publisher;

              // --- Publish your stream ---
              this.session.publish(this.publisher);
            })
            .catch(error => {
              console.log('There was an error connecting to the session:', error.code, error.message);
            });
        });
        window.addEventListener('beforeunload', this.leaveSession)
      },

      leaveSession() {
        // --- Leave the session by calling 'disconnect' method over the Session object ---
        if (this.session) this.session.disconnect();

        this.session = undefined;
        this.mainStreamManager = undefined;
        this.publisher = undefined;
        this.subscribers = [];
        this.OV = undefined;

        window.removeEventListener('beforeunload', this.leaveSession);
      },

      updateMainVideoStreamManager(stream) {
        console.log("비디오 클릭", this.publisher)
        if (this.mainStreamManager === stream) return;
        this.mainStreamManager = stream;
        console.log("bye")
      },

      // filter 적용 test Ubuntu 18.04 Version FaceOverlayFilter 사용 불가
      onFilter() {
        // this.publisher.stream.applyFilter("GStreamerFilter", { "command": "textoverlay text='Embedded text' valignment=top halignment=right font-desc='Cantarell 25'" })
        this.publisher.stream.applyFilter("GStreamerFilter", { "command": "gdkpixbufoverlay location=/tmp/312341-middle.png offset-x=10 offset-y=10 overlay-height=50 overlay-width=50" })
        // EC2 안에 있는 hat 파일 이름 다름 주의
        // this.publisher.stream.applyFilter("GStreamerFilter", { "command": "gdkpixbufoverlay location=/tmp/santa-hat-transparent-11549385190r3okqt8gir.png offset-x=10 offset-y=10 overlay-height=50 overlay-width=50" })
          .then(() => {
            console.log("Video filltered!");
          })
          .catch(error => {
            console.error(error);
          });
      },

      // filter off
      offFilter() {
        this.publisher.stream.removeFilter()
          .then(() => {
            console.log("Filter removed")
          })
          .catch(err => {
            console.error(err)
          })
      },

      // chat message 발신
      sendMessage(msg) {
        this.session.signal({
          data: msg,  // Any string (optional)
          to: [],  // Array of Connection objects (optional. Broadcast to everyone if empty)
        })
          .then(() => {
            console.log('Message successfully sent');
          })
          .catch(error => {
            console.error(error);
          });
      },

      /**
       * --------------------------
       * SERVER-SIDE RESPONSIBILITY
       * --------------------------
       * These methods retrieve the mandatory user token from OpenVidu Server.
       * This behavior MUST BE IN YOUR SERVER-SIDE IN PRODUCTION (by using
       * the API REST, openvidu-java-client or openvidu-node-client):
       *   1) Initialize a Session in OpenVidu Server	(POST /openvidu/api/sessions)
       *   2) Create a Connection in OpenVidu Server (POST /openvidu/api/sessions/<SESSION_ID>/connection)
       *   3) The Connection.token must be consumed in Session.connect() method
       */

      getToken(mySessionId) {
        return this.createSession(mySessionId).then(sessionId => this.createToken(sessionId));
      },

      // See https://docs.openvidu.io/en/stable/reference-docs/REST-API/#post-openviduapisessions
      createSession(sessionId) {
        return new Promise((resolve, reject) => {
          axios
            .post(`${OPENVIDU_SERVER_URL}/openvidu/api/sessions`, JSON.stringify({
              customSessionId: sessionId,
            }), {
              auth: {
                username: 'OPENVIDUAPP',
                password: OPENVIDU_SERVER_SECRET,
              },
            })
            .then(response => response.data)
            .then(data => resolve(data.id))
            .catch(error => {
              if (error.response.status === 409) {
                resolve(sessionId);
              } else {
                console.warn(`No connection to OpenVidu Server. This may be a certificate error at ${OPENVIDU_SERVER_URL}`);
                if (window.confirm(`No connection to OpenVidu Server. This may be a certificate error at ${OPENVIDU_SERVER_URL}\n\nClick OK to navigate and accept it. If no certificate warning is shown, then check that your OpenVidu Server is up and running at "${OPENVIDU_SERVER_URL}"`)) {
                  location.assign(`${OPENVIDU_SERVER_URL}/accept-certificate`);
                }
                reject(error.response);
              }
            });
        });
      },

      // See https://docs.openvidu.io/en/stable/reference-docs/REST-API/#post-openviduapisessionsltsession_idgtconnection
      createToken(sessionId) {
        return new Promise((resolve, reject) => {
          axios
            .post(`${OPENVIDU_SERVER_URL}/openvidu/api/sessions/${sessionId}/connection`, {
              // filter 사용하기 위해 JSON에 kurentoOptions를 날린다.
              "kurentoOptions": {
                "allowedFilters": ["GStreamerFilter", "FaceOverlayFilter"]
              }
            }, {
              auth: {
                username: 'OPENVIDUAPP',
                password: OPENVIDU_SERVER_SECRET,
              },
            })
            // res.data 확인하는곳
            .then(response => response.data)
            .then(data => resolve(data.token))
            .catch(error => reject(error.response));
        });
      },
    },
    mounted: function () {
      this.mySessionId = this.programId
      },
    destroyed: function () {
      leaveSession()
    }
  }
</script>
