import React from 'react';
import LoginForm from '../components/LoginForm';
import '../App.css';

function LoginPage() {
    return (
        <div>
            <h3 className='loginHeader'>Banking System Login</h3>
            <LoginForm/>
        </div>
    )
}

export default LoginPage
