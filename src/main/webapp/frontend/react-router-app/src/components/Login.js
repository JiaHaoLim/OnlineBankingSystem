import React, {useState} from 'react';
import PropTypes from 'prop-types';

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
    setToken(token);
    
    if (token.data.role == "ACCOUNT_HOLDER") {
        return <HomePageAcHolder user={token}/>
    } else if (token.data.role == "BANK_ADMIN") {
        return <HomePageAdmin user={token}/>
    }
  }

  return(
    <div className="login-wrapper">
      <h1>Please Log In</h1>
      <form onSubmit={handleSubmit}>
        <label>
          <p>Username</p>
          <input type="text" onChange={e => setUserName(e.target.value)}/>
        </label>
        <label>
          <p>Password</p>
          <input type="password" onChange={e => setPassword(e.target.value)}/>
        </label>
        <div>
          <button type="submit">Submit</button>
        </div>
      </form>
    </div>
  )
}

Login.propTypes = {
  setToken: PropTypes.func.isRequired
}