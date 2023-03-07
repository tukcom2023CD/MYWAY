import React from 'react';
import monitortest from '../../../images/monitortest.png';

function WelcomeSprint() {
  return (
    <div className='flex justify-center items-center m-auto w-full h-[100vh]'>
      <div className='flex flex-col justify-center items-center m-auto w-[50vw] h-[100vh]'>
        <div className='justify-start'>
          <p className='text-[30px] mb-10 font-bold whitespace-pre-line'>
            스프린트 & 테스크
          </p>
          <p className='text-[18px] mb-10 whitespace-pre-line'>
            프로젝트마다 스프린트를 개설하여 멤버들에게{'\n'}테스크를
            제공합니다.{'\n'}테스크를 해결할 때 마다 해당되는 어빌리티 포인트를
            {'\n'}획득할 수 있습니다.{'\n'}어빌리티 포인트들을 종합하여
            성과분석에 반영할 수 있습니다.
          </p>
        </div>
      </div>
      <div className='flex flex-col justify-end items-center m-auto w-[50vw] h-[100vh]'>
        <img
          className='w-[646px] h-[512px] mb-[100px]'
          alt='welcometest'
          src={monitortest}
        />
      </div>
    </div>
  );
}

export default WelcomeSprint;
