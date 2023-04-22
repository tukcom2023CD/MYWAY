import React from 'react';
import Menu from '../../components/frames/Side/Sidebar';
import ProjectPopup from '../../components/Popup/ProjectPopup';

function Project() {
  return (
    <div className='flex m-auto w-[1440px] h-[100vh] bg-[#D8F1FF]'>
      <Menu />
      <div className='flex flex-col justfiy-center items-center m-auto w-[1024px] h-[800px] bg-white rounded-[50px]'>
        <div className='flex p-7 justify-center items-center space-x-[650px]'>
          <p className='text-[20px] font-bold'>프로젝트 리스트</p>
          <ProjectPopup />
        </div>
        <ul className='p-5 space-y-3 mb-[50px] w-[950px] h-[650px] bg-gray-200 overflow-auto'>
          <li className='flex justify-start pl-4 items-center m-auto w-[850px] h-[50px] bg-white'>
            프로젝트1
          </li>
          <li className='flex justify-start pl-4 items-center m-auto w-[850px] h-[50px] bg-white'>
            프로젝트2
          </li>
          <li className='flex justify-start pl-4 items-center m-auto w-[850px] h-[50px] bg-white'>
            프로젝트3
          </li>
        </ul>
      </div>
    </div>
  );
}

export default Project;
