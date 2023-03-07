import React from 'react';
import { NavLink } from 'react-router-dom';
import monitortest from '../../../images/monitortest.png';

function WelcomeStart() {
  return (
    <div className='flex justify-center items-center m-auto w-full h-[92vh]'>
      <div className='flex flex-col justify-center items-center m-auto w-[50vw] h-[92vh]'>
        <div className='justify-start'>
          <p className='text-[30px] mb-10 font-bold whitespace-pre-line'>
            기존의 성과 관리 제도를 대신 할{'\n'}애자일 성과분석 시스템
          </p>
          <p className='text-[18px] mb-10 whitespace-pre-line'>
            이슈 해결에 따른 기여 점수 부여를 통한{'\n'}개인 성과 정량화 및
            모니터링 기능을 제공합니다.{'\n'}이를 통해 신뢰도 높은 인적
            의사결정을 할 수 있습니다.
          </p>
          <NavLink
            className='flex justify-center items-center w-[300px] h-[40px] rounded-[16px] bg-[#1AAAFB] text-white'
            to='/Login'
          >
            <span>시작하기</span>
          </NavLink>
        </div>
      </div>
      <div className='flex flex-col justify-end items-center m-auto w-[50vw] h-[92vh]'>
        <img
          className='w-[646px] h-[512px]'
          alt='welcometest'
          src={monitortest}
        />
      </div>
    </div>
  );
}

export default WelcomeStart;
