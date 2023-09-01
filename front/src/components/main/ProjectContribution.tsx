/* eslint-disable no-restricted-syntax */
import React from "react";
import {
  Radar,
  RadarChart,
  PolarGrid,
  PolarAngleAxis,
  ResponsiveContainer,
} from "recharts";
import refresh from "../../images/refresh.png";
import mainData from "../graph/GraphData/mainData";

function calculateAverage(dataset: string | any[], key: string | number) {
  if (dataset.length === 0) return 0;

  let sum = 0;
  for (const data of dataset) {
    sum += data[key];
  }

  return sum / dataset.length;
}

function ProjectContribution() {
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
        {/* 부모 요소의 크기 조정 */}
        <div className='m-auto w-[500px] h-[300px]'>
          {/* RadarChart 영역 */}
          <ResponsiveContainer width='100%' height='100%'>
            <RadarChart cx='50%' cy='50%' outerRadius='80%' data={mainData}>
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
