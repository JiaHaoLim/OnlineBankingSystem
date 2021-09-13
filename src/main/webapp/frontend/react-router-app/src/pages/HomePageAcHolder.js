import React from 'react';
import { Switch, Route, NavLink, HashRouter } from 'react-router-dom';
import ViewStatements from '../components/ViewStatements';
import ChangeProfile from '../components/ChangeProfile';
import RequestforChequeBook from '../components/RequestforChequeBook';
import TrackServiceRequest from '../components/TrackServiceRequest';
import FundTransfer from '../components/FundTransfer';
import ChangePassword from '../components/ChangePassword';
import Footer from '../components/Footer';
import '../App.css';

function HomePageAcHolder() {
    // console.log(usertype === 1? "Account Holder" : "Admin")

    return (
        <HashRouter>
                <link href="./bootstrap-5.1.0-dist/css/bootstrap.min.css" rel="stylesheet"/>
                <h1 className='homepageHeader'>ONLINE BANKING SYSTEM
                    <h3 className='homepageHeaderSmall'>Account Holder [add account holder name] <br/>
                    </h3>
                </h1>
                <nav>
                    <ul className="nav-links">
                        <li a><NavLink to="/viewStatements">View Mini/Detailed Statements</NavLink></li>
                        <li a><NavLink to="/changeProfile">Change in address/ mobile number</NavLink></li>
                        <li a><NavLink to="/requestforChequeBook">Request for Cheque Book</NavLink></li>
                        <li a><NavLink to="/trackServiceRequest">Track Service Request</NavLink></li>
                        <li a><NavLink to="/fundTransfer">Fund Transfer</NavLink></li>
                        <li a><NavLink to="/changePassword">Change Password</NavLink></li>
                    </ul>
                </nav>
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
                <Footer/>

        </HashRouter>
    )
}

export default HomePageAcHolder
