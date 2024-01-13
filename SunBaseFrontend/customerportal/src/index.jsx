import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import Login from './components/Login'
import Register from './components/Register';
import reportWebVitals from './reportWebVitals';
import {RouterProvider, createBrowserRouter} from 'react-router-dom';
import EditCustomer from './components/EditCustomer';
import CustomerPage from './components/CustomerPage';
import AddCustomer from './components/AddCustomer';

const router = createBrowserRouter([
  {
    path : "/",
    element : <App />
  },
  {
    path : "/login",
    element : <Login />
  },
  {
    path : "/register",
    element : <Register />
  },
  {
    path : "/customer/edit",
    element : <EditCustomer />
  },
  {
    path : "/customer",
    element : <CustomerPage />
  },
  {
    path : "/customer/add",
    element : <AddCustomer />
  }
]);


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
     <RouterProvider router={router} />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
