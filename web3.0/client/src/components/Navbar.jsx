import {Link} from 'react-router-dom'
import {HiMenuAlt4} from 'react-icons/hi'
import {AiOutlineClose} from 'react-icons/ai'
import img from '../resources/img1.jpg'
import { useState } from 'react';


const NavbarItem = ({title, classProps})=>{
    return(
        <li className={`mx-4 cursor-pointer ${classProps}`}>
            <Link to={title}>{title}</Link>
        </li>
    );
}





const Navbar = ()=>{
    const [toggleMenu,SetToggleMenu] = useState(false);
    return(
        <nav className='w-full flex md:justify-center justify-between items-center p-4'>
            <div className='md:flex-[0.5] flex-initial justify-center items-center'>
                <img src={img} alt="logo" className='w-32 cursor-pointer' />
            </div>
            <ul className='text-white md:flex hidden list-none flex-row justify-between items-center flex-initial'>
                <li className={`mx-4 cursor-pointer my-2 text-lg`}>
                    <Link to='Donate'>Donate</Link>
                </li>
                <li className={`mx-4 cursor-pointer my-2 text-lg`}>
                    <a href='https://ethereum.org/en/'>Exchange</a>
                </li>
                <li className={`mx-4 cursor-pointer my-2 text-lg`}>
                    <a href='https://metamask.io/'>Wallet</a>
                </li>
            </ul>
            <div className='flex relative'>
                {toggleMenu 
                ? <AiOutlineClose fontSize={28} className='text-white md:hidden cursor-pointer' onClick={()=> SetToggleMenu(false)} />
                : <HiMenuAlt4 fontSize={28} className='text-white md:hidden cursor-pointer' onClick={()=> SetToggleMenu(true)}/>
                }
                {toggleMenu && (
                    <ul className='z-10 fixed top-0 -right-2 p-3 w-[70vw] h-screen shadow-2xl md:hidden list-none flex
                                    flex flex-col justify-start items-end rounded-md blue-glassmorphism text-white animate-slide-in 
                    '>
                        <li className='text-xl w-full my-2'>
                            <AiOutlineClose onClick={() => SetToggleMenu(false)} />
                        </li>
                        <li className={`mx-4 cursor-pointer my-2 text-lg`}>
                    <Link to='Donate'>Donate</Link>
                </li>
                <li className={`mx-4 cursor-pointer my-2 text-lg`}>
                    <a href='https://ethereum.org/en/'>Exchange</a>
                </li>
                <li className={`mx-4 cursor-pointer my-2 text-lg`}>
                    <a href='https://metamask.io/'>Wallet</a>
                </li>
                    </ul>
                )}
            </div>
        </nav>
    );
}

export default Navbar;