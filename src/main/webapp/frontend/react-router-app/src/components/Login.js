import React, {useState} from 'react';
import {Route, Redirect} from 'react-router-dom';
import PropTypes from 'prop-types';
import Footer from './Footer';

import '../App.css';
import HomePageAcHolder from '../pages/HomePageAcHolder';
import HomePageAdmin from '../pages/HomePageAdmin';

async function loginUser(credentials) {
  // console.log(credentials);
  // POST request using fetch with error handling
  const requestOptions = {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(credentials),
  };

  return (
    fetch('http://localhost:7777/login', requestOptions)
    .then(async response => {
        const isJson = response.headers.get('content-type')?.includes('application/json');
        const data = isJson && await response.json();

        // check for error response
        if (!response.ok) {
            // get error message from body or default to response status
            const error = (data && data.message) || response.status;
            return Promise.reject(error);
        } else {
            console.log(data);  //equal to user.java
            return {data}
        }
    })
    .catch(error => {
        console.error('There was an error!', error);
        return { errorMessage: error.toString() };
    })
  )  
}

export default function Login({ setToken }) {
  const [username, setUserName] = useState();
  const [password, setPassword] = useState();
  
  const handleSubmit = async e => {
    e.preventDefault();
    const token = await loginUser({
      username,
      password
    });
    console.log(token);
    console.log(token.data.role);
    setToken(token);

    if (token.data.role == "ACCOUNT_HOLDER") {
        // return <HomePageAcHolder user={token}/>
        // <Redirect to={{
        //   pathname: '/home1',
        //   state: { id: '0' }
        // }}/>
        <Route path="/home1" component={HomePageAcHolder}/>
    } else if (token.data.role == "BANK_ADMIN") {
        return <HomePageAdmin user={token}/>
    }
  }

  const handleUnlock = (event) => {
    this.setState({redirect:"/unlockaccount"});
    event.preventDefault()
  }

  const handleNewUser = (event) => {
      this.setState({redirect:"/registerpage"});
      event.preventDefault();
  }

  // handleSecretQuestionChange = (event) => {
  //     this.setState({
  //         secret_question: event.target.value
  //     })
  // }

  // handleSecretAnswerChange = (event) => {
  //     this.setState({
  //         secret_answer: event.target.value
  //     })
  // };

  return(
    <div>
      <h3 className='loginHeader'>Banking System Login</h3>
      <div className="loginForm">
            <form onSubmit={handleSubmit}>
                <div className="loginInputs">
                    <div>
                        <br/>
                        <label>Username : </label>
                        <input type="text" 
                        onChange={e => setUserName(e.target.value)} />
                    </div>
                    <div>
                        <label>Password : </label>
                        <input type="password" 
                        onChange={e => setPassword(e.target.value)} />
                    </div>
                </div>
                <br/>
                <button id='loginbtn' onClick={handleSubmit}>Login</button>
                <br/>
                <button id='inputbtn' onClick={handleUnlock}>Unlock Account</button>
                <br/>
                <button id='registerbtn' onClick={handleNewUser}>Register New User</button>
            </form>
        </div>
      <Footer/>
    </div>
  )
}

Login.propTypes = {
  setToken: PropTypes.func.isRequired
}