import './App.css';
import {HashRouter, Link, Route} from 'react-router-dom'
import {About} from "./About";
import {observer} from "mobx-react-lite";
import {Giraffes} from "./viewmodel/GiraffeStore";


function App(store = Giraffes) {
  return (
      <HashRouter>
    <div className="App">
      <header className="App-header">
          <h1>Giraf Butikken</h1>
        <Link to={"/about/hr.bæver"}>Bævere!</Link>
        <Route path={"/about/:id"} component={About} >
        </Route>
          {store.giraffes?.map((giraffe)=>{
              return <div key={giraffe}>{giraffe}</div>
          })}
          <button onClick={()=>store.addGiraffe("Marius")}>Add Giraffe!</button>

      </header>
    </div>
      </HashRouter>
  );
}

export default observer(App);
