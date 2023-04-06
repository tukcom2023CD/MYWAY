import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Modal from 'react-modal';
import axios from 'axios';

function TeamPopup() {
  const [modalIsOpen, setIsOpen] = useState(false);
  const [data, setData] = useState({
    name: '',
    industryGroup: '',
  });

  function openModal() {
    setIsOpen(true);
  }

  function closeModal() {
    setIsOpen(false);
  }

  const navigate = useNavigate();

  const handleChange = (e: {
    target: {
      team: any;
      value: any;
    };
  }) => {
    const { value } = e.target;
    setData({
      ...data,
      [e.target.team]: value,
    });
  };

  const onSubmit = (e: { preventDefault: () => void }) => {
    e.preventDefault();
    const teamData = {
      name: data.name,
      industryGroup: data.industryGroup,
    };
    axios.post(`teams`, teamData).then((response) => {
      console.log(response.status, response.data);
    });
  };

  return (
    <div>
      <button
        type='button'
        className='flex justify-center items-center ml-auto w-[100px] h-[40px] rounded-[999px] bg-[#1AAAFB] text-white'
        onClick={openModal}
      >
        팀 생성하기
      </button>
      <Modal
        isOpen={modalIsOpen}
        className='w-[100vw] h-[100vh] flex justify-center items-center fixed bg-[rgba(0,0,0,0.2)]'
        contentLabel='Test Modal'
      >
        <form
          onSubmit={onSubmit}
          className='border flex flex-col justify-center items-center m-auto bg-white w-[480px] h-[600px] rounded-[30px]'
        >
          <label htmlFor='name'>
            <div className='mb-4 w-[430px]'>
              <p className='font-bold text-[20px]'>제목</p>
              <input
                className='text-[20px] w-[430px] border-b-2'
                name='name'
                value={data.name}
                onChange={() => handleChange}
                placeholder='제목을 입력해주세요.'
              />
            </div>
          </label>
          <label htmlFor='industryGroup'>
            <div className='mb-4 w-[430px]'>
              <p className='font-bold text-[20px]'>부서명</p>
              <input
                className='text-[20px] w-[430px] border-b-2'
                name='industryGroup'
                value={data.industryGroup}
                onChange={() => handleChange}
                placeholder='부서명을 입력하세요.'
              />
            </div>
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
