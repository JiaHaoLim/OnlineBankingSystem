import React, {useState} from 'react';
import LoginForm from '../components/App/LoginForm';
import Footer from '../components/App/Footer';
import '../App.css';

export default function LoginPage() {
    return (
        <div>
            <h3 className='loginHeader'>Banking System Login</h3>
            <LoginForm/>
            <Footer/>
        </div>
    )
}

