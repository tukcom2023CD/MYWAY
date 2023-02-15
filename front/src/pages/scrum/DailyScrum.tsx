import React from 'react';
import Menu from '../../components/frames/Sidebar';
import Schedule from '../../components/dailyscrum/Daily';

function DailyScrum() {
  return (
    <div className='flex m-auto w-[1440px] h-[100vh] bg-[#D8F1FF]'>
      <Menu />
      <div className='flex flex-col justfiy-center items-center m-auto w-[1024px] h-[800px] bg-white rounded-[30px]'>
        <Schedule />
      </div>
    </div>
  );
}

export default DailyScrum;
