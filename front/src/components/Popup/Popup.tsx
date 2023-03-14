/* eslint-disable jsx-a11y/click-events-have-key-events */
/* eslint-disable jsx-a11y/no-static-element-interactions */
import React, { useState, useEffect, PropsWithChildren } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

interface PopupDefaultType {
  onClickTogglePopup: () => void;
  onClosePopup: () => void;
}

function TeamPopup({
  onClickTogglePopup,
  onClosePopup,
}: PropsWithChildren<PopupDefaultType>) {
  const [name, setName] = useState();
  const [industryGroup, setIndustryGroup] = useState();

  const teamData = {
    name: `${name}`,
    industryGroup: `${industryGroup}`,
  };

  const navigate = useNavigate();

  const handleSubmit = useEffect(() => {
    axios
      .post(`teams`, teamData, {
        headers: {
          'Content-Type': 'application/json',
        },
      })
      .then((response) => {
        console.log(response);
        navigate('/TeamList');
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  return (
    <div>
      <div
        onClick={(e: React.MouseEvent) => {
          e.preventDefault();

          if (onClickTogglePopup) {
            onClickTogglePopup();
          }
        }}
      />
      <div className='w-[100vw] h-[100vh] flex justify-center items-center fixed bg-[rgba(0,0,0,0.2)]'>
        <div>
          <div className='border flex flex-col justify-center items-center m-auto bg-white w-[480px] h-[600px] rounded-[30px]'>
            <p className='font-bold text-[25px] p-7'>팀 생성</p>
            <div className='mb-4 w-[430px]'>
              <p className='font-bold text-[20px]'>제목</p>
              <input
                className='text-[20px] w-[430px] border-b-2'
                onChange={(e) => setName((e.target as any).value)}
                placeholder='제목을 입력해주세요.'
              />
            </div>
            <div className='mb-4 w-[430px]'>
              <p className='font-bold text-[20px]'>부서명</p>
              <input
                className='text-[20px] w-[430px] border-b-2'
                onChange={(e) => setIndustryGroup((e.target as any).value)}
                placeholder='부서명을 입력하세요.'
              />
            </div>
            <div className='flex space-x-2'>
              <button
                type='button'
                onClick={() => handleSubmit}
                className='flex justify-center items-center w-[100px] h-[40px] rounded-[30px] bg-[#0075FF] text-white text-[12px]'
              >
                생성하기
              </button>
              <button
                type='button'
                onClick={onClosePopup}
                className='flex justify-center items-center w-[100px] h-[40px] rounded-[30px] bg-[#0075FF] text-white text-[12px]'
              >
                닫기
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default TeamPopup;
