import React from 'react';

function CheckListBox() {
  return (
    <div className='bg-white w-[450px] h-[400px] rounded-[30px]'>
      <div className='flex flex-col items-center p-4 mt-2'>
        <p className='ml-3 mr-auto text-[20px] font-bold'>진행사항 알리미</p>
        <div className='flex m-auto w-[400px] h-[320px] bg-gray-50 overflow-auto'>
          <ul className='p-6 list-disc space-y-5'>
            <li className='mr-auto w-[300px] text-[20px]'>진행사항1</li>
            <li className='mr-auto w-[300px] text-[20px]'>진행사항2</li>
            <li className='mr-auto w-[300px] text-[20px]'>진행사항3</li>
            <li className='mr-auto w-[300px] text-[20px]'>진행사항4</li>
            <li className='mr-auto w-[300px] text-[20px]'>진행사항5</li>
            <li className='mr-auto w-[300px] text-[20px]'>진행사항6</li>
            <li className='mr-auto w-[300px] text-[20px]'>진행사항7</li>
            <li className='mr-auto w-[300px] text-[20px]'>진행사항8</li>
          </ul>
        </div>
      </div>
    </div>
  );
}

export default CheckListBox;
