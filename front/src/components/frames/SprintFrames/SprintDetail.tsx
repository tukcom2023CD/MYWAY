import React from 'react';
import SprintProgress from './SprintProgress';
import SprintMemberNum from './SprintMemberNum';
import Member from '../../../images/members.png';

function SprintDetail() {
  return (
    <div className='flex justify-center items-center space-x-5 w-[440px] h-[400px] mb-2 bg-[#DBDBDB] rounded-[20px]'>
      <div className='flex justify-center items-center'>스프린트 이름</div>
      <div className='flex justify-center items-center'>
        <img
          className='w-[24px] h-[24px] bg-gray-400 rounded-[30px] mr-1'
          alt='ProfileImg'
          src={Member}
        />
        <p>리더이름/조직/직책</p>
      </div>
      <div className='flex justify-center items-center space-x-4'>
        <SprintProgress />
        <SprintMemberNum />
      </div>
    </div>
  );
}

export default SprintDetail;
