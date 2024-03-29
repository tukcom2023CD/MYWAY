import React, { useState } from 'react';
import Modal from 'react-modal';
import axios from 'axios';

interface Task {
  summary: string;
  description: string;
  contributePoint: string;
  category: string;
  sprintId: number;
  playerId: number;
  reviewerId: number;
}

function TaskPopup() {
  const [modalIsOpen, setIsOpen] = useState(false);
  const [data, setData] = useState<Task>({
    summary: '',
    description: '',
    contributePoint: '',
    category: '',
    sprintId: 5,
    playerId: 5,
    reviewerId: 5,
  });

  function openModal() {
    setIsOpen(true);
  }

  function closeModal() {
    setIsOpen(false);
  }

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
    };
    axios.post('tasks', taskData).then((response) => {
      console.log(response.status, response.data);
      window.location.replace('/Task');
    });
  };

  return (
    <div>
      <button
        type='button'
        className='flex justify-center items-center ml-auto w-[150px] h-[40px] rounded-[10px] bg-[#4A4A4A] text-white'
        onClick={openModal}
      >
        테스크 생성하기
      </button>
      <Modal
        isOpen={modalIsOpen}
        className='w-[100vw] h-[100vh] flex justify-center items-center fixed bg-[#404040]'
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
              className='flex justify-center items-center w-[100px] h-[40px] rounded-[10px] bg-[#4A4A4A] text-white text-[15px]'
            >
              생성하기
            </button>
            <button
              type='button'
              onClick={closeModal}
              className='flex justify-center items-center w-[100px] h-[40px] rounded-[10px] bg-[#4A4A4A] text-white text-[15px]'
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
