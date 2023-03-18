import React, { useState, useCallback } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import Teams from './Teams';
import TeamPopup from '../../Popup/TeamPopup';
import rightarrow from '../../../images/rightarrow.png';

function TeamListBox() {
  const [showCreateTeam, setShowCreateTeam] = useState(false);
  const [name, setName] = useState();
  const [industryGroup, setIndustryGroup] = useState();

  const navigate = useNavigate();

  const onChangeHandler = useCallback(
    (e: React.ChangeEvent<HTMLInputElement>) => {
      setName((e.target as any).value);
      setIndustryGroup((e.target as any).value);
    },
    []
  );

  const onCreateTeam = useCallback((e: any) => {
    e.preventDefault();
    axios
      .post('teams', {
        name,
        industryGroup,
      })
      .then((response) => {
        navigate('/TeamList');
        console.log(response);
      });
  }, []);

  const onCloseModal = useCallback(() => {
    setShowCreateTeam(false);
  }, []);

  const onClickCreateTeam = useCallback(() => {
    setShowCreateTeam(true);
  }, [name, industryGroup]);

  return (
    <div className='flex flex-col justfiy-center items-center h-[100vh]'>
      <p className='font-bold text-[30px] mt-[10vh] mb-5'>CreWship</p>
      <div className='flex justify-between w-full mb-5'>
        <div className='border w-[300px] h-full text-[20px] font-bold text-center pt-1'>
          선택한 항목 없음
        </div>
        <button
          type='button'
          className='flex justify-center items-center w-[100px] h-[40px] rounded-[999px] bg-[#1AAAFB] text-white'
        >
          열기
          <img
            className='w-[24px] h-[24px] ml-2 color-white'
            alt='rightarrow'
            src={rightarrow}
          />
        </button>
      </div>
      <div className='border flex flex-col mb-5 w-full h-[500px] rounded-[30px] shadow-md overflow-y-auto'>
        <Teams />
      </div>
      <TeamPopup show={showCreateTeam} onCloseModal={onCloseModal}>
        <form onSubmit={onCreateTeam}>
          <label htmlFor='team'>
            <span>팀 생성</span>
          </label>
          <div className='border flex flex-col justify-center items-center m-auto bg-white w-[480px] h-[600px] rounded-[30px]'>
            <p className='font-bold text-[25px] p-7'>팀 생성</p>
            <div className='mb-4 w-[430px]'>
              <p className='font-bold text-[20px]'>제목</p>
              <input
                id='name'
                className='text-[20px] w-[430px] border-b-2'
                placeholder='제목을 입력해주세요.'
                onChange={onChangeHandler}
              />
            </div>
            <div className='mb-4 w-[430px]'>
              <p className='font-bold text-[20px]'>부서명</p>
              <input
                id='industryGroup'
                className='text-[20px] w-[430px] border-b-2'
                placeholder='부서명을 입력하세요.'
                onChange={onChangeHandler}
              />
            </div>
            <div className='flex space-x-2'>
              <button
                type='submit'
                className='flex justify-center items-center w-[100px] h-[40px] rounded-[30px] bg-[#0075FF] text-white text-[12px]'
              >
                생성하기
              </button>
              <button
                type='button'
                className='flex justify-center items-center w-[100px] h-[40px] rounded-[30px] bg-[#0075FF] text-white text-[12px]'
              >
                닫기
              </button>
            </div>
          </div>
        </form>
      </TeamPopup>
    </div>
  );
}

export default TeamListBox;
