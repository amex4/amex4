import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";

const Register = ()=> {

    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
    const navigate = useNavigate();


    const handleSubmit = (event)=> {
        event.preventDefault()
        axios.post('http://localhost:8000/auth/register',{
            email : email,
            password : password
        }).then(
            (response) => {
                console.log(response.data)
                navigate("/login")
            }
        ).catch(
            (error) => {
                console.log(error)
                alert('your username or password may be wrong')
                navigate("/register")
            }
        )
    }

    return(
        <div>
            <div className="formbold-main-wrapper">
                <div className="formbold-form-wrapper">

                    <form onSubmit={e => handleSubmit(e)}>
                        <div className="formbold-form-title">
                            <h2 className="">register now</h2>
                        </div>

                        <div className="formbold-input-flex">
                            <div>
                                <label htmlFor="email" className="formbold-form-label">
                                    Email
                                </label>
                                <input
                                    type="email"
                                    name="email"
                                    id="email"
                                    className="formbold-form-input"
                                    onChange={e => setEmail(e.target.value)}
                                />
                            </div>
                        </div>

                        <div className="formbold-input-flex">
                            <div>
                                <label htmlFor="password" className="formbold-form-label"> Password </label>
                                <input
                                    type="password"
                                    name="password"
                                    id="password"
                                    className="formbold-form-input"
                                    onChange={e => setPassword(e.target.value)}
                                />
                            </div>
                        </div>
                        <button type="submit" className="formbold-btn">Register</button>
                    </form>
                    <br />
                    <br />                    
                    <div>
                        <Link to='/register'>login now</Link>
                    </div>
                </div>
            </div>
          
        </div>
    )
}

export default Register;