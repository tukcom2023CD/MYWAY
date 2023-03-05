import React from 'react';
import Member from '../../../images/members.png';

function SprintMemberNum() {
  return (
    <div className='flex space-x-1 justify-center items-center m-auto'>
      <img
        className='w-[24px] h-[24px] bg-gray-400 rounded-[30px] mr-1'
        alt='ProfileImg'
        src={Member}
      />
      <p>5/n</p>
    </div>
  );
}

export default SprintMemberNum;
