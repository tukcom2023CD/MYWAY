import React from 'react';
import Menu from '../../components/frames/Side/Sidebar';
import Profile from '../../components/frames/Side/Profile';
import ProjectCheckList from '../../components/main/ProjectCheckList';
import SprintList from '../../components/project/SprintList';
import MemberList from '../../components/project/MemberList';

function Project() {
  return (
    <div className='flex m-auto w-[1440px] h-[100vh] bg-[#D8F1FF]'>
      <Menu />
      <div className='flex flex-col justfiy-center items-center m-auto w-[1024px] h-[800px]'>
        <Profile />
        <ProjectCheckList />
        <div className='flex justify-center items-center m-auto'>
          <SprintList />
          <MemberList />
        </div>
      </div>
    </div>
  );
}

export default Project;
