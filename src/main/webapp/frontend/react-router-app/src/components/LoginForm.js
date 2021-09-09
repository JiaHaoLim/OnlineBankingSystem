import React, { Component } from 'react'

export class LoginForm extends Component {
    constructor(props) {
        super(props)

        this.state={
            name: '',
            username: '',
            password:'',
            secret_question: 'What is your name?',
            secret_answer: ''
        }
    }

    handleSubmit = (event) => {
        //Todo: Add error handling & lock account msg 
        alert(`${this.state.name} ${this.state.username} ${this.state.password} ${this.state.secret_question} ${this.state.secret_answer}`)
        //event.preventDefault() will prevent page from refreshing after clicking ok on alert
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
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <div>
                        <label>Name : </label>
                        <input type="text" value={this.state.name}
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
                        <select value={this.state.secret_question} onChange={this.handleSecretQuestionChange}>
                            <option value="q1">What is your name?</option>
                            <option value="q2">What is your favorite food?</option>
                            <option value="q3">What is the name of your pet?</option>
                        </select>
                    </div>
                    <div>
                        <label>Secret Answer : </label>
                        <input type="text" value={this.state.secret_answer}
                        onChange={this.handleSecretAnswerChange} />
                    </div>
                    <button type="submit">Login</button>
                </form>
            </div>
        )
    }
}

export default LoginForm
