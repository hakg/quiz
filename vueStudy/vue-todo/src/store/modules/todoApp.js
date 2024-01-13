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


const state = {
    todoItems : storage.fetch()
};

const getters = {
    storedTodoItems(state) {
        return state.todoItems;
    }
};

const mutations = {

 addOneItem(state, todoItem) {
    const obj = {completed: false, item: todoItem};
    //저장하는 로직
    localStorage.setItem(todoItem, JSON.stringify(obj));
    state.todoItems.push(obj);
},

 removeOneItem(state, payload) {
    localStorage.removeItem(payload.todoItem.item);
    state.todoItems.splice(payload.index,1);
},

 toggleOneItem(state, payload) {
    state.todoItems[payload.index].completed = !state.todoItems[payload.index].completed;
    localStorage.removeItem(payload.todoItem.item);
    localStorage.setItem(payload.todoItem.item, JSON.stringify(payload.todoItem))
},

 clearAllItem(state) {
    localStorage.clear();
    state.todoItems = [];
}

};

export default{
    state,
    getters,
    mutations
}