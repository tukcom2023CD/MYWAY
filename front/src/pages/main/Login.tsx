import React from 'react';
import { NavLink } from 'react-router-dom';
import Kakao from '../../images/kakaoIcon.png';
import Naver from '../../images/naverIcon.png';
import Google from '../../images/googleIcon.png';

function Login() {
  const baseUrl = process.env.REACT_APP_BASE_URL;
  const NAVER_AUTH_URL = `${baseUrl}/auth/login/naver`;
  const GOOGLE_AUTH_URL = `${baseUrl}/auth/login/google`;
  const KAKAO_AUTH_URL = `${baseUrl}/auth/login/kakao`;

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
            <NavLink
              className='flex items-center p-2 space-x-3 rounded-xl'
              to={NAVER_AUTH_URL}
            >
              <img className='w-[70px] h-[70px] ' alt='naverIcon' src={Naver} />
            </NavLink>
            <NavLink
              className='flex items-center p-2 space-x-3 rounded-xl'
              to={GOOGLE_AUTH_URL}
            >
              <img
                className='w-[70px] h-[70px] '
                alt='googleIcon'
                src={Google}
              />
            </NavLink>
            <NavLink
              className='flex items-center p-2 space-x-3 rounded-xl'
              to={KAKAO_AUTH_URL}
            >
              <img className='w-[70px] h-[70px] ' alt='kakaoIcon' src={Kakao} />
            </NavLink>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Login;
