import React, { useState } from 'react';
import Modal from 'react-modal';
import axios from 'axios';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';

interface Project {
  name: string;
  startAt: string;
  endAt: string;
  sprintDays: string;
  teamId: string;
  managerId: string;
}

function ProjectPopup() {
  const [modalIsOpen, setIsOpen] = useState(false);
  const [data, setData] = useState<Project>({
    name: '',
    startAt: '',
    endAt: '',
    sprintDays: '',
    teamId: '',
    managerId: '',
  });
  const [startDate, setStartDate] = useState<Date | null>(null);
  const [endDate, setEndDate] = useState<Date | null>(null);

  function openModal() {
    setIsOpen(true);
  }

  function closeModal() {
    setIsOpen(false);
  }

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

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { value, name } = e.target;
    setData({
      ...data,
      [name]: value,
    });
  };

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    const projectData = {
      name: data.name,
      startAt: startDate,
      endAt: endDate,
      sprintDays: data.sprintDays,
      teamId: 1,
      managerId: 2,
    };
    axios.post('projects', projectData).then((response) => {
      console.log(response.status, response.data);
      window.location.replace('/Project');
    });
  };

  return (
    <div>
      <button
        type='button'
        className='flex justify-center items-center ml-auto w-[150px] h-[40px] rounded-[10px] bg-[#1AAAFB] text-white'
        onClick={openModal}
      >
        프로젝트 생성하기
      </button>
      <Modal
        isOpen={modalIsOpen}
        className='w-[100vw] h-[100vh] flex justify-center items-center fixed bg-[#404040]'
        contentLabel='Test Modal'
      >
        <form
          onSubmit={handleSubmit}
          className='border flex flex-col justify-center items-center m-auto bg-white w-[480px] h-[600px] rounded-[10px]'
        >
          <label
            htmlFor='name'
            className='mb-4 w-[430px] font-bold text-[20px]'
          >
            제목
            <input
              className='text-[20px] w-[430px] border-b-2'
              name='name'
              type='name'
              value={data.name}
              onChange={handleChange}
              placeholder='제목을 입력해주세요.'
            />
          </label>
          <label
            htmlFor='startDate'
            className='mb-4 w-[430px] font-bold text-[20px]'
          >
            Start Date:
            <DatePicker
              selected={startDate}
              onChange={handleStartDateChange}
              dateFormat='yyyy-MM-dd'
              className='border-2'
            />
          </label>
          <label
            htmlFor='endDate'
            className='mb-4 w-[430px] font-bold text-[20px]'
          >
            End Date:
            <DatePicker
              selected={endDate}
              onChange={handleEndDateChange}
              dateFormat='yyyy-MM-dd'
              minDate={startDate}
              className='border-2'
            />
          </label>
          <label
            htmlFor='sprintDays'
            className='mb-4 w-[430px] font-bold text-[20px]'
          >
            스프린트 주기
            <input
              className='text-[20px] w-[430px] border-b-2'
              name='sprintDays'
              type='sprintDays'
              value={data.sprintDays}
              onChange={handleChange}
              placeholder='스프린트 주기를 입력해주세요.'
            />
          </label>
          <div className='flex space-x-2'>
            <button
              type='submit'
              className='flex justify-center items-center w-[100px] h-[40px] rounded-[10px] bg-[#0075FF] text-white text-[15px]'
            >
              생성하기
            </button>
            <button
              type='button'
              onClick={closeModal}
              className='flex justify-center items-center w-[100px] h-[40px] rounded-[10px] bg-[#0075FF] text-white text-[15px]'
            >
              닫기
            </button>
          </div>
        </form>
      </Modal>
    </div>
  );
}

export default ProjectPopup;
