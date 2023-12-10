import React, {Component} from "react";

export default class LoginComponent extends Component{
    constructor(props){
        super(props);

        this.state = {
            inputLogin: '',
            inputPassword: '',
            login: '',
            password: ''
        }

        this.handleInputLogin = this.handleInputLogin.bind(this)
        this.handleInputPassword = this.handleInputPassword.bind(this)
        this.handleSubmit = this.handleSubmit.bind(this)
    } 

    handleInputLogin(event){
        this.setState({
            inputLogin: event.target.value
        })
    }

    handleInputPassword(event){
        this.setState({
            inputPassword: event.target.value
        })
    }

    handleSubmit(event){
        event.preventDefault()
        this.setState({
            login: this.state.inputLogin,
            password: this.state.inputPassword
        })
    }

    render(){
        return (
            <div>
                <form className="auth-form-container" onSubmit={this.handleSubmit}>
                    <label>login</label>
                    <input value={this.state.inputLogin} onChange={this.handleInputLogin}></input>
                    <label>password</label>
                    <input value={this.state.inputPassword} onChange={this.handleInputPassword}></input>
                    <button type="submit">Submit</button>
                </form>
                
                <h1>{this.state.login}</h1>
                <h2>{this.state.password}</h2>
            </div>
        )
    }
}
