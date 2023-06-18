import React from 'react';
import { Calendar, momentLocalizer } from 'react-big-calendar';
import moment from 'moment';
import 'react-big-calendar/lib/css/react-big-calendar.css';
import refresh from '../../images/refresh.png';

const localizer = momentLocalizer(moment);

const events = [
  {
    title: '진행사항 1',
    start: new Date('2023-04-24T10:00:00Z'),
    end: new Date('2023-04-24T12:00:00Z'),
  },
  {
    title: '진행사항 2',
    start: new Date('2023-04-26T12:00:00Z'),
    end: new Date('2023-04-26T14:00:00Z'),
  },
];

function DailyCalendar() {
  return (
    <div className='flex flex-col bg-white w-[550px] h-[400px] border'>
      <div className='flex justify-between items-center p-5 h-[50px] bg-[#6A6A6A]'>
        <p className='text-white text-md font-bold'>일정</p>
        <img
          className='w-[24px] h-[24px] bg-[#EAEAEA] rounded-[5px]'
          alt='refresh'
          src={refresh}
        />
      </div>
      <Calendar
        localizer={localizer}
        events={events}
        startAccessor='start'
        endAccessor='end'
      />
    </div>
  );
}

export default DailyCalendar;
