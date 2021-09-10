import './App.css';
import './index.css';
import React, {useState} from 'react';
import {Route, Switch} from 'react-router-dom';
import LoginPage from './pages/LoginPage';
import HomePage from './pages/HomePage';
import UnlockPage from './pages/UnlockPage';

function App() {
  const [token, setToken] = useState();

  if(!token) {  //without a token user cannot go to other pages before sucessfully login
    return <LoginPage setToken={setToken} />
  }
  
  return (
    <Switch>
        {/* <Route exact path="/" component={LoginPage}/> */}
        <Route path="/home" component={HomePage}/>
        <Route path="/unlockaccount" component={UnlockPage}/>
    </Switch>
  );
}

export default App;
