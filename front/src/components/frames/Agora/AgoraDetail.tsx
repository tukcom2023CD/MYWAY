import React, { useState } from 'react';
import Modal from 'react-modal';
import { NavLink } from 'react-router-dom';
import axios from 'axios';

interface Task {
  summary: string;
  description: string;
  contributePoint: string;
  category: string;
  sprintId: string;
  playerId: string;
  reviewerId: string;
}

function AgoraPopup() {
  const [modalIsOpen, setIsOpen] = useState(false);
  const [data, setData] = useState<Task>({
    summary: '',
    description: '',
    contributePoint: '',
    category: '',
    sprintId: '',
    playerId: '',
    reviewerId: '',
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

  // const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
  //   e.preventDefault();
  //   const taskData = {
  //     summary: data.summary,
  //     description: data.description,
  //     contributePoint: data.contributePoint,
  //     category: data.category,
  //     sprintId: 1,
  //     playerId: 2,
  //     reviewerId: 3,
  //   };
  //   axios.post('tasks', taskData).then((response) => {
  //     console.log(response.status, response.data);
  //     window.location.replace('/Task1');
  //   });
  // };

  const handleNavLinkCLick = () => {
    setTimeout(() => {
      window.location.replace('/task1');
    }, 2000);
  };

  return (
    <div>
      <button
        type='button'
        className='flex justify-center items-center ml-[600px] w-[100px] h-[40px] rounded-[999px] bg-[#1AAAFB] text-white'
        onClick={openModal}
      >
        답변하기
      </button>
      <Modal
        isOpen={modalIsOpen}
        className='w-[100vw] h-[100vh] flex justify-center items-center fixed bg-[rgba(0,0,0,0.2)]'
        contentLabel='Test Modal'
      >
        <form
          // onSubmit={handleSubmit}
          className='border flex flex-col justify-center items-center m-auto bg-white w-[700px] h-[600px] rounded-[30px]'
        >
          <label
            htmlFor='summary'
            className='mb-4 w-[600px] font-bold text-[20px]'
          >
            테스트 질문입니다.
          </label>
          <label
            htmlFor='description'
            className='mb-4 w-[600px] font-bold text-[20px]'
          >
            카테고리 : 개발
          </label>
          <label
            htmlFor='category'
            className='mb-4 w-[600px] font-bold text-[20px]'
          >
            테스트 질문 내용입니다.
          </label>
          <div className='flex space-x-2'>
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

export default AgoraPopup;
