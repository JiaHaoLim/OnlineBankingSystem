import './App.css';
import './index.css';
import React from 'react';
import {Route, Switch} from 'react-router-dom';
import Login from './components/App/Login';
import HomePageAcHolder from './pages/HomePageAcHolder';
import HomePageAdmin from './pages/HomePageAdmin';
import LoginPage from './pages/LoginPage';
import UnlockPage from './pages/UnlockPage';
import RegisterPage from './pages/RegisterPage';
import useToken from './components/App/useToken';

function setToken(userToken) {
    sessionStorage.setItem('token', JSON.stringify(userToken));
}

function getToken() {
    const tokenString = sessionStorage.getItem('token');
    const userToken = JSON.parse(tokenString);
    return userToken?.token
}

function App() {
  //const {token, setToken} = useToken();
  //const token = getToken();

  //if(!token) {  //without a token user cannot go to other pages before sucessfully login
    // return <LoginPage setToken={setToken}/>
    //return <Login setToken={setToken}/>
  //}

  return (
    <div className="App">
      <Switch>
          <Route exact path="/" component={LoginPage}/>
          <Route path="/home1" component={HomePageAcHolder}/>
          <Route path="/home2" component={HomePageAdmin}/>
          <Route path="/unlockaccount" component={UnlockPage}/>
          <Route path="/registerpage" component={RegisterPage}/>
      </Switch>
    </div>
  );
}

export default App;
