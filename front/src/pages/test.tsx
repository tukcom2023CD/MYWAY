import React from 'react';
import Menu from '../components/frames/Side/Sidebar';
import Popup from '../components/Popup/SprintPopup';

function Test() {
  return (
    <div className='flex m-auto w-[1440px] h-[100vh] bg-[#D8F1FF]'>
      <Menu />
      <div className='flex flex-col p-5 justfiy-center items-center m-auto w-[1024px] h-[800px] bg-white rounded-[30px]'>
        <Popup />
      </div>
    </div>
  );
}

export default Test;
