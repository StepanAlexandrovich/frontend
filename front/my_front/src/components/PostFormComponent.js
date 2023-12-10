import React, { useState } from 'react';
import axios from 'axios';
import bcrypt from 'bcryptjs';

function PostFormComponent() {
    // const url = 'http://localhost:8080/login';
    const url = '';

    //const bcrypt = require("bcrypt")
    const saltRounds = 10
    const password = "Admin@123"

    const [data,setData] = useState({
        username:'',
        password:''
    })

    function handle(e){
        const newData = {...data}
        newData[e.target.id] = e.target.value
        setData(newData)
        console.log(newData)
    }

//     function method(){
//         bcrypt
//   .genSalt(saltRounds)
//   .then(salt => {
//     console.log('Salt: ', salt)
//     return bcrypt.hash(password, salt)
//   })
//   .then(hash => {
//     console.log('Hash: ', hash)
//   })
//   .catch(err => console.error(err.message))
        
//     }

    function submit(e){
        e.preventDefault()
        // axios.post(url,{
        //     username: data.username,
        //     password: data.password
        // })
        // .then(res=>{
        //     console.log(res.data)
        // })

        

        //var data = '{\n    "username" : "user",\n    "password" : "password"\n}';


        var config = {
            method: 'get',
            url: 'http://localhost:8080/login',
            headers: { 
                'Authorization': 'Basic dXNlcjpwYXNzd29yZA==', 
                'Content-Type': 'text/plain'
            },
            data : data
        };

        axios(config)
        .then(function (response) {
            console.log(JSON.stringify(response.data));
        })
        .catch(function (error) {
            console.log(error);
        });

    }

    return (
        <div>
            <form onSubmit={(e)=>submit(e)}>
                <input onChange={(e)=>handle(e)} id = "username" value={data.username} placeholder='username' type='text'></input>
                <input onChange={(e)=>handle(e)} id = "password" value={data.password} placeholder='password' type='password'></input>
                <button>log in</button>
            </form>
        </div>
    );
}

export default PostFormComponent;