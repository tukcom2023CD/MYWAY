import React from 'react';
import { NavLink } from 'react-router-dom';
import Logo from './Logo';
import login from '../../../images/login.png';

function WelcomeHeader() {
  return (
    <div className='fixed border w-full p-5 bg-white'>
      <div className='flex justify-center'>
        <Logo />
        <div />
        <NavLink
          className='flex justify-center items-center w-[100px] h-[40px] rounded-[16px] ml-auto mr-[200px]'
          to='/Logout'
        >
          <img className='w-[24px] h-[24px] mr-2' alt='login' src={login} />
          <span>Login</span>
        </NavLink>
      </div>
    </div>
  );
}

export default WelcomeHeader;
