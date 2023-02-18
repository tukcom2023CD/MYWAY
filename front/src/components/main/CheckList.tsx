import React, { useState } from 'react';

function CheckList() {
  const [isChecked, setIsChecked] = useState(false);
  const checking = {
    color: 'black',
  };

  return (
    <div className='flex flex-col justify-center items-center mt-[30px] bg-white rounded-[30px] w-[1024px] h-[250px]'>
      <div className='flex justify-center items-center w-[960px] h-[50px] p-3 mb-3'>
        <p className='mr-auto text-[20px] font-bold'>일일체크리스트</p>
        <button
          type='button'
          className='flex justify-center items-center w-[100px] h-[40px] rounded-[30px] bg-[#0075FF] text-white'
        >
          <p className='flex justfiy-center items-center text-[24px]'>+</p>
          일정 추가
        </button>
      </div>
      <div className='grid grid-cols-2 items-center justify-center ml-[20px] w-[960px] h-[150px] overflow-y-auto'>
        <div className='bg-[#DBDBDB] flex justfiy-center items-center w-[460px] h-[40px] p-3 mb-[20px] rounded-[30px] text-[#8C8C8C]'>
          <input type='checkbox' checked className='default:ring-1 mr-1' />
          완료된 항목
        </div>
        <div className='bg-[#DBDBDB] flex justfiy-center items-center w-[460px] h-[40px] p-3 mb-[20px] rounded-[30px] text-[#8C8C8C]'>
          <input type='checkbox' className='default:ring-1 mr-1' />
          미완료된 항목
        </div>
        <div className='bg-[#DBDBDB] flex justfiy-center items-center w-[460px] h-[40px] p-3 mb-[20px] rounded-[30px] text-[#8C8C8C]'>
          <input type='checkbox' className='default:ring-1 mr-1' />
          미완료된 항목
        </div>
        <div className='bg-[#DBDBDB] flex justfiy-center items-center w-[460px] h-[40px] p-3 mb-[20px] rounded-[30px] text-[#8C8C8C]'>
          <input type='checkbox' className='default:ring-1 mr-1' />
          미완료된 항목
        </div>
      </div>
    </div>
  );
}

export default CheckList;
