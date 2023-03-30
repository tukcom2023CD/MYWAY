import React from 'react';
import AnalysisGraph from '../../components/graph/AnalysisGraph';
import Menu from '../../components/frames/Side/Sidebar';

function Analysis() {
  return (
    <div className='flex m-auto w-[1440px] h-[960px] bg-[#D8F1FF]'>
      <Menu />
      <div className='flex flex-col justfiy-center items-center m-auto w-[1024px] h-[800px]'>
        <div className='flex justify-center items-center m-auto'>
          <AnalysisGraph />
        </div>
      </div>
    </div>
  );
}

export default Analysis;
