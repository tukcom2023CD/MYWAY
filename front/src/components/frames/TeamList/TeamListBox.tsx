import React from 'react';
import Teams from './Teams';
import TeamPopup from '../../Popup/TeamPopup';

function TeamListBox() {
  return (
    <div className='flex flex-col justfiy-center items-center h-[100vh]'>
      <p className='font-bold text-[30px] mt-[10vh] mb-5'>CreWship</p>
      <div className='border flex flex-col mb-5 w-full h-[500px] rounded-[30px] shadow-md overflow-y-auto'>
        <Teams />
      </div>
      <TeamPopup />
    </div>
  );
}

export default TeamListBox;
