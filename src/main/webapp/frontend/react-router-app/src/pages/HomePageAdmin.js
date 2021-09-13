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

function HomePageAdmin() {
    // console.log(usertype === 1? "Account Holder" : "Admin")
    

    return (
        <HashRouter>
                <link href="./bootstrap-5.1.0-dist/css/bootstrap.min.css" rel="stylesheet"/>
                <h1 className='homepageHeader'>ONLINE BANKING SYSTEM
                    <h3 className='homepageHeaderSmall'>Admin [add account holder name] <br/> 
                    </h3>
                </h1>
                <nav>
                    <ul className="nav-links">
                        <li a><NavLink to="/createAccount">Create New Account Page</NavLink></li>
                        <li a><NavLink to="/viewAllTrasaction">View Transaction of all accounts</NavLink></li>
                    </ul>
                </nav>
                <div className="content">
                    <Switch>
                        <Route path="/createAccount" component={ViewStatements}/>
                        <Route path="/viewAllTrasaction" component={ChangeProfile}/>
                    </Switch>
                </div>
                <Footer/>

        </HashRouter>
    )
}

export default HomePageAdmin
