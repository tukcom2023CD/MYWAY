import React from 'react';
import Kakao from '../../images/kakaoIcon.png';
import Naver from '../../images/naverIcon.png';
import Google from '../../images/googleIcon.png';

function Login() {
  return (
    <div className='flex flex-col justify-center items-center m-auto w-[1440px] h-[960px] bg-[#31373b]'>
      <div className='flex justify-center items-center mb-[600px] w-[500px] h-[150px] text-[50pt] font-bold text-white'>
        CreWship
      </div>
      <div className='fixed justify-center items-center m-auto w-[500px] h-[400px] bg-[rgba(255,255,255,0.2)] rounded-xl'>
        <div className='flex flex-col justify-center items-center m-auto w-[480px] h-[380px]'>
          <p className='text-white text-[15pt] mb-10'>
            SNS로 간편하게 시작하세요
          </p>
          <div className='flex justify-between items-center w-[400px] h-[100px] '>
            <img className='w-[70px] h-[70px] ' alt='naverIcon' src={Naver} />
            <img className='w-[70px] h-[70px] ' alt='googleIcon' src={Google} />
            <img className='w-[70px] h-[70px] ' alt='kakaoIcon' src={Kakao} />
          </div>
        </div>
      </div>
    </div>
  );
}

export default Login;
