/* eslint-disable react/no-array-index-key */
import React from 'react';
import { PieChart, Pie, Cell } from 'recharts';
import refresh from '../../images/refresh.png';

const data = [
  { name: 'clear', value: 45 },
  { name: 'rest', value: 55 },
];

const colors = ['#0088FE', '#868484'];

function ProjectProgress() {
  return (
    <div className='flex flex-col bg-white w-[500px] h-[400px] border'>
      <div className='flex justify-between items-center p-5 h-[50px] bg-[#6A6A6A]'>
        <p className='text-white text-md font-bold'>(예시)프로젝트 진행도</p>
        <img
          className='w-[24px] h-[24px] bg-[#EAEAEA] rounded-[5px]'
          alt='refresh'
          src={refresh}
        />
      </div>
      <div className='flex justify-center items-center m-auto'>
        <div className='flex justify-center items-center'>
          <PieChart width={200} height={200}>
            <Pie
              data={data}
              dataKey='value'
              nameKey='name'
              cx='50%'
              cy='50%'
              outerRadius={80}
              fill='#8884d8'
            >
              {data.map((entry, index) => (
                <Cell
                  key={`cell-${index}`}
                  fill={colors[index % colors.length]}
                />
              ))}
            </Pie>
          </PieChart>
          <div className='flex flex-col w-[220px] h-[200px] p-3'>
            <div className='mr-3 text-[30px] font-bold mb-[10px]'>45%</div>
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

export default ProjectProgress;
