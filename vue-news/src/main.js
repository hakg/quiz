import { createApp } from 'vue';
import App from './App.vue';
import router from './routes/index.js'; // routes/index.js를 가져옵니다.
import {store} from '@/store'

const app = createApp(App);

app.use(router); // 애플리케이션에 라우터를 추가합니다.

app.use(store);

app.mount('#app');
