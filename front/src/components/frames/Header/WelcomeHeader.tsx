import React from 'react';
import { NavLink } from 'react-router-dom';
import login from '../../../images/login.png';

function WelcomeHeader() {
  return (
    <div className='fixed border w-full p-5 bg-[#404040] text-white'>
      <div className='flex justify-around'>
        <p className='text-[20px] font-bold'>CreWship</p>
        <div />
        <NavLink
          className='flex justify-center items-center w-[100px] h-[40px] rounded-[16px]'
          to='/Logout'
        >
          <img className='w-[24px] h-[24px] mr-2' alt='login' src={login} />
          <span>Logout</span>
        </NavLink>
      </div>
    </div>
  );
}

export default WelcomeHeader;
