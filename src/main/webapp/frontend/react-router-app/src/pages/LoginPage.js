import React from 'react';
import { Switch, Route, NavLink, HashRouter } from 'react-router-dom';
import LoginForm from '../components/LoginForm';
import UnlockAccount from '../components/UnlockAccount';

function LoginPage() {
    return (
        <HashRouter>
            <div>
                <h1>Online Banking System - Home Page - Account Holder - SPA</h1>
                <ul className="header">
                    <li><NavLink to="/LoginForm">Login</NavLink></li>
                    <li><NavLink to="/UnlockAccount">Unlock Account</NavLink></li>
                </ul>
                <div className="content">
                    <Switch>
                        <Route path="/LoginForm" component={LoginForm}/>
                        <Route path="/UnlockAccount" component={UnlockAccount}/>
                    </Switch>
                </div>
            </div>
        </HashRouter>
    )
}

export default LoginPage
