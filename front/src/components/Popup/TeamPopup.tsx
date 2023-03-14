import React, { useState } from 'react';
import DatePicker from 'react-datepicker';
import { ko } from 'date-fns/esm/locale';
import 'react-datepicker/dist/react-datepicker.css';

function TeamPopup() {
  const [startDate, setStartDate] = useState(new Date());
  const [endDate, setEndDate] = useState(new Date());

  return (
    <div className='border flex flex-col justify-center items-center m-auto bg-white w-[480px] h-[600px] rounded-[30px]'>
      <p className='font-bold text-[25px] p-7'>스프린트 생성</p>
      <div className='mb-4 w-[430px]'>
        <p className='font-bold text-[20px]'>제목</p>
        <input
          className='text-[20px] w-[430px] border-b-2'
          placeholder='제목을 입력해주세요.'
        />
      </div>
      <div className='mb-4 w-[430px]'>
        <p className='font-bold text-[20px]'>기간</p>
        <div className='flex'>
          <DatePicker
            className='border'
            locale={ko}
            dateFormat='yyyy년 MM월 dd일'
            minDate={new Date()}
            selected={startDate}
            onChange={(date: Date) => setStartDate(date)}
          />
          <DatePicker
            className='border'
            locale={ko}
            dateFormat='yyyy년 MM월 dd일'
            minDate={new Date()}
            selected={endDate}
            onChange={(date: Date) => setEndDate(date)}
          />
        </div>
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
      <button
        type='button'
        className='flex justify-center items-center w-[100px] h-[40px] rounded-[30px] bg-[#0075FF] text-white text-[12px]'
      >
        생성하기
      </button>
    </div>
  );
}

export default TeamPopup;
