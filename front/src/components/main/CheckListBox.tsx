import React from 'react';
import { NavLink } from 'react-router-dom';
import refresh from '../../images/refresh.png';
import taskImg from '../../images/rightarrow.png';
import progressImg from '../../images/minichart.png';

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
      <div className='flex m-auto w-[400px] h-[320px] bg-gray-100 overflow-auto'>
        <ul className='p-6 list-disc space-y-5'>
          <li className='mr-auto w-[350px] text-[20px] flex flex-col'>
            <div className='flex justify-between items-center'>
              <p className='font-bold'>진행중인 테스크</p>
              <NavLink
                to='/task'
                className='flex justify-center items-center w-[40px] h-[40px] rounded-[15px] bg-[#4d4d4d] text-white text-[12px]'
              >
                <img
                  className='w-[24px] h-[24px]'
                  alt='taskImg'
                  src={taskImg}
                />
              </NavLink>
            </div>
            <div className='flex justify-start items-center space-x-6 mb-2'>
              <div className='text-lg'>스프린트12</div>
              <div className='flex text-[15px]'>
                <img
                  className='w-[24px] h-[24px] mr-2'
                  alt='progressImg'
                  src={progressImg}
                />
                67%
              </div>
            </div>
            <div className='flex flex-col justify-start items-start bg-white rounded-[10px] w-[350px] h-[200px] mb-2'>
              <div className='flex justify-between items-center border p-3 w-full text-sm rounded-t-[10px]'>
                <p>최종 데모</p>
                <p>30P</p>
              </div>
              <div className='flex justify-between items-center border p-3 w-full text-sm'>
                <p>sample</p>
                <p>개발, 커뮤니케이션</p>
              </div>
              <div className='flex justify-between items-start border p-3 w-full h-full text-sm rounded-b-[10px]'>
                <p>최종 데모 체크</p>
              </div>
            </div>
          </li>
        </ul>
      </div>
    </div>
  );
}

export default CheckListBox;
