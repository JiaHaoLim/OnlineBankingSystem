import React, { Component } from "react";
import UserDataService from "../services/user.service";
import { Link } from "react-router-dom";

export default class UsersList extends Component { 
    constructor(props) {
        super(props);  

        //Event Binding
        this.onChangeSearchName = this.onChangeSearchName.bind(this);
        this.retrieveUsers = this.retrieveUsers.bind(this);
        this.refreshList = this.refreshList.bind(this);
        this.setActiveUser = this.setActiveUser.bind(this);
        this.removeAllUsers = this.removeAllUsers.bind(this);
        this.searchName = this.searchName.bind(this);

        this.state = {
            users: [],
            currentUser: null,
            currentIndex: -1,
            searchName: ""
        };  
    }

    componentDidMount() {
        this.retrieveUsers();
    }

    onChangeSearchName(e) {
        console.log("inside onChangeSearchName")
        const searchName = e.target.value;
    
        this.setState({
          searchName: searchName
        });
    }
    
    retrieveUsers() {
        UserDataService.getAll()
        .then(response => {
            this.setState({
              users: response.data
            });
            console.log(response.data);
        })
        
        .catch(e => {
            console.log(e);
        });
        console.log("users retrieved in retrieveUsers() JS function " + this.state.users);
    }

    refreshList() {
        this.retrieveUsers();
        this.setState({
          currentUser: null,
          currentIndex: -1
        });
    }

    setActiveUser(user, index) {
        this.setState({
          currentUser: user,
          currentIndex: index
        });
    }

    removeAllUsers() {
        UserDataService.deleteAll()
          .then(response => {
            console.log(response.data);
            this.refreshList();
          })
          .catch(e => {
            console.log(e);
          });
    }

    searchName() {
        console.log('inside searchName() ' + this.state.searchName);
        UserDataService.findByName(this.state.searchName)
          .then(response => {
            this.setState({
              users: response.data
            });
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    }

    render() {
        const { searchName, users, currentUser, currentIndex } = this.state;
        return (
            <div className="list row">
            <div className="col-md-8">
                <div className="input-group mb-3">
                <input type="text" className="form-control" placeholder="Search by Name"
                        value={searchName} onChange={this.onChangeSearchName} />
                    <div className="input-group-append">
                        <button className="btn btn-outline-secondary" type="button" 
                        onClick={this.searchName}>Search</button>
                    </div>
                </div>
            </div>

            <div className="col-md-6">
                <h4>Users List</h4>
                <ul className="list-group">{users && users.map((user, index) => (
                    <li className={
                    "list-group-item " + (index === currentIndex ? "active" : "")
                     }
                     onClick={() => this.setActiveUser(user, index)} key={index}>
                        {user.name}
                    </li>
                    ))}
                </ul>
                <button className="m-3 btn btn-sm btn-danger" onClick={this.removeAllUsers}>
                    Remove All
                </button>
            </div>

            <div className="col-md-6"> {currentUser ? (
                <div><h4>User</h4>
                    <div>
                        <label><strong>Name:</strong></label>{" "}
                            {currentUser.name}
                    </div>
                <div>
                <label><strong>Name:</strong></label>{" "}
                {currentUser.name}
            </div>
              
            <Link to={"/users/" + currentUser.id} className="badge badge-warning">
                Edit
            </Link>
            </div>

            ) : (
            <div>
                <br />
            <p>Please click on a User...</p>
            </div>
             )}
             </div>
           </div>
        );
    }

 }
