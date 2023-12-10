import { Button } from "bootstrap";
import React, {Component} from "react";

class TestComponent extends Component{
    constructor(props){
        super(props);

        this.state = {
            value: 10
        }

        this.increment = this.increment.bind(this);
    } 

    increment(){
        this.setState(state=>({
            value: state.value+1
        }))
    }
    
    render(){
        return (
            <div>
                <h1>{this.state.value}</h1>
                <button onClick ={this.increment}>Increment</button>
            </div>
        )
    }
}

export default TestComponent;