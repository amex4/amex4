import React,{useContext} from 'react';
import {TransactionContext} from '../context/TransactionContext';
import { shortenAddress } from '../utils/shortenAddress';



const Transactions = ()=>{
    const { connectedAccount,transactions } = useContext(TransactionContext);

    const TransactionCard = ({addressTo, addressFrom, keyword, timestamp, message, amount, url})=>{
        return (
            <div className=' m-4
                2xl:min-w-[450px]
                2xl:max-w-[500px]
                sm:min-w-[230px]
                sm:max-w-[270px]
                white-glassmorphism
                border-none
                flex-col p-3 rounded-md hover:shadow-2xl
            '>
                <div className='flex flex-col justify-center items-center w-full border-none white-glassmorphism mt-3'>
                    <div className='flex-col w-full mb-6 p-2'>
                        <p className='text-white text-base'>From : {!addressFrom ? 'Address From' : shortenAddress(addressFrom)}</p>
                        <p className='text-white text-base'>To : {!addressTo ? 'Address To' : shortenAddress(addressTo)}</p>
                        <p className='text-white text-base'>Amount : {amount} ETH</p>
                        <div className='bg-black  p-3 px-5 w-max rounded-3xl mt-5 shadow-2xl'>
                            <p className='text-[#37c7da] font-bold'>{timestamp}</p>
                        </div>
                    </div>
                </div>

            </div>
        );
    }
    return(
        <div className=' w-full justify-center items-center 2xl:px-20 gradient-bg-transactions'>
            <div className='flex flex-col md:p-12 py-12  px-4'>
                {
                    connectedAccount ?(
                        <h3 className='text-white text-3xl text-center my-2'>Latest Transactions</h3>
                    ):
                    (
                        <h3 className='text-white text-3xl text-center my-2'>Connect Your Account</h3>
                    )
                }
            </div>
            <div className='flex flex-wrap justify-center items-center mt-10 sm:mr-10'>
                {transactions.reverse().map((transaction ,i) => (
                    <TransactionCard key={i} {...transaction}  />
                ))}
            </div>

        </div>
    );
}

export default Transactions;