import React from 'react';
import LogoWhite from './LogoWhite';
import login from '../../../images/login.png';

function AfterLoginHeader() {
  return (
    <div className='fixed top-0 w-full'>
      <div className='flex justify-around items-center h-[70px] bg-[#404040]'>
        <LogoWhite />
        <div />
        <div />
        <img className='w-[24px] h-[24px]' alt='login' src={login} />
      </div>
    </div>
  );
}

export default AfterLoginHeader;
