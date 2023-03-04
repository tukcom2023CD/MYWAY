import React from 'react';
import Menu from '../../components/frames/Sidebar';
import Profile from '../../components/frames/Profile';
import SprintPageList from '../../components/project/SprintPageList';
import TaskList from '../../components/project/TaskList';
import MemberList from '../../components/project/MemberList';

function Sprint() {
  return (
    <div className='flex m-auto w-[1440px] h-[100vh] bg-[#D8F1FF]'>
      <Menu />
      <div className='flex flex-col justfiy-center items-center m-auto w-[1024px] h-[800px]'>
        <Profile />
        <div className='flex justify-center items-center m-auto'>
          <SprintPageList />
          <div className='flex flex-col justify-center items-center m-auto'>
            <TaskList />
            <MemberList />
          </div>
        </div>
      </div>
    </div>
  );
}

export default Sprint;
