import React from 'react';
import Members from '../main/Member';

function MemberList() {
  return (
    <div className='flex flex-col justify-center items-right bg-white w-[500px] h-[420px] rounded-[30px]'>
      <div className='flex justify-center items-bottom w-[500px] h-[50px] p-6 mb-3'>
        <p className='mr-auto text-[20px] font-bold'>Members</p>
        <button
          type='button'
          className='flex justify-center items-center w-[100px] h-[40px] rounded-[30px] bg-[#0075FF] text-white text-[12px]'
        >
          <p className='flex justfiy-center items-center text-[24px]'>+</p>
          멤버 추가
        </button>
      </div>
      <div className='flex flex-col justify-start w-[500px] h-[400px] p-5 overflow-y-auto'>
        <Members />
        <Members />
        <Members />
        <Members />
        <Members />
        <Members />
        <Members />
        <Members />
        <Members />
        <Members />
        <Members />
        <Members />
        <Members />
        <Members />
        <Members />
        <Members />
        <Members />
        <Members />
        <Members />
        <Members />
        <Members />
        <Members />
        <Members />
        <Members />
      </div>
    </div>
  );
}

export default MemberList;
