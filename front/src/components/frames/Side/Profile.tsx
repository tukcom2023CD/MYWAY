import React from 'react';
import ProfileImg from '../../../images/members.png';

function Profile() {
  return (
    <div className='flex justify-center items-center mr-auto w-[150px] h-[50px] rounded-[30px]'>
      <img
        className='w-[30px] h-[30px] bg-gray-400 rounded-[30px] mr-auto'
        alt='ProfileImg'
        src={ProfileImg}
      />
      <div className='flex justify-center items-center m-auto ml-1'>닉네임</div>
    </div>
  );
}

export default Profile;
