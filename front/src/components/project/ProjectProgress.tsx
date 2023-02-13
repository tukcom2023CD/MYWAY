import React from 'react';

function ProjectProgress() {
  return (
    <div className='bg-white w-[500px] h-[140px] rounded-[30px] mb-[20px]'>
      <div className='flex items-center p-4 mt-2'>
        <p className='ml-3 mr-auto text-[20px] font-bold'>프로젝트 진행도</p>
        <div className='mr-3 text-[30px] font-bold'>45%</div>
      </div>
      <div className='m-auto w-[450px] bg-gray-200 rounded-full h-2.5'>
        <div className='bg-blue-600 h-2.5 rounded-full w-[45%]' />
      </div>
    </div>
  );
}

export default ProjectProgress;
