import Vuex from 'vuex';
import actions from "@/store/actions";
import mutations from "@/store/mutations";
import {massmailInfoList} from "@/api";

export const store = new Vuex.Store({
    state: {
        items: [],
        selectedItems: []
    },
    getters: { //state 값을 접근하는 속성이자 computed() 처럼 미리 연산된 값을 접근하는 속성

    },
    mutations: {
        SET_ITEMS(state, items) {
            state.items = items;
        }
    },
    actions: {
        FETCH_ITEMS({commit}) {
            massmailInfoList()
                .then(({data}) => {
                    console.log(data.items);
                    commit('SET_ITEMS', data.items);
                })
                .catch(error => {
                    console.log(error);
                });
        }
    }
});