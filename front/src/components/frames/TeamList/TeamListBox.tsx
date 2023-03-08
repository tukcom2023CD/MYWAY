import React from 'react';
import Teams from './Teams';

function TeamListBox() {
  return (
    <div className='border flex flex-col justfiy-center items-center m-auto w-[500px] h-[600px]'>
      <div className='border flex flex-col mb-5 w-full h-[500px] overflow-y-auto'>
        <Teams />
      </div>
      <button
        type='button'
        className='flex justify-center items-center ml-auto w-[100px] h-[40px] rounded-[16px] bg-[#1AAAFB] text-white'
      >
        팀 생성하기
      </button>
    </div>
  );
}

export default TeamListBox;
