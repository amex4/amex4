import React,{useEffect, useState} from "react";
import {ethers} from 'ethers';
import {contractAbi, contractAddress} from '../utils/constants';

export const TransactionContext = React.createContext();

const {ethereum} = window

const getEthereumContract = ()=> {
    const provider = new ethers.providers.Web3Provider(ethereum);
    const signer = provider.getSigner();
    const transactionContract = new ethers.Contract(contractAddress, contractAbi, signer)

    return transactionContract;
}

export const TransactionProvider = ({ children }) => {

    const [connectedAccount,setConnectedAccount] = useState('');
    const [formData,setFormData] = useState({ addressTo : '', amount : '' , keyword : '', message : ''});
    const [isLoading,setIsLoading] = useState(false);
    const [ transactionCount,setTransactionCount] = useState(localStorage.getItem('transactionCount'));
    const [ transactions,setTransactions] = useState([]);
    

    const handleChange = (e, name) => {
        setFormData(prevState => ({...prevState, [name]: e.target.value}));
    }

    const getAllTransactions =async ()=> {
            try {
                if(!ethereum) return alert("please install metamask")
                const transactionContract = getEthereumContract();
                const availableTransactions = await transactionContract.getAllTransactions();

                const structuredTransactions = availableTransactions.map((transaction)=>({
                    addressTo : transaction.reciever,
                    addressFrom : transaction.sender,
                    timestamp : new Date(transaction.timestamp.toNumber() * 1000).toLocaleString(),
                    keyword : transaction.keyword,
                    message : transaction.message,
                    amount : parseInt(transaction.amount._hex) / (10 ** 18)
                }))
                console.log(structuredTransactions);
                setTransactions(structuredTransactions);
            } 
            catch (error) {
                console.log(error);
            }
    }

    const checkIfWalletIsConnected = async () => {
        if (!ethereum) return alert("please install metamask");

        const accounts = await ethereum.request({
            method : 'eth_accounts'
        });

        if(accounts){
            setConnectedAccount(accounts[0]);
            getAllTransactions();
        }
    }

    const checkIfTransactionsExist = async () => {
        try {
            const transactionContract = getEthereumContract();
            const transactionCount = await transactionContract.getTransctionCount();

            window.localStorage.setItem("transactionCount",transactionCount);

        } catch (error) {
            console.log(error);
        }
    }

    const connectWallet = async ()=>{
        try {
            if (!ethereum) return alert("please install metamask");
            const accounts = await ethereum.request({
                method : 'eth_requestAccounts'
            });

            setConnectedAccount(accounts[0]);
            window.location.reload();

        } catch (error) {
            console.log(error)
            throw new Error("No ethereum object");
        }
    }

    const sendTransaction =async ()=> {
        try {
            if(!ethereum) return alert("please install metamask");

            const {addressTo , amount, keyword, message} = formData;
            const transactionContract = getEthereumContract();
            const parsedAmount = ethers.utils.parseEther(amount);
            

            await ethereum.request(
                {
                    method : 'eth_sendTransaction',
                    params : [{
                        from : connectedAccount,
                        to : addressTo,
                        gas : '0x5208',
                        value : parsedAmount._hex,
                    }]
                }
            );
           const transactionHash = await transactionContract.addtoBlockchain(addressTo,parsedAmount,message,keyword);
           
           setIsLoading(true);
           console.log(`loading ${transactionHash.hash}`);
           await transactionHash.wait();
           setIsLoading(false);
           console.log(`success ${transactionHash.hash}`);  

           const transactionCount = await transactionContract.getTransctionCount();
           setTransactionCount(transactionCount.toNumber());

           
        } catch (error) {
            console.log(error);
            throw new Error("No ethereum object");
        }
    }

    useEffect(() => {
        checkIfWalletIsConnected();
        checkIfTransactionsExist();
    }, []);

    return(
        <TransactionContext.Provider value={{ connectWallet,connectedAccount, formData , sendTransaction, handleChange, isLoading, transactions}}>
            {children}
        </TransactionContext.Provider>
    );
}