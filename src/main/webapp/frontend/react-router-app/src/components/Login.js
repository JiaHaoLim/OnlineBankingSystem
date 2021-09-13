import React, {useState} from 'react';
import PropTypes from 'prop-types';

import '../App.css';

async function loginUser(credentials) {
  console.log(credentials);
    // const [data, setData] = useState(null);
    // const [loading, setLoading] = useState(true);
    // const [error, setError] = useState(null);

    // useEffect(() => { 
    //   axios({
    //       method: "post",
    //       url: "http://localhost:7777/login",
    //       headers: {'Content-Type': 'application/json'},
    //       body: JSON.stringify(credentials)
    //   }) 
    //     .then((data) => { 
    //       setData(data.json); 
    //     }) 
    //     .catch((error) => { 
    //       console.error("Error fetching data: ", error); 
    //       setError(error); 
    //     }) 
    //     .finally(() => { 
    //       setLoading(false); 
    //     }); 
    // }, []); 

    // if (loading) return "Loading...";
    // if (error) return "Error!";
    // if (data) return data.id;

    // return fetch('http://localhost:9090/login', {
    //   method: 'POST',
    //   headers: {
    //     'Content-Type': 'application/json'
    //   },
    //   body: JSON.stringify(credentials)
    // })
    //   .then(data => data.json())

    // POST request using fetch with error handling
    const requestOptions = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(credentials),
    };

  fetch('http://localhost:9090/login', requestOptions)
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
              return { userId: data.id }
          }
      })
      .catch(error => {
          console.error('There was an error!', error);
          return { errorMessage: error.toString() };
      });
    
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