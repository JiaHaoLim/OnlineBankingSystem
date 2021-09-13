import React, { Component } from 'react';
import { Redirect } from 'react-router-dom';
import '../App.css';

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
        alert(`Account has been unlocked`)
        // else redirect to login
        // this.setState({redirect:"/"});
        // alert(`Account has not been unlocked`)
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
            <div className='unlockForm'>
                <form onSubmit={this.handleSubmit}>
                    <div>
                        <label>Secret Question : <label className='secretQ'>{this.state.secret_question}</label></label>
                    </div>
                    <div>
                        <label>Secret Answer : </label>
                        <input type="text" value={this.state.secret_answer}
                        onChange={this.handleSecretAnswerChange} />
                    </div>
                    <br/>
                    <button id='unlockbtn' type="submit">Unlock Account</button>
                </form>
            </div>
        )
    }
}

export default UnlockAccount
