import './App.css';
import './index.css';
import React, {useState} from 'react';
import {Route, Switch, Redirect} from 'react-router-dom';
import Login from './components/Login';
import LoginPage from './pages/LoginPage';
import HomePageAcHolder from './pages/HomePageAcHolder';
import HomePageAdmin from './pages/HomePageAdmin';
import UnlockPage from './pages/UnlockPage';
import RegisterPage from './pages/RegisterPage';

function App() {
  const [token, setToken] = useState();

  if(!token) {  //without a token user cannot go to other pages before sucessfully login
    // return <LoginPage setToken={setToken}/>
    return <Login setToken={setToken}/>
  }

  return (
    <div className="App">
      <Switch>
          <Route path="/home1" component={HomePageAcHolder}/>
          <Route path="/home2" component={HomePageAdmin}/>
          <Route path="/unlockaccount" component={UnlockPage}/>
          <Route path="/registerpage" component={RegisterPage}/>
      </Switch>
    </div>
  );
}

export default App;
