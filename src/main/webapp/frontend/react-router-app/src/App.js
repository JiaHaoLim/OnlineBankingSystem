import './App.css';
import './index.css';
import {Route, Switch} from 'react-router-dom';
import LoginPage from './pages/LoginPage';
import HomePage from './pages/HomePage';
import UnlockPage from './pages/UnlockPage';

function App() {
  return (
    <div className="App">
      <Switch>
          <Route exact path="/" component={LoginPage}/>
          <Route path="/home" component={HomePage}/>
          <Route path="/unlockaccount" component={UnlockPage}/>
      </Switch>
    </div>
  );
}

export default App;
