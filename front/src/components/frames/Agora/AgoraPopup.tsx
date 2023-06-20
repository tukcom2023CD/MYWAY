import React, { useState } from 'react';
import Modal from 'react-modal';
import { NavLink } from 'react-router-dom';
import axios from 'axios';

interface Agora {
  title: string;
  writerId: number;
  content: string;
  teamId: string;
  tags: string;
}

function AgoraPopup() {
  const [modalIsOpen, setIsOpen] = useState(false);
  const [data, setData] = useState<Agora>({
    title: '',
    writerId: 2,
    content: '',
    teamId: '',
    tags: '',
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
    const agoraData = {
      title: data.title,
      writerId: data.writerId,
      content: data.content,
      teamId: data.teamId,
      tags: data.tags,
    };
    axios.post('questions', agoraData).then((response) => {
      console.log(response.status, response.data);
      window.location.replace('/Agora');
    });
  };

  const handleNavLinkCLick = () => {
    setTimeout(() => {
      window.location.replace('/agora1');
    }, 2000);
  };

  return (
    <div>
      <button
        type='button'
        className='flex justify-center items-center ml-auto w-[150px] h-[40px] rounded-[10px] bg-[#4A4A4A] text-white'
        onClick={openModal}
      >
        질문하기
      </button>
      <Modal
        isOpen={modalIsOpen}
        className='w-[100vw] h-[100vh] flex justify-center items-center fixed bg-[rgba(0,0,0,0.2)]'
        contentLabel='Test Modal'
      >
        <form
          onSubmit={handleSubmit}
          className='border flex flex-col justify-center items-center m-auto bg-white w-[700px] h-[600px] rounded-[15px]'
        >
          <label
            htmlFor='summary'
            className='mb-4 w-[600px] font-bold text-[20px]'
          >
            제목
            <input
              className='text-[20px] w-[600px] border-b-2'
              name='summary'
              type='summary'
              value={data.title}
              onChange={handleChange}
              placeholder='제목을 입력해주세요.'
            />
          </label>
          <label
            htmlFor='description'
            className='mb-4 w-[600px] font-bold text-[20px]'
          >
            카테고리
            <input
              className='text-[20px] w-[600px] border-b-2'
              name='description'
              type='description'
              value={data.tags}
              onChange={handleChange}
              placeholder='카테고리를 입력해주세요.'
            />
          </label>
          <label
            htmlFor='category'
            className='mb-4 w-[600px] font-bold text-[20px]'
          >
            내용
            <input
              className='text-[20px] w-[600px] h-[200px] border-b-2'
              name='category'
              type='category'
              value={data.content}
              onChange={handleChange}
              placeholder='질문내용을 입력해주세요.'
            />
          </label>
          <div className='flex space-x-2'>
            <NavLink
              to='/agora'
              onClick={handleNavLinkCLick}
              className='flex justify-center items-center w-[100px] h-[40px] rounded-[10px] bg-[#0075FF] text-white text-[15px]'
            >
              생성하기
            </NavLink>
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

export default AgoraPopup;
