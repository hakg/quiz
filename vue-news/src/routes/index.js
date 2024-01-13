import { createRouter, createWebHistory } from 'vue-router';
import NewsView from '../views/NewsView.vue';
import AskView from '../views/AskView.vue';
import JobsView from '../views/JobsView.vue';
import UserView from '../views/UserView';
import ItemView from "@/views/itemView.vue";


// 라우트 정의
const routes = [
    {
        path: '/',
        redirect: '/news'
    },
    {
        //path: url 주소
        path: '/news',
        //component: url 주소로 갔을 때 표시될 컴포넌트
        component: NewsView
    },
    {
        path: '/ask',
        component: AskView
    },
    {
        path: '/jobs',
        component: JobsView
    },
    {
        path : '/user/:id',
        component: UserView
    },
    {
        path: '/item/:id',
        component: ItemView
    }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;

