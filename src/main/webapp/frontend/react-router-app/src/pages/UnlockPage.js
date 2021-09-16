import React from 'react';
import UnlockAccount from '../components/App/UnlockAccount';
import Footer from '../components/App/Footer';
import '../App.css';

function UnlockPage() {
    return (
        <div>
            <h3 className='unlockHeader'>Unlock Account</h3>
            <br/>
            <UnlockAccount/>
            <Footer/>
        </div>
    )
}

export default UnlockPage
