import React from 'react';
import SprintMaster from './SprintMater';
import Sprints from '../frames/SprintFrames/Sprint';

function SprintList() {
  return (
    <div className='flex flex-col justify-center items-right mr-[24px] bg-white w-[500px] h-[420px] rounded-[30px]'>
      <div className='flex justify-center items-bottom w-[500px] h-[50px] p-6 mb-3'>
        <p className='mr-auto p-2 text-[24px] font-bold'>스프린트</p>
      </div>
      <div className='flex flex-col justify-start w-[500px] h-[200px] p-5'>
        <SprintMaster />
      </div>
      <div className='flex flex-col justify-center items-center m-auto w-[500px] h-[400px] overflow-y-auto overflow-x-hidden'>
        <Sprints />
        <Sprints />
        <Sprints />
      </div>
    </div>
  );
}

export default SprintList;
