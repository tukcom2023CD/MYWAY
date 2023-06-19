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

interface Sprint {
  id: number;
  name: string;
  startAt: string;
  endAt: string;
  team: Team;
  sprintDays: number;
  manager: Manager;
}

interface Leader {
  id: number;
  nickname: string;
  rank: string;
}

interface TaskData {
  id: number;
  summary: string;
  description: string;
  status: string;
  contributePoint: number;
  category: string;
  sprint: Sprint;
  round: number;
  startDate: string;
  endData: string;
  leader: Leader;
}

function Task() {
  const [taskData, setTaskData] = useState<TaskData[]>();

  useEffect(() => {
    async function fetchData(): Promise<void> {
      try {
        const response = await axios.get<TaskData[]>('tasks/1');
        setTaskData(response.data);
        console.log(response.data);
      } catch (error) {
        console.log(error);
      }
    }
    fetchData();
  }, []);

  return (
    <div className='flex m-auto w-[1440px] h-[100vh]'>
      <Menu />
      <div className='flex flex-col justfiy-center items-center m-auto w-[1024px] h-[800px] bg-white rounded-[10px] border'>
        <div className='flex justify-between items-center w-full p-5 h-[50px] bg-[#6A6A6A]'>
          <p className='text-white text-md font-bold'>테스크 리스트</p>
          <TaskPopup />
        </div>
        <ul className='grid grid-cols-3 gap-4 p-5 mb-[50px] w-[950px] h-[650px] bg-white overflow-auto'>
          {taskData
            ? taskData.map((taskData) => (
                <li
                  className='flex justify-start pl-4 items-center m-auto w-[850px] h-[50px] bg-white border'
                  key={taskData.id}
                >
                  {taskData.summary}
                  {taskData.description}
                  {taskData.status}
                  {taskData.contributePoint}
                  {taskData.category}
                </li>
              ))
            : null}
          <Dropdown />
        </ul>
      </div>
    </div>
  );
}

export default Task;
