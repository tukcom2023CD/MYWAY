import React from 'react';
import axios from 'axios';
import Kakao from '../../images/kakaoIcon.png';
import Naver from '../../images/naverIcon.png';
import Google from '../../images/googleIcon.png';

function Login() {
  const apiNaver = () => {
    axios.get(`/auth/login/naver`).then(() => {
      window.location.replace(
        'https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=jbDY6IPQ6n_neleXt7fX&scope=name%20email%20nickname%20gender%20age%20birthday%20profile_image%20birthyear%20mobile&state=40-TMC_AR07DFVSLafzS_mz9DUhzXL1Sa_ErkVTpnjA%3D&redirect_uri=http://223.255.205.62:30507/api/v1/login/oauth2/code/naver'
      );
    });
  };

  const apiGoogle = () => {
    axios.get(`/auth/login/google`).then(() => {
      window.location.replace(
        'https://accounts.google.com/o/oauth2/v2/auth?response_type=code&client_id=636110430292-3obscq5o2r3g9q8c9nbebr52i68af8lo.apps.googleusercontent.com&scope=email%20profile&state=V4fzR-2X6zZTPYkGxjcjQBDpOtbEZbhqRWaiav0AdHg%3D&redirect_uri=http://223.255.205.62:30507/api/v1/login/oauth2/code/google'
      );
    });
  };

  const apiKakao = () => {
    axios.get(`/auth/login/kakao`).then(() => {
      window.location.replace(
        'https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=7029b0d7943efeee68a5f2d0ec6c50a6&scope=profile_nickname%20profile_image%20account_email&state=K_7hGmLjQYa49AI2aV2DPEeglXceSIT9xEDONZvrueA%3D&redirect_uri=http://223.255.205.62:30507/api/v1/login/oauth2/code/kakao'
      );
    });
  };

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
            <button type='button' onClick={apiNaver}>
              <img className='w-[70px] h-[70px] ' alt='naverIcon' src={Naver} />
            </button>
            <button type='button' onClick={apiGoogle}>
              <img
                className='w-[70px] h-[70px] '
                alt='googleIcon'
                src={Google}
              />
            </button>
            <a href='/auth/login/kakao'>jjjjj</a>
            <button type='button' onClick={apiKakao}>
              <img className='w-[70px] h-[70px] ' alt='kakaoIcon' src={Kakao} />
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Login;
