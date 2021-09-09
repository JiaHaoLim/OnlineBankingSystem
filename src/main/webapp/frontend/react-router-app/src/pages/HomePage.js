import React from 'react';
import { Switch, Route, Link } from 'react-router-dom';
import ViewStatements from '../components/ViewStatements';
import TrackServiceRequest from '../components/TrackServiceRequest';
import FundTransfer from '../components/FundTransfer';
import ChangePassword from '../components/ChangePassword';
import RequestforChequeBook from '../components/RequestforChequeBook';


function HomePage({usertype}) {
    console.log("login user type is: "+usertype == 1? "Account Holder" : "Admin")

    return (
        <div>
            <div className="container">
                <h1>Home Page for Account Holder</h1>
                <ul className="navbar">
                    <li><Link to="/viewStatements">View Mini/Detailed Statements</Link></li>
                    <li><Link to="/changeAddressMobileNumber">Change in address/ mobile number</Link></li>
                    <li><Link to="/requestforChequeBook">Request for Cheque Book</Link></li>
                    <li><Link to="/trackServiceRequest">Track Service Request</Link></li>
                    <li><Link to="/fundTransfer">Fund Transfer</Link></li>
                    <li><Link to="/changePassword">Change Password</Link></li>

                    <Route path="/viewStatements" component={ViewStatements}/>
                    <Route path="/requestforChequeBook" component={RequestforChequeBook}/>
                    <Route path="/trackServiceRequest" component={TrackServiceRequest}/>
                    <Route path="/fundTransfer" component={FundTransfer}/>
                    <Route path="/changePassword" component={ChangePassword}/>
                </ul>
            </div>

            <div className="container">
                <h1>Home Page for Admin</h1>
                <p><Link to="/your desired link">View Statement</Link></p>
            </div>
        </div>
    )
}

export default HomePage
