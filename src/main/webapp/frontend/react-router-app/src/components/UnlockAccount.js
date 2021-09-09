import React, { Component } from 'react';

export class UnlockAccount extends Component {
    constructor(props) {
        super(props)

        this.state={
            secret_question: 'What is your name?',
            secret_answer: ''
        }
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
                        <label>Secret Question :  </label>
                        <label>{this.state.secret_question}</label>
                    </div>
                    <div>
                        <label>Secret Answer : </label>
                        <input type="text" value={this.state.secret_answer}
                        onChange={this.handlePasswordChange} />
                    </div>
                    {/* Need to add a function to check for unlock */}
                    {/* Maybe add a notify event to let user know unlock status */}
                    <button>Unlock Account</button>
                </form>
            </div>
        )
    }
}

export default UnlockAccount
