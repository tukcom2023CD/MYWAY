import React, { useState } from 'react';
import dots from '../../images/dots.png';

function DropDown() {
  const [isOpen, setIsOpen] = useState(false);
  const onToggle = () => setIsOpen(!isOpen);

  return (
    <div className='ml-auto flex jusify-center items-center h-[20px]'>
      <button
        type='button'
        className='ml-auto w-[30px] h-[30px] rounded-[30px]'
        onClick={onToggle}
      >
        <img
          className='w-[24px] h-[24px] m-auto rounded-[30px] opacity-50'
          alt='ProfileImg'
          src={dots}
        />
      </button>
      <div>
        <ul className='flex flex-col w-[100%] h-[100%] list-none overfolw-y-scroll'>
          {isOpen && (
            <>
              <li className='flex justify-center items-center font-[12pt] border bg-white'>
                마스터 지정
              </li>
              <li className='flex justify-center items-center font-[12pt] border bg-white'>
                이동
              </li>
              <li className='flex justify-center items-center font-[12pt] border bg-white'>
                퇴장
              </li>
            </>
          )}
        </ul>
      </div>
    </div>
  );
}

export default DropDown;
