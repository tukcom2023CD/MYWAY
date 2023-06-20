import React, { useState } from 'react';
import Modal from 'react-modal';
import axios from 'axios';

function TeamPopup() {
  const [modalIsOpen, setIsOpen] = useState(false);
  const [data, setData] = useState({
    name: '',
    industryGroup: '',
    sprintDays: '',
    startAt: '',
    endAt: '',
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
    const teamData = {
      name: data.name,
      industryGroup: data.industryGroup,
      sprintDays: data.sprintDays,
      startAt: data.startAt,
      endAt: data.endAt,
    };
    axios.post(`teams`, teamData).then((response) => {
      console.log(response.status, response.data);
      window.location.replace('/TeamList');
    });
  };

  return (
    <div>
      <button
        type='button'
        className='flex justify-center items-center ml-auto w-[150px] h-[35px] rounded-[10px] bg-[#4A4A4A] font-bold text-white'
        onClick={openModal}
      >
        + 프로젝트 생성
      </button>
      <Modal
        isOpen={modalIsOpen}
        className='w-[100vw] h-[100vh] flex justify-center items-center fixed bg-[#404040]'
        contentLabel='Test Modal'
      >
        <form
          onSubmit={handleSubmit}
          className='border flex flex-col justify-center items-center m-auto bg-white w-[480px] h-[600px] rounded-[15px]'
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
            htmlFor='industryGroup'
            className='mb-4 w-[430px] font-bold text-[20px]'
          >
            부서명
            <input
              className='text-[20px] w-[430px] border-b-2'
              name='industryGroup'
              type='industryGroup'
              value={data.industryGroup}
              onChange={handleChange}
              placeholder='부서명을 입력하세요.'
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

export default TeamPopup;
