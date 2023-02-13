import React from 'react';
import Header from '../../components/Header';

function TicketMake() {
  return (
    <div>
      <div className='w-[100vw] h-[100vh] bg-[#0080FF]'>
        <Header />
        <div className='flex justify-center items-center m-auto mt-[30px] p-[30px] w-[93vw] h-[85vh] bg-[#6CF0E0]'>
          <button
            type='button'
            className='flex justify-center items-center m-auto border bold w-[10rem] h-[10rem]'
          >
            프로젝트 마스터 이미지
          </button>
          <button
            type='button'
            className='flex justify-center items-center m-auto border bold w-[10rem] h-[10rem]'
          >
            프로젝트 제목
          </button>
          <button
            type='button'
            className='flex justify-center items-center m-auto border bold w-[10rem] h-[10rem]'
          >
            스프린트 마스터 설정
          </button>
        </div>
      </div>
    </div>
  );
}

export default TicketMake;
