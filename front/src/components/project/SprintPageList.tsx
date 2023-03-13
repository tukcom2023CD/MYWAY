import React from 'react';
import Sprints from '../frames/SprintFrames/Sprint';
import SprintDetail from '../frames/SprintFrames/SprintDetail';

function SprintPageList() {
  return (
    <div className='flex flex-col justify-center items-right mr-[24px] bg-white w-[500px] h-[700px] rounded-[30px]'>
      <div className='flex justify-center items-center w-[500px] h-[50px] p-6 mb-3'>
        <p className='mr-auto p-2 text-[24px] font-bold'>스프린트</p>
        <button
          type='button'
          className='flex justify-center items-center w-[100px] h-[40px] rounded-[30px] bg-[#0075FF] text-white text-[12px]'
        >
          <p className='flex justfiy-center items-center text-[24px]'>+</p>
          스프린트 추가
        </button>
      </div>
      <div className='flex flex-col justify-center items-center w-[500px] h-[600px] overflow-y-auto overflow-x-hidden'>
        <Sprints />
        <SprintDetail />
        <Sprints />
        <Sprints />
      </div>
    </div>
  );
}

export default SprintPageList;
