import React from 'react';
import TeamListBox from '../../components/frames/TeamList/TeamListBox';
import Modal from '../../components/Popup/TeamPopup';

function TeamList() {
  return (
    <div className='flex flex-col justify-center items-center m-auto w-[100vw] h-[100vh]'>
      <TeamListBox />
      <Modal />
    </div>
  );
}

export default TeamList;
