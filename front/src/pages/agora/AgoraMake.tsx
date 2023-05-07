import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { NavLink } from 'react-router-dom';
import moveImg from '../../images/login.png';
import Menu from '../../components/frames/Side/Sidebar2';
import AgoraPopup from '../../components/frames/Agora/AgoraPopup';
import AgoraDetail from '../../components/frames/Agora/AgoraDetail';

interface Manager {
  id: number;
  nickname: string;
  rank: string;
}

interface Team {
  id: number;
  name: string;
  industryGroup: string;
}

interface ProjectData {
  id: number;
  name: string;
  startAt: string;
  endAt: string;
  sprintDays: string;
  manager: Manager;
  team: Team;
}

function Agora() {
  const [projectData, setProjectData] = useState<ProjectData[]>();

  useEffect(() => {
    async function fetchData(): Promise<void> {
      try {
        const response = await axios.get<ProjectData[]>('projects?team-id=1');
        setProjectData(response.data);
        console.log(response.data);
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
    <div className='flex m-auto w-[1440px] h-[100vh] bg-[#D8F1FF]'>
      <Menu />
      <div className='flex flex-col justfiy-center items-center m-auto w-[1024px] h-[800px] bg-white rounded-[50px]'>
        <div className='flex p-7 justify-center items-center space-x-[650px]'>
          <p className='text-[20px] font-bold'>Agora 게시판</p>
          <AgoraPopup />
        </div>
        <ul className='p-5 space-y-3 mb-[50px] w-[950px] h-[650px] bg-gray-200 overflow-auto'>
          <li className='flex justify-start pl-4 items-center m-auto w-[850px] h-[50px] bg-white'>
            테스트 질문입니다.
            <AgoraDetail />
          </li>
          {/* {projectData
            ? projectData.map((projectData) => (
                <li
                  className='flex justify-start pl-4 items-center m-auto w-[850px] h-[50px] bg-white'
                  key={projectData.id}
                >
                  {projectData.name}
                  <NavLink
                    className='flex justify-center items-center ml-auto w-[60px] h-[40px] rounded-[999px] bg-[#1AAAFB] text-white'
                    style={({ isActive }) => (isActive ? activeStyle : {})}
                    to='/sprint'
                  >
                    <img
                      className='w-[24px] h-[24px]'
                      alt='agoraIcon'
                      src={moveImg}
                    />
                  </NavLink>
                </li>
              ))
            : null} */}
        </ul>
      </div>
    </div>
  );
}

export default Agora;
