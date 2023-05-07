import React, { useState } from 'react';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';

function DateRangePicker() {
  const [startDate, setStartDate] = useState<Date | null>(null);
  const [endDate, setEndDate] = useState<Date | null>(null);

  const handleStartDateChange = (date: Date | null) => {
    setStartDate(date);
    if (endDate && date && endDate < date) {
      setEndDate(date);
    }
  };

  const handleEndDateChange = (date: Date | null) => {
    if (startDate && date && startDate < date) {
      setEndDate(date);
    } else {
      setEndDate(startDate);
    }
  };

  return (
    <div>
      <div>
        <label htmlFor='startDate'>Start Date: </label>
        <DatePicker
          selected={startDate}
          onChange={handleStartDateChange}
          dateFormat='yyyy-MM-dd'
          className='border-2'
        />
      </div>
      <div>
        <label htmlFor='endDate'>End Date: </label>
        <DatePicker
          selected={endDate}
          onChange={handleEndDateChange}
          dateFormat='yyyy-MM-dd'
          minDate={startDate}
          className='border-2'
        />
      </div>
    </div>
  );
}

export default DateRangePicker;
