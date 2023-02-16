import React from 'react';
import TaskImg from '../../images/project.png';

function TaskList() {
  return (
    <div className='flex justify-start items-center w-[440px] h-[30px] mb-2 bg-[#DBDBDB] rounded-[30px]'>
      <img
        className='w-[30px] h-[30px] bg-gray-400 rounded-[30px]'
        alt='ProfileImg'
        src={TaskImg}
      />
      <div className='flex justify-center items-center ml-5'>태스크1</div>
      <div className='flex justify-center items-center ml-5'>30pt</div>
    </div>
  );
}

export default TaskList;
