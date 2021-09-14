import React, { Component } from 'react';
import { Redirect } from 'react-router-dom';
import '../../App.css';

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
                    //   console.log(data);  //equal to user.java
                    return { data }
                }
            })
            .catch(error => {
                console.error('There was an error!', error);
                return { errorMessage: error.toString() };
            })
    )
}

export default class LoginForm extends Component {
    constructor(props) {
        super(props)

        this.state = {
            redirect: null,
            username: '',
            password: '',
            errors: { username: '', password: '' }
        }
    }

    handleValidation = () => {
        let isValid = true;
        const { username, password } = this.state;
        let errors = { username: '', password: '' };

        if (!username) {
            errors.username = 'Username cannot be empty!';
            isValid = false;
        }

        if (!password) {
            errors.password = 'Password cannot be empty!';
            isValid = false;
        }

        this.setState({ errors });
        return isValid;
    }

    handleSubmit = async event => {
        if (this.handleValidation()) {
            //alert(`${this.state.username} ${this.state.password}`)
            const username = this.state.username;
            const password = this.state.password;
            event.preventDefault(); //will prevent page from refreshing after clicking ok on alert
            const user = await loginUser({
                username,
                password
            });
            console.log(user)
            if (user.data == null) {
                console.log("loading");
            } else {
                //console.log(user.data.role);
                if (user.data.role == "BANK_ADMIN") {
                    this.setState({ redirect: "/home2" });
                } else if (user.data.role == "ACCOUNT_HOLDER") {
                    this.setState({ redirect: "/home1" });
                }
            }
        }
    }

    handleUnlock = (event) => {
        this.setState({ redirect: "/unlockaccount" });
        event.preventDefault()
    }

    handleNewUser = (event) => {
        this.setState({ redirect: "/registerpage" });
        event.preventDefault();
    }

    //   handleNameChange = (event) => { 
    //       this.setState({
    //           username: event.currentTarget.value
    //       })
    //   }

    //   handlePasswordChange = (event) => { 
    //     this.setState({
    //         password: event.target.value
    //     })
    // }

    handleSecretQuestionChange = (event) => {
        this.setState({
            secret_question: event.target.value
        })
    }

    handleSecretAnswerChange = (event) => {
        this.setState({
            secret_answer: event.target.value
        })
    }

    render() {
        if (this.state.redirect) {
            return <Redirect to={this.state.redirect} />
        }

        const { errors } = this.state;

        return (
            <div className="loginForm">
                <form onSubmit={this.handleSubmit}>
                    <div className="loginInputs">
                        <div>
                            <br />
                            <label>Username : </label>
                            <input type="text" value={this.state.username}
                                /*onChange={this.state.username}*/
                                onChange={(e) => this.setState({ username: e.target.value })} required />
                            {errors.username != '' && <span style={{ color: "red" }}>{this.state.errors.username}</span>}
                        </div>
                        <div>
                            <label>Password : </label>
                            <input type="password" value={this.state.password}
                                onChange={(e) => this.setState({ password: e.target.value })} required />
                            {errors.password != '' && <span style={{ color: "red" }}>{this.state.errors.password}</span>}
                        </div>
                    </div>
                    <br />
                    <button id='loginbtn' onClick={this.handleSubmit}>Login</button>
                    <br />
                    <button id='inputbtn' onClick={this.handleUnlock}>Unlock Account</button>
                    <br />
                    <button id='registerbtn' onClick={this.handleNewUser}>Register New User</button>
                </form>
            </div>
        )
    }
}

