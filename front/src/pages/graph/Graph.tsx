import React from 'react';
import Menu from '../../components/frames/Side/Sidebar';
import ProjectProgress from '../../components/main/ProjectProgress';
import AnalysisContribute from '../../components/graph/AnalysisContribute';
import profileImg from '../../images/members.png';

function Graph() {
  return (
    <div className='flex m-auto w-[1440px] h-[100vh]'>
      <Menu />
      <div className='flex flex-col justfiy-center items-center m-auto w-[1024px] h-[800px] bg-white rounded-[10px] border overflow-y-auto'>
        <div
          className='flex justify-between items-center w-full p-5 h-[50px] bg-[#6A6A6A]'
          style={{ position: 'sticky', top: 0, zIndex: 999 }}
        >
          <p className='text-white text-md font-bold'>프로젝트</p>
        </div>
        <div className='flex mt-5 mb-3'>
          <div className='flex flex-col justify-start items-start p-3 w-[300px] mr-[50px]'>
            <p className='font-bold text-lg'>프로젝트 마스터</p>
            <div className='flex justify-center items-start space-x-5'>
              <div className='flex p-2 bg-[#d4d4d4] rounded-[20px]'>
                <img
                  className='w-[24px] h-[24px] mr-3 border-black border-2 rounded-full'
                  alt='profileImg'
                  src={profileImg}
                />
                sample
              </div>
              <div className='flex p-2 bg-[#d4d4d4] rounded-[20px]'>
                <img
                  className='w-[24px] h-[24px] mr-3 border-black border-2 rounded-full'
                  alt='profileImg'
                  src={profileImg}
                />
                3명
              </div>
            </div>
          </div>
          <ProjectProgress />
        </div>
        <AnalysisContribute />
      </div>
    </div>
  );
}

export default Graph;
