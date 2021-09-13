import React from 'react';
import LoginForm from '../components/LoginForm';
import Footer from '../components/Footer';
import '../App.css';

function LoginPage({setToken}) {
    return (
        <div>
            <h3 className='loginHeader'>Banking System Login</h3>
            <LoginForm/>
            <Footer/>
        </div>
    )
}

export default LoginPage

