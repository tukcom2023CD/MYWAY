import React from 'react';
import ProfileImg from '../images/members.png';

function Profile() {
  return (
    <div className='flex justify-center items-center mr-auto w-[300px] h-[50px] bg-white rounded-[30px]'>
      <img
        className='w-[50px] h-[50px] bg-gray-400 rounded-[30px] mr-auto'
        alt='ProfileImg'
        src={ProfileImg}
      />
      <div className='flex justify-center items-center m-auto ml-1'>이름</div>
      <div className='flex justify-center items-center m-auto ml-1'>조직</div>
      <div className='flex justify-center items-center m-auto ml-1'>직책</div>
    </div>
  );
}

export default Profile;
