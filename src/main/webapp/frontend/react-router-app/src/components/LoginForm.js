import React, { Component } from 'react';
<<<<<<< Updated upstream
import { Redirect } from 'react-router-dom';
=======
import {BrowserRouter,Link,Switch,Route,Router} from 'react-router-dom';
import HomePage from '../pages/HomePage';
>>>>>>> Stashed changes

export class LoginForm extends Component {
    constructor(props) {
        super(props)

        this.state={
            redirect: null,
            // name: '',
            username: '',
            password:'',
            // secret_question: 'What is your name?',
            // secret_answer: ''
        }
    }

    handleSubmit = (event) => {
        //Todo: Add error handling & lock account msg 
        alert(`${this.state.name} ${this.state.username} ${this.state.password} ${this.state.secret_question} ${this.state.secret_answer}`)
        //Assume it is sucessful verification
        //Check the user type as well
        this.setState({redirect:"/home"});
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

    render() {
        if (this.state.redirect) {
            return <Redirect to={this.state.redirect}/>
        }
        
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
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
                    <Link to="/homepage">
                        <button type="submit">Login</button>
                    </Link>
                    <Route path="/homepage" component={HomePage}/>
                    {/* <button type="submit" onClick={HomePage}>Login</button> */}
                </form>
            </div>
        )
    }
}

export default LoginForm
