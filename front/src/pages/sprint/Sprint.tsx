import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { NavLink } from 'react-router-dom';
import moveImg from '../../images/login.png';
import Menu from '../../components/frames/Side/Sidebar';

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

interface SprintData {
  id: number;
  name: string;
  startAt: string;
  endAt: string;
  sprintDays: string;
  manager: Manager;
  team: Team;
}

function Sprint() {
  const [sprintData, setSprintData] = useState<SprintData[]>();

  useEffect(() => {
    async function fetchData(): Promise<void> {
      try {
        const response = await axios.get<SprintData[]>(
          'sprints?project-id=123'
        );
        setSprintData(response.data);
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
    <div className='flex m-auto w-[1440px] h-[100vh]'>
      <Menu />
      <div className='flex flex-col justfiy-center items-center m-auto w-[1024px] h-[800px] bg-white rounded-[10px] border'>
        <div className='flex justify-between items-center w-full p-5 h-[50px] bg-[#6A6A6A]'>
          <p className='text-white text-md font-bold'>스프린트 리스트</p>
        </div>
        <ul className='p-5 space-y-3 mb-[50px] w-[950px] h-[650px] bg-white overflow-auto'>
          {sprintData
            ? sprintData.map((sprintData) => (
                <li
                  className='flex justify-start pl-4 items-center m-auto w-[850px] h-[50px] bg-white'
                  key={sprintData.id}
                >
                  {sprintData.name}
                  <NavLink
                    className='flex justify-center items-center ml-auto w-[60px] h-[40px] rounded-[10px] bg-[#1AAAFB] text-white'
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
            : null}
        </ul>
      </div>
    </div>
  );
}

export default Sprint;
