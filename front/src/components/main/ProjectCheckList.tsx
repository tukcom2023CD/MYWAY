import React from 'react';

function ProjectCheckList() {
  return (
    <div className='flex flex-col justify-center items-center mt-[30px] bg-white rounded-[30px] w-[1024px] h-[250px]'>
      <div className='flex justify-center items-center w-[960px] h-[50px] p-3 mb-3'>
        <p className='mr-auto text-[20px] font-bold'>진행중인 프로젝트</p>
        <button
          type='button'
          className='flex justify-center items-center w-[100px] h-[40px] rounded-[30px] bg-[#0075FF] text-white text-[12px]'
        >
          <p className='flex justfiy-center items-center text-[24px]'>+</p>
          프로젝트 추가
        </button>
      </div>
      <div className='grid grid-cols-2 items-center justify-center ml-[20px] w-[960px] h-[150px] overflow-y-auto'>
        <div className='bg-[#DBDBDB] flex justfiy-center items-center w-[460px] h-[40px] p-3 mb-[20px] rounded-[30px] text-[#8C8C8C]'>
          <input type='checkbox' checked className='default:ring-1 mr-1' />
          선택한 프로젝트
        </div>
        <div className='bg-[#DBDBDB] flex justfiy-center items-center w-[460px] h-[40px] p-3 mb-[20px] rounded-[30px] text-[#8C8C8C]'>
          <input type='checkbox' className='default:ring-1 mr-1' />
          프로젝트
        </div>
        <div className='bg-[#DBDBDB] flex justfiy-center items-center w-[460px] h-[40px] p-3 mb-[20px] rounded-[30px] text-[#8C8C8C]'>
          <input type='checkbox' className='default:ring-1 mr-1' />
          프로젝트
        </div>
        <div className='bg-[#DBDBDB] flex justfiy-center items-center w-[460px] h-[40px] p-3 mb-[20px] rounded-[30px] text-[#8C8C8C]'>
          <input type='checkbox' className='default:ring-1 mr-1' />
          프로젝트
        </div>
      </div>
    </div>
  );
}

export default ProjectCheckList;
