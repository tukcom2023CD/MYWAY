import React, { useState, useCallback } from 'react';
import Teams from './Teams';
import Popup from '../../Popup/Popup';
import rightarrow from '../../../images/rightarrow.png';

function TeamListBox() {
  const [isOpenPopup, setOpenPopup] = useState<boolean>(false);

  const openPopup = useCallback(() => {
    setOpenPopup(!isOpenPopup);
  }, [isOpenPopup]);

  const closePopup = () => {
    setOpenPopup(!isOpenPopup);
  };

  return (
    <div className='flex flex-col justfiy-center items-center h-[100vh]'>
      <p className='font-bold text-[30px] mt-[10vh] mb-5'>CreWship</p>
      <div className='flex justify-between w-full mb-5'>
        <div className='border w-[300px] h-full text-[20px] font-bold text-center pt-1'>
          선택한 항목 없음
        </div>
        <button
          type='button'
          className='flex justify-center items-center w-[100px] h-[40px] rounded-[999px] bg-[#1AAAFB] text-white'
        >
          열기
          <img
            className='w-[24px] h-[24px] ml-2 color-white'
            alt='rightarrow'
            src={rightarrow}
          />
        </button>
      </div>
      <div className='border flex flex-col mb-5 w-full h-[500px] rounded-[30px] shadow-md overflow-y-auto'>
        <Teams />
      </div>
      {isOpenPopup && (
        <Popup onClickTogglePopup={openPopup} onClosePopup={closePopup} />
      )}
      <button
        type='button'
        onClick={openPopup}
        className='flex justify-center items-center ml-auto w-[100px] h-[40px] rounded-[999px] bg-[#1AAAFB] text-white'
      >
        팀 생성하기
      </button>
    </div>
  );
}

export default TeamListBox;
