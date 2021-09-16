import React from 'react';
import { Switch, Route, NavLink, HashRouter } from 'react-router-dom';
import createAccount from '../components/Admin/createAccount';
import viewAllTransaction from '../components/Admin/viewAllTransaction';
import Footer from '../components/App/Footer';
import '../App.css';

function HomePageAdmin() {
    //console.log(user.data.role);
    

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
                        <Route path="/createAccount" component={createAccount}/>
                        <Route path="/viewAllTrasaction" component={viewAllTransaction}/>
                    </Switch>
                </div>
                <Footer/>

        </HashRouter>
    )
}

export default HomePageAdmin
