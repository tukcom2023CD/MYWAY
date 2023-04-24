import React from 'react';
import { Calendar, momentLocalizer } from 'react-big-calendar';
import moment from 'moment';
import 'react-big-calendar/lib/css/react-big-calendar.css';

const localizer = momentLocalizer(moment);

const events = [
  {
    title: 'Event 1',
    start: new Date('2023-04-24T10:00:00Z'),
    end: new Date('2023-04-24T12:00:00Z'),
  },
  {
    title: 'Event 2',
    start: new Date('2023-04-26T12:00:00Z'),
    end: new Date('2023-04-26T14:00:00Z'),
  },
];

function DailyCalendar() {
  return (
    <div className='bg-white w-[550px] h-[400px] rounded-[30px]'>
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
