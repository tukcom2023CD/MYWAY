import React from 'react';
import MiniChart from '../../images/minichart.png';

function SprintProgress() {
  return (
    <div className='flex space-x-1 justify-center items-center m-auto'>
      <img
        className='w-[24px] h-[24px] bg-gray-400 rounded-[30px] mr-1'
        alt='ProfileImg'
        src={MiniChart}
      />
      <p>70%</p>
    </div>
  );
}

export default SprintProgress;
