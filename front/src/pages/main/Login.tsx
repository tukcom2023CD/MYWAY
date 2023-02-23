import React from 'react';
import Kakao from '../../images/kakaoIcon.png';
import Naver from '../../images/naverIcon.png';
import Google from '../../images/googleIcon.png';

function Login() {
  const baseUrl = process.env.REACT_APP_BASE_URL;
  const NAVER = `${baseUrl}auth/login/naver`;
  const GOOGLE = `${baseUrl}auth/login/google`;
  const KAKAO = `${baseUrl}auth/login/kakao`;

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
            <a href={NAVER}>
              <img className='w-[70px] h-[70px] ' alt='naverIcon' src={Naver} />
            </a>
            <a href={GOOGLE}>
              <img
                className='w-[70px] h-[70px] '
                alt='googleIcon'
                src={Google}
              />
            </a>
            <a href={KAKAO}>
              <img className='w-[70px] h-[70px] ' alt='kakaoIcon' src={Kakao} />
            </a>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Login;
