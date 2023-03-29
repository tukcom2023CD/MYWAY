import React from 'react';
import {
  Radar,
  RadarChart,
  PolarGrid,
  PolarAngleAxis,
  ResponsiveContainer,
} from 'recharts';

const data = [
  {
    subject: '커뮤니케이션',
    A: 120,
    B: 110,
    fullMark: 150,
  },
  {
    subject: '위기 대처',
    A: 98,
    B: 130,
    fullMark: 150,
  },
  {
    subject: '개발',
    A: 86,
    B: 130,
    fullMark: 150,
  },
  {
    subject: '리팩터링',
    A: 99,
    B: 100,
    fullMark: 150,
  },
  {
    subject: '기획',
    A: 85,
    B: 90,
    fullMark: 150,
  },
];

function Analysis() {
  return (
    <div className='bg-white w-[500px] h-[260px] rounded-[30px]'>
      <div className='flex flex-col items-center p-4 mt-2'>
        <p className='ml-3 mr-auto text-[20px] font-bold'>프로젝트 기여도</p>
        <div className='flex m-auto w-[450px] h-[200px]'>
          <div className='m-auto w-[300px] h-[200px]'>
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
          <div className='flex flex-col m-auto w-[220px] h-[200px] p-3'>
            <div className='mr-3 text-[30px] font-bold mb-[10px]'>36%</div>
            <div className='flex flex-col items-left justify-center font-extralight overflow-y-auto'>
              <p>태스크1</p>
              <p>태스크2</p>
              <p>태스크3</p>
              <p>태스크4</p>
              <p>태스크5</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Analysis;
