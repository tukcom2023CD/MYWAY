import React, { useState, useEffect } from "react";
import axios from "axios";
import { NavLink } from "react-router-dom";
import moveImg from "../../images/login.png";
import Menu from "../../components/frames/Side/Sidebar";
import ProjectPopup from "../../components/Popup/ProjectPopup";

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

function Project() {
  const [projectData, setProjectData] = useState<ProjectData[]>();

  useEffect(() => {
    async function fetchData(): Promise<void> {
      try {
        const response = await axios.get<ProjectData[]>("projects?team-id=1");
        setProjectData(response.data);
        console.log(response.data);
      } catch (error) {
        console.log(error);
      }
    }
    fetchData();
  }, []);

  const activeStyle = {
    background: "#D8F1FF",
  };

  return (
    <div className='flex m-auto w-[1440px] h-[100vh]'>
      <Menu />
      <div className='flex flex-col justfiy-center items-center m-auto w-[1024px] h-[800px] bg-white rounded-[10px] border'>
        <div className='flex justify-between items-center w-full p-5 h-[50px] bg-[#6A6A6A]'>
          <p className='text-white text-md font-bold'>프로젝트 리스트</p>
          <ProjectPopup />
        </div>
        <div className='border mt-8'>
          <ul className='p-5 w-[950px] h-[650px] overflow-auto'>
            {projectData
              ? projectData.map((projectData) => (
                  <li
                    className='flex justify-start pl-4 items-center m-auto w-[850px] h-[50px] bg-white border p-2'
                    key={projectData.id}
                  >
                    {projectData.name}
                    <NavLink
                      className='flex justify-center items-center ml-auto w-[60px] h-[40px] rounded-[10px] bg-[#4A4A4A] text-white'
                      style={({ isActive }) => (isActive ? activeStyle : {})}
                      to={`/Sprint/${projectData.id}`}
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

export default Project;
