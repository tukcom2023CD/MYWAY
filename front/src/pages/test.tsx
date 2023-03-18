import React, { useState, useCallback } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import Menu from '../components/frames/Side/Sidebar';
import Popup from '../components/Popup/SprintPopup';
import TeamPopupTest from '../components/Popup/TeamPopup';

function Test() {
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
    <div className='flex m-auto w-[1440px] h-[100vh] bg-[#D8F1FF]'>
      <Menu />
      <div className='flex flex-col p-5 justfiy-center items-center m-auto w-[1024px] h-[800px] bg-white rounded-[30px]'>
        <Popup />
        <TeamPopupTest show={showCreateTeam} onCloseModal={onCloseModal}>
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
        </TeamPopupTest>
      </div>
    </div>
  );
}

export default Test;
