import React from 'react';
import { NavLink } from 'react-router-dom';
import refresh from '../../images/refresh.png';

function CheckListBox() {
  return (
    <div className='flex flex-col bg-white w-[450px] h-[400px] border'>
      <div className='flex justify-between items-center p-5 h-[50px] bg-[#6A6A6A]'>
        <p className='text-white text-md font-bold'>진행사항 알리미</p>
        <img
          className='w-[24px] h-[24px] bg-[#EAEAEA] rounded-[5px]'
          alt='refresh'
          src={refresh}
        />
      </div>
      <div className='flex m-auto w-[400px] h-[320px] bg-gray-50 overflow-auto'>
        <ul className='p-6 list-disc space-y-5'>
          <li className='mr-auto w-[300px] text-[20px] flex flex-col'>
            - 스프린트1
            <div className='flex space-x-6 justify-center items-center'>
              <div className='text-[15px]'>테스트 테스크</div>
              <div className='text-[15px]'>진행률 0%</div>
              <NavLink
                to='/task1'
                className='flex justify-center items-center w-[100px] h-[40px] rounded-[30px] bg-[#0075FF] text-white text-[12px]'
              >
                테스크로 이동
              </NavLink>
            </div>
          </li>
        </ul>
      </div>
    </div>
  );
}

export default CheckListBox;
