import React, { useState } from 'react';
import Modal from 'react-modal';

function InviteList() {
  const [modalIsOpen, setIsOpen] = useState(false);

  function openModal() {
    setIsOpen(true);
  }

  function closeModal() {
    setIsOpen(false);
  }

  return (
    <div>
      <button
        type='button'
        className='flex justify-center items-center ml-auto w-[150px] h-[40px] bg-[#1AAAFB] text-white'
        onClick={openModal}
      >
        초대온 목록
      </button>
      <Modal
        isOpen={modalIsOpen}
        className='w-[100vw] h-[100vh] flex justify-center items-center fixed bg-[rgba(0,0,0,0.2)]'
        contentLabel='Test Modal'
      >
        <form className='border flex flex-col justify-center items-center m-auto bg-white w-[480px] h-[600px] rounded-[30px]'>
          <label
            htmlFor='name'
            className='mb-4 w-[430px] font-bold text-[20px]'
          >
            제목
            <input
              className='text-[20px] w-[430px] border-b-2'
              name='name'
              type='name'
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

export default InviteList;
