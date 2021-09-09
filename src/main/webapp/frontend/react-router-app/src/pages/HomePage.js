import React from 'react';
import { Switch, Route, NavLink, HashRouter } from 'react-router-dom';
import ViewStatements from '../components/ViewStatements';
import ChangeProfile from '../components/ChangeProfile';
import RequestforChequeBook from '../components/RequestforChequeBook';
import TrackServiceRequest from '../components/TrackServiceRequest';
import FundTransfer from '../components/FundTransfer';
import ChangePassword from '../components/ChangePassword';

function HomePage({usertype}) {
    console.log(usertype === 1? "Account Holder" : "Admin")
    

    return (
        <HashRouter>
            <div>
                <h1>Online Banking System - Home Page - Account Holder - SPA</h1>
                <ul className="header">
                    <li><NavLink to="/viewStatements">View Mini/Detailed Statements</NavLink></li>
                    <li><NavLink to="/changeProfile">Change in address/ mobile number</NavLink></li>
                    <li><NavLink to="/requestforChequeBook">Request for Cheque Book</NavLink></li>
                    <li><NavLink to="/trackServiceRequest">Track Service Request</NavLink></li>
                    <li><NavLink to="/fundTransfer">Fund Transfer</NavLink></li>
                    <li><NavLink to="/changePassword">Change Password</NavLink></li>
                </ul>
                <div className="content">
                    <Switch>
                        <Route path="/viewStatements" component={ViewStatements}/>
                        <Route path="/changeProfile" component={ChangeProfile}/>
                        <Route path="/requestforChequeBook" component={RequestforChequeBook}/>
                        <Route path="/trackServiceRequest" component={TrackServiceRequest}/>
                        <Route path="/fundTransfer" component={FundTransfer}/>
                        <Route path="/changePassword" component={ChangePassword}/>
                    </Switch>
                </div>
            </div>
        </HashRouter>
    )
}

export default HomePage
