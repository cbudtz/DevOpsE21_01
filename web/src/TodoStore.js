import {makeAutoObservable} from "mobx";
import {v4} from "uuid"

class TodoStore {
    todos = [{name:"skift pære", id:"1"}]


    constructor(props) {
        makeAutoObservable(this,{},{autoBind:true});
    }

    addTodo(todo){
        todo.id = v4();
        this.todos.push(todo)
    }

}
export const Todos = new TodoStore();