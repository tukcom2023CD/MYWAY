import React, { useState } from 'react';
import Calendar from 'react-calendar';
import 'react-calendar/dist/Calendar.css';

function Daily() {
  const [value, onChange] = useState(new Date());
  return (
    <Calendar
      className='flex flex-col justify-center items-center h-[300px] m-auto'
      onChange={onChange}
      value={value}
    />
  );
}

export default Daily;
