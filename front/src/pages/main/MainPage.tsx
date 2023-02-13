import React from 'react';
import Menu from '../../components/Sidebar';
import Profile from '../../components/Profile';
import CheckList from '../../components/main/CheckList';

function MainPage() {
  return (
    <div className='flex m-auto w-[1440px] h-[960px] bg-[#D8F1FF]'>
      <Menu />
      <div className='flex flex-col justfiy-center items-center m-auto w-[1024px] h-[800px]'>
        <Profile />
        <CheckList />
      </div>
    </div>
  );
}

export default MainPage;
