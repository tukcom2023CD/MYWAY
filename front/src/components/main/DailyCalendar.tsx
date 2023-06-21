import React from 'react';
import { Calendar, momentLocalizer } from 'react-big-calendar';
import moment from 'moment';
import 'react-big-calendar/lib/css/react-big-calendar.css';
import refresh from '../../images/refresh.png';

const localizer = momentLocalizer(moment);

const events = [
  {
    id: 1,
    title: 'Agora',
    start: new Date('2023-06-16T10:00:00Z'),
    end: new Date('2023-06-17T12:00:00Z'),
  },
  {
    id: 2,
    title: '최종 데모',
    start: new Date('2023-06-19T12:00:00Z'),
    end: new Date('2023-06-22T14:00:00Z'),
  },
  {
    id: 3,
    title: 'task',
    start: new Date('2023-06-07T12:00:00Z'),
    end: new Date('2023-06-10T14:00:00Z'),
  },
];

const CustomToolbar = () => (
  <div className='rbc-toolbar'>
    <div className='rbc-toolbar-label font-bold mt-2'>
      {moment().format('MMMM YYYY')} {/* 현재 월 표시 */}
    </div>
  </div>
);
const eventStyleGetter = (
  event: { id: number },
  start: any,
  end: any,
  isSelected: any
) => {
  let backgroundColor;

  // 이벤트마다 다른 색상 부여
  if (event.id === 1) {
    backgroundColor = '#FFCC00';
  } else if (event.id === 2) {
    backgroundColor = '#D34BAD';
  } else if (event.id === 3) {
    backgroundColor = '#66D34B';
  } else {
    backgroundColor = '#9C27B0';
  }

  const style = {
    backgroundColor,
    borderRadius: '5px',
    opacity: 0.8,
    color: 'white',
    border: 'none',
    display: 'block',
  };

  return {
    style,
  };
};

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
        eventPropGetter={eventStyleGetter}
        components={{
          toolbar: CustomToolbar,
        }}
      />
    </div>
  );
}

export default DailyCalendar;
