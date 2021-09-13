import React from 'react';
import RegisterForm from '../components/RegisterForm';
import Footer from '../components/Footer';
import '../App.css';

function RegisterPage() {
    return (
        <div>
            <h3 className='registerHeader'>Create New User</h3>
            <RegisterForm/>
            <Footer/>
        </div>
    )
}

export default RegisterPage
