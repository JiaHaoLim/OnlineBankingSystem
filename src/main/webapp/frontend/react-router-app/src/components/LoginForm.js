import React, { Component } from 'react';
import { Redirect } from 'react-router-dom';
import '../App.css';

export class LoginForm extends Component {
    constructor(props) {
        super(props)

        this.state={
            redirect: null,
            username: '',
            password:'',
        }
    }

    handleSubmit = (event) => {
        //Todo: Add error handling & lock account msg 
        alert(`${this.state.username} ${this.state.password}`)
        //Assume it is sucessful verification
        //Check the user type as well
        this.setState({redirect:"/home"});
        //event.preventDefault() will prevent page from refreshing after clicking ok on alert
        event.preventDefault()
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

    handleUsernameChange = (event) => { 
        this.setState({
            username: event.target.value
        })
    }

    handlePasswordChange = (event) => { 
        this.setState({
            password: event.target.value
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
    }

    render() {
        if (this.state.redirect) {
            return <Redirect to={this.state.redirect}/>
        }
        
        return (
            <div className="loginForm">
                <form onSubmit={this.handleSubmit}>
                    <div className="loginInputs">
                        <div>
                            <br/>
                            <label>Username : </label>
                            <input type="text" value={this.state.username}
                            onChange={this.handleUsernameChange} />
                        </div>
                        <div>
                            <label>Password : </label>
                            <input type="text" value={this.state.password}
                            onChange={this.handlePasswordChange} />
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
}

export default LoginForm
