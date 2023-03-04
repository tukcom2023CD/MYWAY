import React from 'react';

function CheckList() {
  return (
    <div className='bg-[#DBDBDB] flex justfiy-center items-center w-[460px] h-[40px] p-3 mb-[20px] rounded-[30px] text-[#8C8C8C]'>
      <input type='checkbox' checked className='default:ring-1 mr-1' />
      완료된 항목
    </div>
  );
}

export default CheckList;
