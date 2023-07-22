/* eslint-disable react/no-unstable-nested-components */
import React, { useState } from "react";
import { Calendar, momentLocalizer } from "react-big-calendar";
import moment from "moment";
import "react-big-calendar/lib/css/react-big-calendar.css";
import refresh from "../../images/refresh.png";

const localizer = momentLocalizer(moment);

interface Event {
  id: number;
  title: string;
  start: Date;
  end: Date;
}

const events: Event[] = [
  {
    id: 1,
    title: "Agora",
    start: new Date("2023-06-16T10:00:00Z"),
    end: new Date("2023-06-17T12:00:00Z"),
  },
  {
    id: 2,
    title: "최종 데모",
    start: new Date("2023-06-19T12:00:00Z"),
    end: new Date("2023-06-22T14:00:00Z"),
  },
  {
    id: 3,
    title: "task",
    start: new Date("2023-06-07T12:00:00Z"),
    end: new Date("2023-06-10T14:00:00Z"),
  },
];

const CustomToolbar: React.FC<{
  currentDate: Date;
  onNavigate: (date: Date) => void;
}> = ({ currentDate, onNavigate }) => {
  const [currentMonth, setCurrentMonth] = useState<Date>(currentDate);

  const handlePrev = () => {
    const prevMonth = moment(currentMonth).subtract(1, "months").toDate();
    setCurrentMonth(prevMonth);
    onNavigate(prevMonth);
  };

  const handleNext = () => {
    const nextMonth = moment(currentMonth).add(1, "months").toDate();
    setCurrentMonth(nextMonth);
    onNavigate(nextMonth);
  };

  return (
    <div className='rbc-toolbar'>
      <div className='rbc-toolbar-label font-bold mt-2'>
        {moment(currentMonth).format("MMMM YYYY")} {/* 현재 월 표시 */}
      </div>
      <div className='rbc-btn-group'>
        <button type='button' onClick={handlePrev}>
          이전 달
        </button>
        <button type='button' onClick={handleNext}>
          다음 달
        </button>
      </div>
    </div>
  );
};

const eventStyleGetter = (
  event: Event,
  start: any,
  end: any,
  isSelected: any
) => {
  let backgroundColor;

  // 이벤트마다 다른 색상 부여
  if (event.id === 1) {
    backgroundColor = "#FFCC00";
  } else if (event.id === 2) {
    backgroundColor = "#D34BAD";
  } else if (event.id === 3) {
    backgroundColor = "#66D34B";
  } else {
    backgroundColor = "#9C27B0";
  }

  const style = {
    backgroundColor,
    borderRadius: "5px",
    opacity: 0.8,
    color: "white",
    border: "none",
    display: "block",
  };

  return {
    style,
  };
};

const DailyCalendar: React.FC = () => {
  const [currentMonth, setCurrentMonth] = useState<Date>(
    moment().subtract(1, "months").toDate() // 이전 달로 설정
  );

  const handleNavigate = (date: Date) => {
    setCurrentMonth(date);
  };

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
          toolbar: (props) => (
            <CustomToolbar
              {...props}
              currentDate={currentMonth}
              onNavigate={handleNavigate}
            />
          ),
        }}
        date={currentMonth} // 이전 달로 설정된 상태를 date prop으로 전달
      />
    </div>
  );
};

export default DailyCalendar;
