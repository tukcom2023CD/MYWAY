import React from 'react';
import SprintMaster from './SprintMater';

function SprintList() {
  return (
    <div className='flex flex-col justify-center items-right mr-[24px] bg-white w-[500px] h-[420px] rounded-[30px]'>
      <div className='flex justify-center items-bottom w-[500px] h-[50px] p-6 mb-3'>
        <p className='mr-auto p-2 text-[24px] font-bold'>스프린트</p>
      </div>
      <div className='border flex flex-col justify-start w-[500px] h-[400px] p-5 overflow-y-auto'>
        <SprintMaster />
      </div>
    </div>
  );
}

export default SprintList;
