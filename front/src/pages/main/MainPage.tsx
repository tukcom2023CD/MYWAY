import React from 'react';
import Header from '../../components/Header';

function MainPage() {
  return (
    <div>
      <div className='w-[100vw] h-[100vh] bg-[rgb(0,128,255)]'>
        <Header />
        <div className='m-auto mt-[30px] p-[30px] w-[93vw] h-[85vh] bg-[#E27676]' />
      </div>
    </div>
  );
}

export default MainPage;
