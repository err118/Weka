import Vue from 'vue'
import App from './App'


Vue.config.productionTip = false
App.mpType = 'app'

const app = new Vue(App)
app.$mount()

export default {
  // 这个字段走 app.json
  config: {
    // 页面前带有 ^ 符号的，会被编译成首页，其他页面可以选填，我们会自动把 webpack entry 里面的入口页面加进去
    pages: ['^pages/card/main','pages/wallet/main', 'pages/me/main'],
    window: {
      backgroundTextStyle: 'light',
      navigationBarBackgroundColor: '#1296db',
      navigationBarTitleText: '微卡',
      navigationBarTextStyle: 'white'
    },
    tabBar: {
      color: "#bfbfbf",
      selectedColor: "#1296db",
      backgroundColor: "#fff",
      borderStyle: "#a8a8a8",
      list: [
        {
          pagePath: "pages/card/main",
          iconPath: "static/images/card.png",
          selectedIconPath: "static/images/card-active.png",
          color:"white",
          text: "卡包"
        },
        {
          pagePath: "pages/wallet/main",
          iconPath: "static/images/wallet.png",
          selectedIconPath: "static/images/wallet-active.png",
          text: "钱包"
        },
        {
          pagePath: "pages/me/main",
          iconPath: "static/images/me.png",
          selectedIconPath: "static/images/me-active.png",
          text: "我的"
        }
      ]
    }
  }
}
