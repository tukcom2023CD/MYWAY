import React from 'react';
import Sprint from '../frames/SprintFrames/SprintMasterProfile';

function SprintMater() {
  return (
    <div>
      <div className='flex justify-center items-bottom w-[500px] h-[50px] p-6 mb-3'>
        <p className='mr-auto ml-[-10px] text-[20px] font-bold'>마스터</p>
      </div>
      <Sprint />
    </div>
  );
}

export default SprintMater;
