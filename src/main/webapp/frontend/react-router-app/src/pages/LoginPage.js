import React, {useState} from 'react';
//import Login from '../components/Login';
import LoginForm from '../components/LoginForm_backup';
import Footer from '../components/Footer';
import PropTypes from 'prop-types';
import '../App.css';

export default function LoginPage() {
    return (
        <div>
            <h3 className='loginHeader'>Banking System Login</h3>
            {/* <Login/> */}
            <LoginForm/>
            <Footer/>
        </div>
    )
}


LoginPage.propTypes = {
    setToken: PropTypes.func.isRequired
}

