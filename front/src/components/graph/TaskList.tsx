import React from 'react';
import Task from '../frames/Task';

function TaskList() {
  return (
    <div className='border flex flex-col justify-center items-right mr-[24px] bg-white w-[500px] h-[300px] rounded-[30px]'>
      <div className='flex justify-center items-bottom w-[500px] h-[50px] p-6 mb-3'>
        <p className='m-auto text-[20px] font-bold'>진행중인 태스크 목록</p>
      </div>
      <div className='flex flex-col justify-start w-[500px] h-[400px] p-5 overflow-y-auto'>
        <Task />
      </div>
    </div>
  );
}

export default TaskList;
