import { createApp } from 'vue'
import App from './App.vue';
import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import router from './routes/index.js';
import {store} from "@/store";

const app = createApp(App);

app.use(router);
app.use(store);
app.mount('#app');
