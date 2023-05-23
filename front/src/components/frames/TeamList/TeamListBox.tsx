import React from 'react';
import Teams from './Teams';
import TeamPopup from '../../Popup/TeamPopup';
import FixProfile from './FixProfile';
import InviteList from './AcceptInvite';
import InviteApprove from './AcceptApply';

function TeamListBox() {
  return (
    <div className='flex flex-col justfiy-center items-center h-[100vh]'>
      <p className='font-bold text-[30px] mt-[9vh] mb-6'>CreWship</p>
      <div className='border flex flex-col mb-5 w-full h-[500px] rounded-[30px] shadow-md overflow-y-auto'>
        <Teams />
      </div>
      <TeamPopup />
      <div className='flex flex-col mr-auto items-center space-y-2'>
        <FixProfile />
        <InviteList />
        <InviteApprove />
      </div>
    </div>
  );
}

export default TeamListBox;
