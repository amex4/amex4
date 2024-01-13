import COLUMNS from './columns';
import axios from 'axios';
import { useEffect, useMemo, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';

const CustomerPage = () => {

    const columns = useMemo(() => COLUMNS, [])
    const [data, setData] = useState([])
    const navigate = useNavigate();
    const [query,setQuery] = useState('')

    useEffect(
        () => {
            getData();
        }, []);

    const token = localStorage.getItem("token");

    const search = () => {
        axios.request({
            headers: {
                Authorization: `Bearer ${token}`
            },
            params : params,
            method: "GET",
            url: `http://localhost:8000/customer/all`
        }).then(response => {

            setData(response.data);
        }).catch(
            (error) => {
                console.log(error)
            }
        );
    }

    const params = {
        query : query 
      };

    const deleteCustomer = (id) => {
        

        axios.request({
            headers: {
                Authorization: `Bearer ${token}`
            },
            method: "DELETE",
            url: `http://localhost:8000/customer/${id}`
        }).then(response => {
            window.location.reload();
        }).catch(
            (error) => {
                console.log(error)
            }
        );

    }

    const editCustomer = (id) => {
        localStorage.setItem("id",id)
        navigate("edit")
    }

    const getData = async () => {
        axios.request({
            headers: {
                Authorization: `Bearer ${token}`
            },
            params : params,
            method: "GET",
            url: `http://localhost:8000/customer/all`
        }).then(response => {

            setData(response.data);
        }).catch(
            (error) => {
                console.log(error)
            }
        );
    }

    const UserData = ({users}) => {
        return(
            <>
                {
                    users.map((customer) => {
                        const {customerId,firstName,lastName,street,address,city,state,email,phoneNumber} = customer;

                        return(
                            <tr>
                                <td>{customerId}</td>
                                <td>{firstName}</td>
                                <td>{lastName}</td>
                                <td>{street}</td>
                                <td>{address}</td>
                                <td>{city}</td>
                                <td>{state}</td>
                                <td>{email}</td>
                                <td><button onClick={() => editCustomer(customerId)} className='formbold-btn'>edit</button><button onClick={() => deleteCustomer(customerId)} className='formbold-btn-2 '>delete</button></td>
                            </tr>
                        )
                    })
                }
            </>
        )
    }

    return (
        <div>
        <div>
            <h2>CUSTOMER DETAILS</h2>
        </div>
        <br />
        <br />
        <div className="formbold-input-flex">
                        <div>
                            <select name="" id="">
                                <option value="fistname">first name</option>
                                <option value="fistname">city</option>
                                <option value="fistname">email</option>
                            </select>
                            <input
                                type="text"
                                name="search"
                                id="search"
                                className="formbold-form-input"
                                onChange={e => setQuery(e.target.value)}
                    />
                      <button className='formbold-btn' onClick={() => search()}>Search</button>
                </div>
            </div>
        <br />
        <br />
        <table>
            <thead>
            <td>
                <th>ID</th>
            </td>
             <td>
                <th>First Name</th>
             </td>
             <td>
                <th>Last Name</th>
             </td>
             <td>
                <th>Street</th>
             </td>
             <td>
                <th>Address</th>
             </td>
             <td>
                <th>City</th>
             </td>
             <td>
                <th>State</th>
             </td>
             <td>
                <th>Email</th>
             </td>
             <td>
                <th>Actions</th>
             </td>
            </thead>
            <tbody>
                <UserData users = {data} />
            </tbody>
        </table>
        <br />
        <div>
            <button className='formbold-btn'><Link to="add">add Customer</Link></button>
        </div>
        </div>
    )
}


export default CustomerPage;