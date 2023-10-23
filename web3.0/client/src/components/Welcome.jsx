import {AiFillPlayCircle} from 'react-icons/ai'
import {SiEthereum} from 'react-icons/si'
import {BsInfoCircle} from 'react-icons/bs'
import { TransactionContext } from '../context/TransactionContext'
import React,{useContext, useState} from 'react'
import { shortenAddress } from '../utils/shortenAddress'

import {Loader} from './'

const companyCommonStyles = "min-h-[70px] sm:px-0 px-2 sm:min-w-[120px] flex justify-center items-center border-[0.5px] border-gray-400 text-sm font-light text-white";


const Input = ({placeholder,name,type,handleChange,value})=> (
    <input 
        placeholder={placeholder}
        type={type}
        step="0.0001"
        value={value}
        onChange={(e)=>handleChange(e, name)}
        className='w-full my-2 rounded-sm outline-none p-2 bg-transparent text-white border-none text-sm white-glassmorphism '
    />
)

const Welcome = ()=>{
    
    const { connectWallet,connectedAccount,formData, handleChange, sendTransaction,isLoading } = useContext(TransactionContext);

    const handleSubmit = (e)=>{
        const {addressTo , amount, keyword, message} = formData;

        if(!addressTo || !amount || !keyword || !message){
            return;
        }
        else{
            sendTransaction();
        }

    } 
    return(
        <div className='flex w-full justify-center items-center'>
            <div className='flex md:flex-row flex-col items-start justify-between md:p-20 py-12 px-4'>
                <div className='flex flex-1 justify-start flex-col md:mr-10'>
                    <h1 className='text-3xl sm-5xl text-white text-gradient py-1'>
                        Send Crypto <br />Across the world
                    </h1>
                    <p className='text-left mt-5 text-white font-light md:w-9/12 w-11/12 text-base'>
                        explore the crypto world to make donation safely all over the world
                    </p>
                    { !connectedAccount &&
                    (<button type="button" onClick={connectWallet}
                        className='flex flex-row justify-center items-center my-5 bg-[#2952e3] p-3 rounded-full cursor-pointer hover:bg-[2546bd]'
                    >
                         <p className='text-white text-base'>Connect Wallet</p>
                    </button>)
                    }
                    <div className='grid sm:grid-cols-3 grid-cols-2 w-full mt-10'>
                        <div className={`rounded-tl-2xl ${companyCommonStyles}`}>
                            Reliability
                        </div>
            <div className={companyCommonStyles}>Security</div>
                <div className={`sm:rounded-tr-2xl ${companyCommonStyles}`}>
                        Ethereum
                </div>
                <div className={`sm:rounded-bl-2xl ${companyCommonStyles}`}>
                        Web 3.0
                </div>
                    <div className={companyCommonStyles}>Low Fees</div>
                <div className={`rounded-br-2xl ${companyCommonStyles}`}>
                    Blockchain
                </div>

                    </div>
                </div>

                <div className='flex flex-col flex-1 items-center justify-start w-full md:mt-0 mt-10'>
                    <div className='p-3 justify-end items-start flex-col rounded-xl h-40  sm:w-72 w-full my-5 eth-card white-glassmorphism'>
                        <div className='flex justify-between flex-col w-full h-full'>
                            <div className='flex justify-between items-start'>
                                <div className=''>
                                    <SiEthereum fontSize={21} color='#fff' />
                                </div>
                                    <BsInfoCircle fontSize={17} color='#fff'/>
                            </div>
                            <div>{ !connectedAccount ? 
                                (<p className='text-white font-light text-sm'>
                                    Address
                                </p>) : (
                                <p className='text-white font-light text-sm'>
                                    {shortenAddress(connectedAccount)}
                                </p> )
                                    }
                                <p className='text-white font-light text-semibold mt-1'>
                                    Ethereum
                                </p>
                            </div>
                        </div>
                    </div>


                    <div className='p-5 sm:w-96 w-full flex flex-col justify-start items-center blue-glassmorphism '>
                        <Input placeholder='Address To' name='addressTo' type='text' handleChange={handleChange} />
                        <Input placeholder='Amount (ETH)' name='amount' type='number' handleChange={handleChange} />
                        <Input placeholder='Keyword' name='keyword' type='text' handleChange={handleChange} />
                        <Input placeholder='Enter Message' name='message' type='text' handleChange={handleChange} /> 

                        <div className='h-[1px] w-full bg-gray-400 my-2' />

                        {isLoading ? (
                            <Loader />
                        )
                    : (
                        <button
                            type='button'
                            onClick={handleSubmit}
                            className='text-white w-full mt-2 border-[1px] p-2 border-[#3d4f7c] rounded-full cursor-pointer'
                        >
                            Send Now
                        </button>
                    )
                    }
                    </div>
                </div>
            </div>

        </div>
    );
}

export default Welcome;