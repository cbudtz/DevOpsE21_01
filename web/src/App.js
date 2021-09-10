import './App.css';
import {Link, Route} from 'react-router-dom'
import {About} from "./About";
import {observer} from "mobx-react-lite";
import {Todos} from "./TodoStore";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Link to={"/about/hr.bæver"}>Bævere!</Link>
        <Route path={"/about/:id"} component={About} >
        </Route>
          {Todos.todos.map((todo)=>{
              return <div key={todo.id}>{todo.id} : {todo.name}</div>
          })}
          <button onClick={()=>Todos.addTodo({name: "Flere bævere"})}>Add todo!</button>

      </header>
    </div>
  );
}

export default observer(App);
