import React from 'react';
import Tasks from './Tasks';

function TaskList() {
  return (
    <div className='flex flex-col justify-center items-right bg-white w-[500px] h-[280px] rounded-[30px] mb-3'>
      <div className='flex justify-center items-bottom w-[500px] h-[50px] p-6 mb-3'>
        <p className='mr-auto text-[20px] font-bold bg-[#d4d4d4]'>테스크</p>
        <button
          type='button'
          className='flex justify-center items-center w-[100px] h-[40px] rounded-[30px] bg-[#0075FF] text-white text-[12px]'
        >
          <p className='flex justfiy-center items-center text-[24px]'>+</p>
          테스크 생성
        </button>
      </div>
      <div className='flex flex-col justify-start w-[500px] h-[400px] p-5 overflow-y-auto'>
        <Tasks />
      </div>
    </div>
  );
}

export default TaskList;
