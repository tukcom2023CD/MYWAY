import React from "react";
import {
  Radar,
  RadarChart,
  PolarGrid,
  PolarAngleAxis,
  ResponsiveContainer,
} from "recharts";
import refresh from "../../images/refresh.png";

const data = [
  {
    subject: "커뮤니케이션",
    A: 330,
    fullMark: 700,
  },
  {
    subject: "위기 대처",
    A: 30,
    fullMark: 700,
  },
  {
    subject: "개발",
    A: 630,
    fullMark: 700,
  },
  {
    subject: "리팩터링",
    A: 240,
    fullMark: 700,
  },
  {
    subject: "기획",
    A: 300,
    fullMark: 700,
  },
];

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
        {" "}
        {/* 부모 요소의 크기 조정 */}
        <div className='m-auto w-[500px] h-[300px]'>
          {" "}
          {/* RadarChart 영역 */}
          <ResponsiveContainer width='100%' height='100%'>
            <RadarChart cx='50%' cy='50%' outerRadius='80%' data={data}>
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
