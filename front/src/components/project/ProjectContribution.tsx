import React from 'react';
import { PieChart } from 'react-minimal-pie-chart';

function ProjectContribution() {
  const data = [
    { title: 'One', value: 36, color: '#2093D3' },
    { title: 'null', value: 64, color: '#DBDBDB' },
  ];
  return (
    <div className='bg-white w-[500px] h-[260px] rounded-[30px]'>
      <div className='flex flex-col items-center p-4 mt-2'>
        <p className='ml-3 mr-auto text-[20px] font-bold'>프로젝트 기여도</p>
        <div className='flex m-auto w-[450px] h-[200px]'>
          <div className='m-auto w-[225px] h-[200px]'>
            <PieChart className='m-auto w-[180px]' data={data} animate />
          </div>
          <div className='flex flex-col m-auto w-[225px] h-[200px] p-3'>
            <div className='mr-3 text-[30px] font-bold mb-[10px]'>36%</div>
            <div className='flex flex-col items-left justify-center font-extralight overflow-y-auto'>
              <p>티켓받은 테스크 이름</p>
              <p>티켓받은 테스크 이름</p>
              <p>티켓받은 테스크 이름</p>
              <p>티켓받은 테스크 이름</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default ProjectContribution;
