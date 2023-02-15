import React from 'react';
import ProfileImg from '../../images/members.png';

function Member() {
  return (
    <div className='flex justify-start items-center w-[440px] h-[30px] mb-2 bg-[#DBDBDB] rounded-[30px]'>
      <img
        className='w-[30px] h-[30px] bg-gray-400 rounded-[30px]'
        alt='ProfileImg'
        src={ProfileImg}
      />
      <div className='flex justify-center items-center ml-5'>이름</div>
      <div className='flex justify-center items-center ml-5'>조직</div>
      <div className='flex justify-center items-center ml-5'>직책</div>
    </div>
  );
}

export default Member;
