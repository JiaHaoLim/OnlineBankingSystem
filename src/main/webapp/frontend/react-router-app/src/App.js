import './App.css';
import './index.css';
import React, {useState} from 'react';
import {Route, Switch} from 'react-router-dom';
import Login from './components/Login';
import LoginPage from './pages/LoginPage';
import HomePage from './pages/HomePage';
import UnlockPage from './pages/UnlockPage';
import RegisterPage from './pages/RegisterPage';

function App() {
  // const [token, setToken] = useState();

  // if(!token) {  //without a token user cannot go to other pages before sucessfully login
  //   return <Login setToken={setToken} />
  // }
  
  return (
    <div className="App">
      <Switch>
          <Route exact path="/" component={LoginPage}/>
          <Route path="/home" component={HomePage}/>
          <Route path="/unlockaccount" component={UnlockPage}/>
          <Route path="/registerpage" component={RegisterPage}/>
      </Switch>
    </div>
  );
}

export default App;
