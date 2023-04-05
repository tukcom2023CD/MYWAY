import React from 'react';
import Menu from '../../components/frames/Side/Sidebar';
import Profile from '../../components/frames/Profile';
import CheckList from '../../components/main/CheckListBox';
import Progress from '../../components/main/ProjectProgress';
import Contribution from '../../components/main/ProjectContribution';

function MainPage() {
  return (
    <div className='flex m-auto w-[1440px] h-[960px] bg-[#D8F1FF]'>
      <Menu />
      <div className='flex flex-col justfiy-center items-center m-auto w-[1024px] h-[800px]'>
        <Profile />
        <CheckList />
        <div className='flex justify-center items-center m-auto'>
          <div className='flex flex-col justify-center items-left w-[512px] h-[450px]'>
            <Progress />
            <Contribution />
          </div>
          <div className='flex flex-col justify-center items-center m-auto bg-white w-[500px] h-[420px] rounded-[30px]'>
            blank
          </div>
        </div>
      </div>
    </div>
  );
}

export default MainPage;
