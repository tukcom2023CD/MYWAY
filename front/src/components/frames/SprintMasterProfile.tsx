import React from 'react';
import sprint from '../../images/members.png';
import dots from '../../images/dots.png';

function SprintMasterProfile() {
  return (
    <div className='flex justify-center items-center m-auto w-[440px] h-[30px] mb-2 bg-[#DBDBDB] rounded-[30px]'>
      <img
        className='w-[30px] h-[30px] bg-gray-400 rounded-[30px]'
        alt='ProfileImg'
        src={sprint}
      />
      <div className='flex justify-center items-center ml-5'>이름</div>
      <div className='flex justify-center items-center ml-5'>조직</div>
      <div className='flex justify-center items-center ml-5'>직책</div>
      <button
        type='button'
        className='ml-auto w-[30px] h-[30px] rounded-[30px]'
      >
        <img
          className='w-[24px] h-[24px] m-auto rounded-[30px] opacity-50'
          alt='ProfileImg'
          src={dots}
        />
      </button>
    </div>
  );
}

export default SprintMasterProfile;
