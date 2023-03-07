import React from 'react';
import welcomeproject from '../../../images/welcomeproject.png';

function WelcomeProject() {
  return (
    <div className='flex w-full h-[100vh] p-[150px]'>
      <div className='justify-start ml-[100px]'>
        <p className='text-[30px] mb-10 font-bold whitespace-pre-line'>
          한 번에 관리하는 프로젝트
        </p>
        <p className='text-[18px] mb-10 whitespace-pre-line'>
          프로젝트의 진행사항과 일정, 그리고 성과 분석 현황까지{'\n'}한 눈에
          확인할 수 있습니다.
        </p>
        <img
          className='w-[1440px] h-[512px]'
          alt='welcometest'
          src={welcomeproject}
        />
      </div>
    </div>
  );
}

export default WelcomeProject;
