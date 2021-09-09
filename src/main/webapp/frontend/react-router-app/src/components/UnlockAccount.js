import React, { Component } from 'react';
import { Redirect } from 'react-router-dom';

export class UnlockAccount extends Component {
    constructor(props) {
        super(props)

        this.state={
            redirect: null,
            secret_question: 'What is your name?',
            secret_answer: ''
        }
    }

    handleSubmit = (event) => {
        // Need to check whether secret answer is correct
        // if yes redirect to home
        this.setState({redirect:"/home"});
        // else redirect to login
        // this.setState({redirect:"/"});
        event.preventDefault()
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
            <div>
                <form onSubmit={this.handleSubmit}>
                    <div>
                        <label>Secret Question : {this.state.secret_question}</label>
                        {/* <select value={this.state.secret_question} onChange={this.handleSecretQuestionChange}>
                            <option value="q1">What is your name?</option>
                            <option value="q2">What is your favorite food?</option>
                            <option value="q3">What is the name of your pet?</option>
                        </select> */}
                    </div>
                    <div>
                        <label>Secret Answer : </label>
                        <input type="text" value={this.state.secret_answer}
                        onChange={this.handleSecretAnswerChange} />
                    </div>
                    <button type="submit">Unlock Account</button>
                </form>
            </div>
        )
    }
}

export default UnlockAccount
