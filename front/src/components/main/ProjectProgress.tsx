/* eslint-disable react/no-array-index-key */
import React from 'react';
import { PieChart, Pie, Cell, Label } from 'recharts';
import refresh from '../../images/refresh.png';

const data = [
  { name: 'clear', value: 80 },
  { name: 'rest', value: 20 },
];

const colors = ['#0088FE', '#d4d4d4'];

function ProjectProgress() {
  return (
    <div className='flex flex-col bg-white w-[500px] h-[400px] border'>
      <div className='flex justify-between items-center p-5 h-[50px] bg-[#6A6A6A]'>
        <p className='text-white text-md font-bold'>프로젝트 진행도</p>
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
              <Label
                value={`${data[0].value}%`}
                position='top'
                fill='#fff'
                fontSize={18}
                fontWeight='bold'
              />
            </Pie>
          </PieChart>
          <div className='flex flex-col w-[220px]'>
            <div className='flex flex-col justify-center items-center m-auto text-[30px] font-bold mb-[10px] space-y-3'>
              <p className='text-[18px]'>프로젝트명 : 졸업작품</p>
              <p>진행률 : 80%</p>
              <p className='text-sm'>2023-03-02~2023-06-28</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default ProjectProgress;
