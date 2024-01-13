import { createRouter, createWebHistory } from 'vue-router';
import MassmailInfoView from "@/views/MassmailInfoView.vue";

// 라우트 정의
const routes = [
    {
        //path: url 주소
        path: '/massmail/list',
        //component: url 주소로 갔을 때 표시될 컴포넌트
        component: MassmailInfoView
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;