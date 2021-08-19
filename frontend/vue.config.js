const path = require("path")
// Vue3 관련 설정 파일
module.exports = {
  devServer: {
    // https://mc500.tistory.com/196 Invalid Host header 임시방편
    disableHostCheck: true,
    https: true,
    port: 443,
    open: true,
    proxy: {
      '/api/v1': {
        target: 'https://localhost:8443/'
      }
    },
    historyApiFallback: true,
    hot: true
  },

  lintOnSave: false,
  // outputDir: '../backend/src/main/resources/dist',
  outputDir: path.resolve(__dirname, "./dist"),

  transpileDependencies: [
    'vuetify'
  ]
}
