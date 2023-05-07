import React from 'react';
import Menu from '../../components/frames/Side/Sidebar';
import PivotLineChart from '../../components/graph/PivotChart';

const data = [
  { x: 1, y: 10 },
  { x: 2, y: 20 },
  { x: 3, y: 30 },
  { x: 4, y: 40 },
  { x: 5, y: 50 },
];

function Analysis() {
  return (
    <div className='flex m-auto w-[1440px] h-[960px] bg-[#D8F1FF]'>
      <Menu />
      <div className='flex flex-col justfiy-center items-center m-auto w-[1024px] h-[800px]'>
        <div className='flex justify-center items-center m-auto bg-white w-[800px] h-[500px] rounded-[30px]'>
          <div className='flex justify-center items-center m-auto w-full h-64'>
            <PivotLineChart data={data} />
          </div>
        </div>
      </div>
    </div>
  );
}

export default Analysis;
