import React from "react";
import Menu from "../../components/frames/Side/Sidebar";
import Calendar from "../../components/main/DailyCalendar";
import CheckListBox from "../../components/main/CheckListBox";
import Progress from "../../components/main/ProjectProgress";
import Contribution from "../../components/main/ProjectContribution";

function MainPage() {
  return (
    <div className='flex m-auto w-[1440px] h-[960px]'>
      <Menu />
      <div className='flex flex-col justfiy-center space-y-5 items-center m-auto w-[1024px] h-[800px]'>
        <div className='flex space-x-10'>
          <Calendar />
          <CheckListBox />
        </div>
        <div className='flex justify-center items-center m-auto'>
          <div className='flex justify-center items-left w-[1024px] h-[450px]'>
            <div className='flex space-x-10'>
              <Progress />
              <Contribution />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default MainPage;
