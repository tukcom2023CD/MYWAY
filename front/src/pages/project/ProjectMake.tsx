import React from 'react';
import Header from '../../components/Header';

function ProjectMake() {
  return (
    <div>
      <div className='w-[100vw] h-[100vh] bg-[rgb(0,128,255)]'>
        <Header />
        <div className='flex justify-center items-center m-auto mt-[30px] p-[30px] w-[93vw] h-[85vh] bg-[#E27676]'>
          <div className='flex justify-center items-center m-auto border bold w-[10rem] h-[10rem]'>
            프로젝트 마스터 이미지
          </div>
          <div className='flex justify-center items-center m-auto border bold w-[10rem] h-[10rem]'>
            프로젝트 제목
          </div>
          <div className='flex justify-center items-center m-auto border bold w-[10rem] h-[10rem]'>
            스프린트 마스터 설정
          </div>
        </div>
      </div>
    </div>
  );
}

export default ProjectMake;
