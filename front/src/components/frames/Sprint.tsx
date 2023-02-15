import React from 'react';
import SprintImg from '../../images/project.png';

function Sprint() {
  return (
    <div className='flex justify-start items-center w-[440px] h-[30px] mb-2 bg-[#DBDBDB] rounded-[30px]'>
      <img
        className='w-[30px] h-[30px] bg-gray-400 rounded-[30px]'
        alt='ProfileImg'
        src={SprintImg}
      />
      <div className='flex justify-center items-center ml-5'>스프린트명</div>
      <div className='flex justify-center items-center ml-5'>담당자</div>
    </div>
  );
}

export default Sprint;
