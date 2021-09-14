/*
import React, { useState } from 'react';
import { Redirect } from 'react-router-dom';
import PropTypes from 'prop-types';

import '../App.css';

async function loginUser(credentials) {
    console.log(credentials);
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

export default function LoginForm({setToken}) {
    const [username, setUserName] = useState();
    const [password, setPassword] = useState();

    const handleSubmit = async e => {
        e.preventDefault();
        const token = await loginUser({
          username,
          password
        });
        console.log(token);
        setToken(token);
    }

    handleUnlock = (event) => {
        this.setState({redirect:"/unlockaccount"});
        event.preventDefault()
    }
    
    handleNewUser = (event) => {
        this.setState({redirect:"/registerpage"});
        event.preventDefault();
    }
    
    handleNameChange = (event) => { 
        this.setState({
            name: event.target.value
        })
    }
    
    handleSecretQuestionChange = (event) => {
        this.setState({
            secret_question: event.target.value
        })
    }
    
    handleSecretAnswerChange = (event) => {
        this.setState({
            secret_answer: event.target.value
        })
    };

    return (
        <div className="loginForm">
            <form onSubmit={this.handleSubmit}>
                <div className="loginInputs">
                    <div>
                        <br/>
                        <label>Username : </label>
                        <input type="text" value={this.state.username}
                        onChange={e => setUserName(e.target.value)} />
                    </div>
                    <div>
                        <label>Password : </label>
                        <input type="text" value={this.state.password}
                        onChange={e => setPassword(e.target.value)} />
                    </div>
                </div>
                <br/>
                <button id='loginbtn' onClick={this.handleSubmit}>Login</button>
                <br/>
                <button id='inputbtn' onClick={this.handleUnlock}>Unlock Account</button>
                <br/>
                <button id='registerbtn' onClick={this.handleNewUser}>Register New User</button>
            </form>
        </div>
    )    
    
}

LoginForm.propTypes = {
    setToken: PropTypes.func.isRequired
}*/