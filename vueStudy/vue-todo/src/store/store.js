import Vue from 'vue'
import Vuex from 'vuex'
import * as getters from './getters'
import * as mutations from './mutations'

Vue.use(Vuex);

const storage = {
    fetch() {
        const arr = [];
        //인스턴스가 생성 되자마자 실행되는 라이프 사이클
        if(localStorage.length > 0) {
            for(let i = 0; i < localStorage.length; i++) {
                if(localStorage.key(i) !== 'loglevel:webpack-dev-server') {
        
                    arr.push(JSON.parse(localStorage.getItem(localStorage.key(i))));
        
                }
            }
        }
        return arr;
    },
};

export const store = new Vuex.Store({
    state: {
        todoItems : storage.fetch()
    },
    getters,
    mutations
});