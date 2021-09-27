import {makeAutoObservable, runInAction} from "mobx";

const baseUrl = process.env.NODE_ENV === 'development' ?  "http://localhost:8080/":""; //Check if dev environment

class GiraffeStore {
    giraffes = []


    constructor(props) {
        makeAutoObservable(this,{},{autoBind:true});
        this.fetchGiraffes();
    }

    fetchGiraffes (){
        fetch(baseUrl + "api/giraffes").then(
            (response)=> response.json().then(
                (json)=> runInAction(()=>this.giraffes=json)
            )
        )
    }


    addGiraffe(name){
        //todo.id = v4();
        this.giraffes.push(name)
    }
}
export const Giraffes = new GiraffeStore();