import React, { useState } from 'react';
import Calendar from 'react-calendar';
import 'react-calendar/dist/Calendar.css';

function Schedule() {
  const [value, onChange] = useState(new Date());
  return (
    <div className='flex justify-center items-right bg-white w-[500px] h-[420px] rounded-[30px]'>
      <Calendar
        className='h-[300px] m-auto'
        onChange={onChange}
        value={value}
      />
    </div>
  );
}

export default Schedule;
