import React from 'react';
import Teams from './Teams';
import TeamPopup from '../../Popup/TeamPopup';
import rightarrow from '../../../images/rightarrow.png';

function TeamListBox() {
  return (
    <div className='flex flex-col justfiy-center items-center h-[100vh]'>
      <p className='font-bold text-[30px] mt-[10vh] mb-5'>CreWship</p>
      <div className='flex justify-between w-full mb-5'>
        <div className='border w-[300px] h-full text-[20px] font-bold text-center pt-1'>
          선택한 항목 없음
        </div>
        <button
          type='button'
          className='flex justify-center items-center w-[100px] h-[40px] rounded-[999px] bg-[#1AAAFB] text-white'
        >
          열기
          <img
            className='w-[24px] h-[24px] ml-2 color-white'
            alt='rightarrow'
            src={rightarrow}
          />
        </button>
      </div>
      <div className='border flex flex-col mb-5 w-full h-[500px] rounded-[30px] shadow-md overflow-y-auto'>
        <Teams />
      </div>
      <TeamPopup />
    </div>
  );
}

export default TeamListBox;
