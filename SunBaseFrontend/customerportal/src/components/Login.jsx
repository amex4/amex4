import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";

const Login = () => {

    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
    const navigate = useNavigate();

    const handleSubmit = (event)=>{
        event.preventDefault()
        axios.post('http://localhost:8000/auth/login',{
            email : email,
            password : password
        }).then(
            (response) => {
                localStorage.setItem("token",response.data.token)
                navigate("/customer")
            }
        ).catch(
            (error) => {
                console.log(error)
                alert('your username or password may be wrong')
                navigate("/login")
            }
        )
    }

    return (
        <div>
            <div className="formbold-main-wrapper">
                <div className="formbold-form-wrapper">

                    <form onSubmit={e => handleSubmit(e)}>
                        <div className="formbold-form-title">
                            <h2 className="">login now</h2>
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
                        <button type="submit" className="formbold-btn">Login</button>
                    </form>
                    <br />
                    <br />                    
                    <div>
                        <Link to='/register'>sign up</Link>
                    </div>
                </div>
            </div>
          
        </div>
    )
}

export default Login;