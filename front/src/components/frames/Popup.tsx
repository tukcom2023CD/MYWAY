import React from 'react';
import SprintProgress from './SprintFrames/SprintProgress';
import SprintMemberNum from './SprintFrames/SprintMemberNum';
import Member from '../../images/members.png';

function Popup() {
  return (
    <div className='flex flex-col justify-center items-right bg-white w-[500px] h-[420px] rounded-[30px]'>
      <div className='flex justify-center items-bottom w-[500px] h-[50px] p-6 mb-3'>
        <p className='mr-auto text-[20px] font-bold'>Popup</p>
        <div className='flex justify-center items-center'>
          <img
            className='w-[24px] h-[24px] bg-gray-400 rounded-[30px] mr-1'
            alt='ProfileImg'
            src={Member}
          />
          <p>리더이름/조직/직책</p>
        </div>
        <div className='flex justify-center items-center space-x-4'>
          <SprintProgress />
          <SprintMemberNum />
        </div>
      </div>
    </div>
  );
}

export default Popup;
