import React, { useState } from 'react';
import Modal from 'react-modal';
import axios from 'axios';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';

interface Project {
  summary: string;
  description: string;
  contributePoint: string;
  category: string;
  sprintId: string;
  playerId: string;
  reviewerId: string;
}

function TaskPopup() {
  const [modalIsOpen, setIsOpen] = useState(false);
  const [data, setData] = useState<Project>({
    summary: '',
    description: '',
    contributePoint: '',
    category: '',
    sprintId: '',
    playerId: '',
    reviewerId: '',
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
    const taskData = {
      summary: data.summary,
      description: data.description,
      contributePoint: data.contributePoint,
      category: data.category,
      sprintId: 5,
      playerId: 5,
      reviewerId: 5,
    };
    axios.post('tasks', taskData).then((response) => {
      console.log(response.status, response.data);
      window.location.replace('/Task1');
    });
  };

  return (
    <div>
      <button
        type='button'
        className='flex justify-center items-center ml-auto w-[150px] h-[40px] rounded-[999px] bg-[#1AAAFB] text-white'
        onClick={openModal}
      >
        테스크 생성하기
      </button>
      <Modal
        isOpen={modalIsOpen}
        className='w-[100vw] h-[100vh] flex justify-center items-center fixed bg-[rgba(0,0,0,0.2)]'
        contentLabel='Test Modal'
      >
        <form
          onSubmit={handleSubmit}
          className='border flex flex-col justify-center items-center m-auto bg-white w-[480px] h-[600px] rounded-[30px]'
        >
          <label
            htmlFor='summary'
            className='mb-4 w-[430px] font-bold text-[20px]'
          >
            요약
            <input
              className='text-[20px] w-[430px] border-b-2'
              name='summary'
              type='summary'
              value={data.summary}
              onChange={handleChange}
              placeholder='테스크 요약 내용을 입력해주세요.'
            />
          </label>
          <label
            htmlFor='description'
            className='mb-4 w-[430px] font-bold text-[20px]'
          >
            설명
            <input
              className='text-[20px] w-[430px] border-b-2'
              name='description'
              type='description'
              value={data.description}
              onChange={handleChange}
              placeholder='테스크 설명을 입력해주세요.'
            />
          </label>
          <label
            htmlFor='contributePoint'
            className='mb-4 w-[430px] font-bold text-[20px]'
          >
            기여도 점수
            <input
              className='text-[20px] w-[430px] border-b-2'
              name='contributePoint'
              type='contributePoint'
              value={data.contributePoint}
              onChange={handleChange}
              placeholder='기여도 점수를 입력해주세요.'
            />
          </label>
          <label
            htmlFor='category'
            className='mb-4 w-[430px] font-bold text-[20px]'
          >
            카테고리
            <input
              className='text-[20px] w-[430px] border-b-2'
              name='category'
              type='category'
              value={data.category}
              onChange={handleChange}
              placeholder='카테고리를 입력해주세요.'
            />
          </label>
          <div className='flex space-x-2'>
            <button
              type='submit'
              className='flex justify-center items-center w-[100px] h-[40px] rounded-[30px] bg-[#0075FF] text-white text-[12px]'
            >
              생성하기
            </button>
            <button
              type='button'
              onClick={closeModal}
              className='flex justify-center items-center w-[100px] h-[40px] rounded-[30px] bg-[#0075FF] text-white text-[12px]'
            >
              닫기
            </button>
          </div>
        </form>
      </Modal>
    </div>
  );
}

export default TaskPopup;
