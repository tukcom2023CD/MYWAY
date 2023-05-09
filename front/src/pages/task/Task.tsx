import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Menu from '../../components/frames/Side/Sidebar';
import TaskPopup from '../../components/Popup/TaskPopup';
import Dropdown from '../../components/frames/DropDown';

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

function Task() {
  const [sprintData, setSprintData] = useState<SprintData[]>();

  useEffect(() => {
    async function fetchData(): Promise<void> {
      try {
        const response = await axios.get<SprintData[]>('tasks/1');
        setSprintData(response.data);
        console.log(response.data);
      } catch (error) {
        console.log(error);
      }
    }
    fetchData();
  }, []);

  return (
    <div className='flex m-auto w-[1440px] h-[100vh] bg-[#D8F1FF]'>
      <Menu />
      <div className='flex flex-col justfiy-center items-center m-auto w-[1024px] h-[800px] bg-white rounded-[50px]'>
        <div className='flex p-7 justify-center items-center space-x-[650px]'>
          <p className='text-[20px] font-bold'>테스크 리스트</p>
          <TaskPopup />
        </div>
        <ul className='grid grid-cols-3 gap-4 p-5 mb-[50px] w-[950px] h-[650px] bg-gray-200 overflow-auto'>
          {sprintData
            ? sprintData.map((sprintData) => (
                <li
                  className='flex justify-start pl-4 items-center m-auto w-[850px] h-[50px] bg-white'
                  key={sprintData.id}
                >
                  {sprintData.name}
                </li>
              ))
            : null}
        </ul>
      </div>
    </div>
  );
}

export default Task;
