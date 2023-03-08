import React from 'react';

function TeamListBox() {
  return (
    <div className='border flex flex-col justfiy-center items-center m-auto w-[500px] h-[600px] overflow-auto'>
      <div className='border flex flex-col justify-center items-center w-full h-[500px]' />
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
