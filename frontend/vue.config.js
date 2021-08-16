
// Vue3 관련 설정 파일
module.exports = {
  devServer: {
    // https://mc500.tistory.com/196 Invalid Host header 임시방편
    disableHostCheck: true,
    https: true,
    port: 8083,
    open: true,
    proxy: {
      '/api/v1': {
        target: 'https://i5b208.p.ssafy.io:8443/'
      }
    },
    historyApiFallback: true,
    hot: true
  },

  lintOnSave: false,
  outputDir: '../backend/src/main/resources/dist',

  transpileDependencies: [
    'vuetify'
  ]
}
