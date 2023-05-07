/* eslint-disable react/no-array-index-key */
import React from 'react';
import { PieChart, Pie, Cell } from 'recharts';

const data = [
  { name: 'clear', value: 45 },
  { name: 'rest', value: 55 },
];

const colors = ['#0088FE', '#868484'];

function ProjectProgress() {
  return (
    <div className='bg-white w-[550px] h-[300px] rounded-[30px] mb-[20px]'>
      <div className='flex flex-col items-center p-4 mt-2'>
        <p className='ml-3 mr-auto text-[20px] font-bold'>
          (예시)프로젝트 진행도
        </p>
        <div className='flex'>
          <div className='flex justify-center items-center text-[30px] font-bold'>
            45%
          </div>
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
          <div className='flex flex-col m-auto w-[220px] h-[200px] p-3'>
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
