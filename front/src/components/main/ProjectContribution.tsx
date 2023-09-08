/* eslint-disable no-restricted-syntax */
import React from "react";
import {
  Radar,
  RadarChart,
  PolarGrid,
  PolarAngleAxis,
  ResponsiveContainer,
} from "recharts";
import { useUser } from "../frames/token/UserContext";
import refresh from "../../images/refresh.png";
import mainData from "../graph/GraphData/mainData";
import subData1 from "../graph/GraphData/subData1";

function ProjectContribution() {
  const [user] = useUser();
  const currentNickname = user ? user.nickname : "권순호";

  const activeData = currentNickname === "권순호" ? mainData : subData1;

  return (
    <div className='flex flex-col bg-white w-[500px] h-[400px] border'>
      <div className='flex justify-between items-center p-5 h-[50px] bg-[#6A6A6A]'>
        <p className='text-white text-md font-bold'>프로젝트 기여도</p>
        <img
          className='w-[24px] h-[24px] bg-[#EAEAEA] rounded-[5px]'
          alt='refresh'
          src={refresh}
        />
      </div>
      <div className='flex m-auto w-[500px] h-[500px]'>
        <div className='m-auto w-[500px] h-[300px]'>
          <ResponsiveContainer width='100%' height='100%'>
            <RadarChart cx='50%' cy='50%' outerRadius='80%' data={activeData}>
              <PolarGrid />
              <PolarAngleAxis dataKey='subject' />
              <Radar
                name='Mike'
                dataKey='A'
                stroke='#8884d8'
                fill='#8884d8'
                fillOpacity={0.6}
              />
            </RadarChart>
          </ResponsiveContainer>
        </div>
      </div>
    </div>
  );
}

export default ProjectContribution;
