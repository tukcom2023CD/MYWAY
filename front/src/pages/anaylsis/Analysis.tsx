/* eslint-disable react/jsx-no-bind */
/* eslint-disable func-names */
import React from 'react';
import AnalysisGraph from '../../components/graph/AnalysisGraph';
import Menu from '../../components/frames/Side/Sidebar';
import Chart from '../../components/graph/Armchart';
import ApiCall from '../../components/graph/ApiCall';

function Analysis() {
  return (
    <div className='flex m-auto w-[1440px] h-[960px] bg-[#D8F1FF]'>
      <Menu />
      <div className='flex flex-col justfiy-center items-center m-auto w-[1024px] h-[800px]'>
        <div className='flex justify-center items-center m-auto'>
          <AnalysisGraph />
          <Chart
            labelChecked='checked'
            labelUnChecked='unchecked'
            triggerFunction={function (): void {
              throw new Error('Function not implemented.');
            }}
          />
          <ApiCall />
        </div>
      </div>
    </div>
  );
}

export default Analysis;
