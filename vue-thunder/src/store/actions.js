import { massmailInfoList } from "@/api";

export default {
    FETCH_MASSMAIL({commit}) {
        massmailInfoList()
            .then(({data}) => {
            commit('SET_MASSMAIL', data);
            })
            .catch(error => {
                console.log(error);
            });
    }
}