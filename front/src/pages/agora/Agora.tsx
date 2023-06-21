import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { NavLink } from 'react-router-dom';
import moveImg from '../../images/login.png';
import Menu from '../../components/frames/Side/Sidebar';
import AgoraPopup from '../../components/frames/Agora/AgoraPopup';
import profileImg from '../../images/members.png';

interface Writer {
  id: number;
  nickname: string;
  rank: string;
}

interface AgoraData {
  id: number;
  title: string;
  content: string;
  teamId: string;
  tags: string;
  wirter: Writer;
}

function Agora() {
  const [agoraData, setAgoraData] = useState<AgoraData[]>();

  useEffect(() => {
    async function fetchData(): Promise<void> {
      try {
        const response = await axios.get<AgoraData[]>('questions?writer-id=2');
        setAgoraData(response.data);
        console.log(response.data, response.status);
      } catch (error) {
        console.log(error);
      }
    }
    fetchData();
  }, []);

  const activeStyle = {
    background: '#D8F1FF',
  };

  return (
    <div className='flex m-auto w-[1440px] h-[100vh]'>
      <Menu />
      <div className='flex flex-col justfiy-center items-center m-auto w-[1024px] h-[800px] bg-white rounded-[10px] border'>
        <div className='flex justify-between items-center w-full p-5 h-[50px] bg-[#6A6A6A]'>
          <p className='text-white text-md font-bold'>Agora 게시판</p>
          <AgoraPopup />
        </div>
        <div className='border mt-8'>
          {' '}
          <ul className='p-5 space-y-3 mb-[50px] w-[950px] h-[650px] overflow-auto'>
            <li className='flex justify-start pl-4 items-center m-auto w-[850px] h-[50px] bg-white border'>
              <div className='flex justify-between w-[500px]'>
                <p>테스트 질문</p>
                <p className='flex'>
                  <img
                    className='w-[24px] h-[24px] mr-2'
                    alt='agoraIcon'
                    src={profileImg}
                  />
                  sample
                </p>
                <p>2023.05.20</p>
                <p>개발</p>
              </div>
              <NavLink
                className='flex justify-center items-center ml-auto w-[60px] h-[40px] rounded-[999px] bg-[#4A4A4A] text-white mr-2'
                style={({ isActive }) => (isActive ? activeStyle : {})}
                to='/Question'
              >
                <img
                  className='w-[24px] h-[24px]'
                  alt='agoraIcon'
                  src={moveImg}
                />
              </NavLink>
            </li>
            <li className='flex justify-start pl-4 items-center m-auto w-[850px] h-[50px] bg-white border'>
              <div className='flex justify-between w-[500px]'>
                <p>테스크 post 질문</p>
                <p className='flex'>
                  <img
                    className='w-[24px] h-[24px] mr-2'
                    alt='agoraIcon'
                    src={profileImg}
                  />
                  sample
                </p>
                <p>2023.05.26</p>
                <p>개발</p>
              </div>
              <NavLink
                className='flex justify-center items-center ml-auto w-[60px] h-[40px] rounded-[999px] bg-[#4A4A4A] text-white mr-2'
                style={({ isActive }) => (isActive ? activeStyle : {})}
                to='/Question1'
              >
                <img
                  className='w-[24px] h-[24px]'
                  alt='agoraIcon'
                  src={moveImg}
                />
              </NavLink>
            </li>
            {/* <li className='flex justify-start pl-4 items-center m-auto w-[850px] h-[50px] bg-white border'>
              <div className='flex justify-between w-[500px]'>
                <p>테스크 post 질문</p>
                <p className='flex'>
                  <img
                    className='w-[24px] h-[24px] mr-2'
                    alt='agoraIcon'
                    src={profileImg}
                  />
                  sample
                </p>
                <p>2023.05.20</p>
                <p>개발</p>
              </div>
              <NavLink
                className='flex justify-center items-center ml-auto w-[60px] h-[40px] rounded-[999px] bg-[#4A4A4A] text-white mr-2'
                style={({ isActive }) => (isActive ? activeStyle : {})}
                to='/Question2'
              >
                <img
                  className='w-[24px] h-[24px]'
                  alt='agoraIcon'
                  src={moveImg}
                />
              </NavLink>
            </li> */}
            {agoraData
              ? agoraData.map((agoraData) => (
                  <li
                    className='flex justify-start pl-4 items-center m-auto w-[850px] h-[50px] bg-white'
                    key={agoraData.id}
                  >
                    {agoraData.title}
                    <NavLink
                      className='flex justify-center items-center ml-auto w-[60px] h-[40px] rounded-[999px] bg-[#4A4A4A] text-white'
                      style={({ isActive }) => (isActive ? activeStyle : {})}
                      to='/Question'
                    >
                      <img
                        className='w-[24px] h-[24px]'
                        alt='agoraIcon'
                        src={moveImg}
                      />
                    </NavLink>
                  </li>
                ))
              : null}
          </ul>
        </div>
      </div>
    </div>
  );
}

export default Agora;
