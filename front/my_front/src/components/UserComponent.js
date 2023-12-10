import React, { Component } from 'react';
import UserService from '../services/UserService';
import Table from 'react-bootstrap/Table';

class UserComponent extends Component {
    constructor(props){
        super(props);
        this.state = {
            users: []
        }
    }

    componentDidMount(){
        UserService.getUsers().then((result) => {
            console.log(result);
            this.setState({users: result.data})
        }).catch((err) => {
            console.error("нет доступа");
        });
    }

    render() {
        return (
            <div>
               <h1>Users</h1> 
               <Table striped bordered hover size="lg" variant = 'primary'> 
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Login</th>
                        <th>Password</th>
                        <th>Role</th>
                    </tr>
                </thead>
                <tbody>
                    
                        {
                            this.state.users.map(
                                (user,index) =>
                                <tr key={index}>
                                    <th> {user.id} </th>
                                    <th> {user.login} </th>
                                    <th> {user.password} </th>
                                    <th> {user.roles[0].role} </th>
                                </tr>
                            )
                        }
                    

                </tbody>
                </Table>
            </div>
        );
    }
}

export default UserComponent;