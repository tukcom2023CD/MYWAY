import React from 'react';
import Header from '../Header/AfterLoginHeader';
import Teams from './Teams';
import TeamPopup from '../../Popup/TeamPopup';
// import FixProfile from './FixProfile';
// import InviteList from './AcceptInvite';
// import InviteApprove from './AcceptApply';

function TeamListBox() {
  return (
    <div className='flex flex-col justify-center items-center w-full'>
      <Header />
      <div className='flex mb-3 w-[500px] justify-between items-center'>
        <p className='font-bold text-[24px]'>진행중인 프로젝트</p>
        <TeamPopup />
      </div>
      <div className='border flex flex-col mb-5 w-[500px] h-[500px] rounded-[30px] shadow-md overflow-y-auto'>
        <Teams />
      </div>
      {/* <div className='flex flex-col mr-auto items-center space-y-2'>
        <FixProfile />
        <InviteList />
        <InviteApprove />
      </div> */}
    </div>
  );
}

export default TeamListBox;
