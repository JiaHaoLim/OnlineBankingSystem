import React, { Component } from 'react';
import { Redirect } from 'react-router-dom';
import '../App.css';

export class RegisterForm extends Component {
    constructor(props) {
        super(props)

        this.state={
            redirect: null,
            username: '',
            password:'',
        }
    }

    handleSubmit = (event) => {
        // check for valid inputs
        // if valid
        //Check the user type as well
        this.setState({redirect:"/"});

        // if not valid
        // raise alert message
        // alert(`EXAMPLE User name is taken`)
        event.preventDefault()
    }

    handleBack = (event) => {
        this.setState({redirect:"/"});
        event.preventDefault()
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
            <div className="registerForm">
                <form onSubmit={this.handleSubmit}>
                    <div className="registerInputs">
                        <div>
                            <br/>
                            <label>Name : </label>
                            <input type="text" value={this.state.username}
                            onChange={this.handleNameChange} />
                        </div>
                        <div>
                            <label>Username : </label>
                            <input type="text" value={this.state.username}
                            onChange={this.handleUsernameChange} />
                        </div>
                        <div>
                            <label>Password : </label>
                            <input type="text" value={this.state.password}
                            onChange={this.handlePasswordChange} />
                        </div>
                        <div>
                            <label>Secret Question : </label>
                            <input type="text" value={this.state.password}
                            onChange={this.handleSecretQuestionChange} />
                        </div>
                        <div>
                            <label>Secret Answer : </label>
                            <input type="text" value={this.state.password}
                            onChange={this.handleSecretAnswerChange} />
                        </div>
                    </div>
                    <br/>
                    <button id='loginbtn' onClick={this.handleSubmit}>Register Account</button>
                    <br/>
                    <button id='inputbtn' onClick={this.handleBack}>Back</button>
                </form>
            </div>
        )
    }
}

export default RegisterForm
