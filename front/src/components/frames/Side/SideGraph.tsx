import React from 'react';
import { PieChart } from 'react-minimal-pie-chart';

function SideGraph() {
  return (
    <div className='flex flex-col'>
      <div className='mb-3'>
        <h1 className='text-[#2093D3] text-xl font-bold'>Task Score</h1>
      </div>
      <div className='flex justify-center items-center m-auto w-[180px] h-[70px]'>
        <div className='fixed z-2 mr-[50px] justify-center items-center w-[80px] p-2 rounded-[100%] bg-[#DBDBDB]'>
          <PieChart
            data={[{ value: 50, color: '#2093D3', name: '태스크 진행상황' }]}
            reveal={50}
            lineWidth={18}
            background='#aba8a8'
            lengthAngle={360}
            rounded
            animate
            label={({ dataEntry }) => `${dataEntry.value}%`}
            labelStyle={{
              fontSize: '26px',
              fill: '#33333',
            }}
            labelPosition={0}
          />
        </div>
        <p className='z-1 w-[180px] p-5 rounded-lg text-right text-[12px] bg-[#DBDBDB]'>
          프로젝트A
        </p>
      </div>
    </div>
  );
}

export default SideGraph;
