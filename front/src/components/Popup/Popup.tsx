/* eslint-disable jsx-a11y/click-events-have-key-events */
/* eslint-disable jsx-a11y/no-static-element-interactions */
import React, { PropsWithChildren } from 'react';

interface PopupDefaultType {
  onClickTogglePopup: () => void;
  onClosePopup: () => void;
}

function TeamPopup({
  onClickTogglePopup,
  onClosePopup,
}: PropsWithChildren<PopupDefaultType>) {
  return (
    <div className='w-[100vw] h-[100vh] flex justify-center items-center fixed bg-[rgba(0,0,0,0.2)]'>
      <div>
        <div className='border flex flex-col justify-center items-center m-auto bg-white w-[480px] h-[600px] rounded-[30px]'>
          <p className='font-bold text-[25px] p-7'>스프린트 생성</p>
          <div className='mb-4 w-[430px]'>
            <p className='font-bold text-[20px]'>제목</p>
            <input
              className='text-[20px] w-[430px] border-b-2'
              placeholder='제목을 입력해주세요.'
            />
          </div>
          <div className='flex flex-col mb-4 w-[430px]'>
            <p className='font-bold text-[20px] mb-2'>멤버</p>
            <button
              type='button'
              className='flex justify-center items-center w-[100px] h-[40px] rounded-[30px] bg-[#0075FF] text-white text-[12px] mb-2'
            >
              <p className='flex justfiy-center items-center text-[24px]'>+</p>
              멤버 추가
            </button>
            <input
              className='text-[20px] border-b-2 whitespace-pre-wrap mb-2'
              placeholder='멤버1'
            />
            <input
              className='text-[20px] border-b-2 whitespace-pre-wrap mb-2'
              placeholder='멤버2'
            />
          </div>
          <div className='mb-4 overflow-x-auto'>
            <p className='font-bold text-[20px]'>내용</p>
            <input
              className='text-[20px] w-[430px] border-b-2 whitespace-pre-wrap'
              placeholder='내용을 입력해주세요.'
            />
          </div>
          <div className='flex space-x-2'>
            <button
              type='button'
              className='flex justify-center items-center w-[100px] h-[40px] rounded-[30px] bg-[#0075FF] text-white text-[12px]'
            >
              생성하기
            </button>
            <button
              type='button'
              onClick={onClosePopup}
              className='flex justify-center items-center w-[100px] h-[40px] rounded-[30px] bg-[#0075FF] text-white text-[12px]'
            >
              닫기
            </button>
          </div>
        </div>
      </div>
      <div
        onClick={(e: React.MouseEvent) => {
          e.preventDefault();

          if (onClickTogglePopup) {
            onClickTogglePopup();
          }
          if (onClosePopup) {
            onClosePopup();
          }
        }}
      />
    </div>
  );
}

export default TeamPopup;
