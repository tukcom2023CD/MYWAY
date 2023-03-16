import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import Modal from 'react-modal';
import axios from 'axios';

function TeamPopup() {
  const [modalIsOpen, setIsOpen] = useState(false);
  const [data, setData] = useState({
    name: '',
    industryGroup: '',
  });
  // const [name, setName] = useState();
  // const [industryGroup, setIndustryGroup] = useState();

  function openModal() {
    setIsOpen(true);
  }

  function closeModal() {
    setIsOpen(false);
  }

  const handleChange = (e: any) => {
    const { value } = e.target;
    setData({
      ...data,
      [e.target.name]: value,
    });
  };

  const navigate = useNavigate();

  const handleSubmit = (e: any) => {
    e.preventDefault();
    const teamData = {
      name: data.name,
      industryGroup: data.industryGroup,
    };
    axios.post(`teams`, teamData).then((response) => {
      console.log(response.status, response.data.token);
    });
  };

  // const handleSubmit = useEffect(() => {
  //   axios
  //     .post(`teams`, {
  //       headers: {
  //         'Content-Type': 'application/json',
  //       },
  //     })
  //     .then((response) => {
  //       console.log(response);
  //       navigate('/TeamList');
  //     })
  //     .catch((error) => {
  //       console.log(error);
  //     });
  // }, []);

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
        contentLabel='Example Modal'
      >
        <div>
          <div className='border flex flex-col justify-center items-center m-auto bg-white w-[480px] h-[600px] rounded-[30px]'>
            <p className='font-bold text-[25px] p-7'>팀 생성</p>
            <div className='mb-4 w-[430px]'>
              <p className='font-bold text-[20px]'>제목</p>
              <input
                className='text-[20px] w-[430px] border-b-2'
                placeholder='제목을 입력해주세요.'
                onChange={handleChange}
              />
            </div>
            <div className='mb-4 w-[430px]'>
              <p className='font-bold text-[20px]'>부서명</p>
              <input
                className='text-[20px] w-[430px] border-b-2'
                placeholder='부서명을 입력하세요.'
                onChange={handleChange}
              />
            </div>
            <div className='flex space-x-2'>
              <button
                type='button'
                onClick={handleSubmit}
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
          </div>
        </div>
      </Modal>
    </div>
  );
}

export default TeamPopup;
