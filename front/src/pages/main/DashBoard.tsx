import React from 'react';
import Menu from '../../components/frames/Side/Sidebar';
import Calendar from '../../components/main/DailyCalendar';
import CheckList1 from '../../components/main/CheckListBox1';
import Progress from '../../components/main/ProjectProgress';
import Contribution from '../../components/main/ProjectContribution';

function MainPage() {
  return (
    <div className='flex m-auto w-[1440px] h-[960px] bg-[#D8F1FF]'>
      <Menu />
      <div className='flex flex-col justfiy-center space-y-5 items-center m-auto w-[1024px] h-[800px]'>
        <div className='flex space-x-10'>
          <Calendar />
          <CheckList1 />
        </div>
        <div className='flex justify-center items-center m-auto'>
          <div className='flex justify-center space-x-10 items-left w-[1024px] h-[450px]'>
            <Progress />
            <Contribution />
          </div>
        </div>
      </div>
    </div>
  );
}

export default MainPage;
