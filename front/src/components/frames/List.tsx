import React from 'react';

function List() {
  return (
    <div className='flex flex-col justify-center items-right mr-[24px] bg-white w-[500px] h-[420px] rounded-[30px]'>
      <div className='flex justify-center items-bottom w-[500px] h-[50px] p-6 mb-3'>
        <p className='mr-auto text-[20px] font-bold'>리스트 박스</p>
        <button
          type='button'
          className='flex justify-center items-center w-[100px] h-[40px] rounded-[30px] bg-[#0075FF] text-white text-[12px]'
        >
          <p className='flex justfiy-center items-center text-[24px]'>+</p>
          항목 생성
        </button>
      </div>
      <div className='flex flex-col justify-start w-[500px] h-[400px] p-5 overflow-y-auto' />
    </div>
  );
}

export default List;
