import React from 'react';
import Header from '../../components/Header';

function TicketMain() {
  return (
    <div>
      <div className='w-[100vw] h-[100vh] bg-[#0080FF]'>
        <Header />
        <div className='flex justify-center items-center m-auto mt-[30px] p-[30px] w-[93vw] h-[85vh] bg-[#6CF0E0]'>
          <button
            type='button'
            className='mr-[7rem] w-[15rem] h-[15rem] bg-white font-bold text-black text-[20pt]'
          >
            티켓 생성
          </button>
          <button
            type='button'
            className='mr-[7rem] w-[15rem] h-[15rem] bg-white font-bold text-black text-[20pt]'
          >
            일정 / 스크럼
          </button>
          <button
            type='button'
            className='w-[15rem] h-[15rem] bg-white font-bold text-black text-[20pt]'
          >
            그래프
          </button>
        </div>
      </div>
    </div>
  );
}

export default TicketMain;
