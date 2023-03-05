import React from 'react';
import DropDown from '../DropDown';
import sprint from '../../../images/members.png';

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
      <DropDown />
    </div>
  );
}

export default SprintMasterProfile;
