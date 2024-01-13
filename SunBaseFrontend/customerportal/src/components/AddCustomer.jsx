import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const AddCustomer = () => {

    const [firstName,setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [street,setStreet] = useState('');
    const [address,setAddress] = useState('');
    const [city,setCity] = useState('');
    const [state,setState] = useState('');
    const [phoneNumber,setPhoneNumber] = useState(0);
    const navigate = useNavigate();
    const token = localStorage.getItem("token");

    const handleSubmit = (event)=> {
        event.preventDefault()
        axios.post('http://localhost:8000/customer/create',{
            firstName : firstName,
            lastName : lastName,
            street : street,
            address : address,
            city : city,
            state : state,
            phoneNumber : phoneNumber
        },{ headers: {
            Authorization: `Bearer ${token}`
        }}).then(
            (response) => {
                console.log(response.data)
                navigate('/customer')
            }
        ).catch(
            (error) => {
                console.log(error)
                alert('something went wrong try again')
                navigate("/customer/add")
            }
        )
    }

    return(
        <div>
        <div className="formbold-main-wrapper">
            <div className="formbold-form-wrapper">

                <form onSubmit={(e) => handleSubmit(e)}>
                    <div className="formbold-form-title">
                        <h2 className="">Add customer</h2>
                    </div>

                    
                    <div className="formbold-input-flex">
                        <div>
                            <label htmlFor="firstName" className="formbold-form-label"> First Name </label>
                            <input
                                type="text"
                                name="firstName"
                                id="firstName"
                                className="formbold-form-input"
                                onChange={e => setFirstName(e.target.value)}
                            />
                        </div>
                    </div>

                    <div className="formbold-input-flex">
                        <div>
                            <label htmlFor="lastName" className="formbold-form-label"> Last Name </label>
                            <input
                                type="text"
                                name="lastName"
                                id="lastName"
                                className="formbold-form-input"
                                onChange={e => setLastName(e.target.value)}
                            />
                        </div>
                    </div>

                    <div className="formbold-input-flex">
                        <div>
                            <label htmlFor="street" className="formbold-form-label"> Street</label>
                            <input
                                type="text"
                                name="street"
                                id="street"
                                className="formbold-form-input"
                                onChange={e => setStreet(e.target.value)}
                            />
                        </div>
                    </div>

                    <div className="formbold-input-flex">
                        <div>
                            <label htmlFor="address" className="formbold-form-label"> Address </label>
                            <input
                                type="text"
                                name="address"
                                id="address"
                                className="formbold-form-input"
                                onChange={e => setAddress(e.target.value)}
                            />
                        </div>
                    </div>

                    <div className="formbold-input-flex">
                        <div>
                            <label htmlFor="city" className="formbold-form-label"> City </label>
                            <input
                                type="text"
                                name="city"
                                id="city"
                                className="formbold-form-input"
                                onChange={e => setCity(e.target.value)}
                            />
                        </div>
                    </div>

                    <div className="formbold-input-flex">
                        <div>
                            <label htmlFor="state" className="formbold-form-label"> State </label>
                            <input
                                type="text"
                                name="state"
                                id="state"
                                className="formbold-form-input"
                                onChange={e => setState(e.target.value)}
                            />
                        </div>
                    </div>


                    <div className="formbold-input-flex">
                        <div>
                            <label htmlFor="phoneNumber" className="formbold-form-label"> PhoneNumber </label>
                            <input
                                type="number"
                                name="phoneNumber"
                                id="phoneNumber"
                                className="formbold-form-input"
                                onChange={e=> setPhoneNumber(e.target.value)}
                            />
                        </div>
                    </div>
                    <button type="submit" className="formbold-btn">ADD</button>
                </form>
                <br />
                <br />                    
            </div>
        </div>
      
    </div>
    )
}

export default AddCustomer;