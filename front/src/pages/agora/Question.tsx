import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { NavLink } from 'react-router-dom';
import profileImg from '../../images/members.png';
import backImg from '../../images/rightarrow.png';
import Menu from '../../components/frames/Side/Sidebar';

interface Answer {
  content: string;
  answerId: number;
}

interface Writer {
  id: number;
  nickname: string;
  rank: string;
}

interface Comment {
  id: number;
  answerId: number;
  content: string;
  writer: Writer;
}

function Question() {
  const [data, setData] = useState<Answer>({
    content: '',
    answerId: 1,
  });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { value, name } = e.target;
    setData({
      ...data,
      [name]: value,
    });
  };

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    const answerData = {
      content: data.content,
    };
    axios.post('answer-comments', answerData).then((response) => {
      console.log(response.status, response.data);
      window.location.replace('/Question');
    });
  };

  const [commentData, setCommentData] = useState<Comment[]>();

  useEffect(() => {
    async function fetchData(): Promise<void> {
      try {
        const response = await axios.get<Comment[]>('answer-comment/1');
        setCommentData(response.data);
        console.log(response.data);
      } catch (error) {
        console.log(error);
      }
    }
    fetchData();
  }, []);

  const activeStyle = {
    background: '#D8F1FF',
  };

  return (
    <div className='flex m-auto w-[1440px] h-[100vh]'>
      <Menu />
      <div className='flex flex-col justfiy-center items-center m-auto w-[1024px] h-[800px] bg-white rounded-[10px] border'>
        <div className='flex justify-between items-center w-full p-5 h-[50px] bg-[#6A6A6A]'>
          <p className='text-white text-md font-bold'>Agora Question</p>
          <NavLink
            to='/Agora'
            className='flex justify-center items-center ml-auto w-[40px] h-[40px] rounded-[10px] bg-[#4A4A4A] text-white'
          >
            <img className='w-[24px] h-[24px]' alt='agoraIcon' src={backImg} />
          </NavLink>
        </div>
        <div className='flex flex-col border mt-8 w-[950px] h-full m-5 overflow-auto'>
          <div className='flex justify-evenly h-[50px] border items-center'>
            <p>테스트 질문</p>
            <p className='flex'>
              <img
                className='w-[24px] h-[24px] mr-2'
                alt='agoraIcon'
                src={profileImg}
              />
              작성자
            </p>
            <p>2023.06.20</p>
            <p>개발</p>
          </div>
          <div className='flex flex-col justify-start items-start p-5 text-xl bg-[#D4D4D4] h-[200px] border m-5 rounded-[15px]'>
            <p className='mb-5'>요약 : 테스트 질문</p>
            <p>테스트 질문입니다.</p>
          </div>
          <div className='flex flex-col justify-start items-start p-5 text-xl bg-[#D4D4D4] w-[700px] h-[150px] border m-5 rounded-[15px]'>
            <div className='flex items-center'>
              <img
                className='w-[24px] h-[24px] mr-2'
                alt='agoraIcon'
                src={profileImg}
              />
              작성자
            </div>
            <p className='flex bg-white p-2 mt-2 w-full h-full overflow-auto rounded-[15px] text-[15px]'>
              추가 질문
            </p>
          </div>
          {/* <div className='flex flex-col justify-start items-start p-5 text-xl bg-[#D4D4D4] w-[700px] h-[150px] border ml-auto mr-5 rounded-[15px]'>
            <div className='flex items-center'>
              <img
                className='w-[24px] h-[24px] mr-2'
                alt='agoraIcon'
                src={profileImg}
              />
              답변자
            </div>
            <p className='flex bg-white p-2 mt-2 w-full h-full overflow-auto rounded-[15px] text-[15px]'>
              답변
            </p>
          </div> */}

          <ul className='p-5 space-y-3 mb-[50px] w-[950px] h-[650px]'>
            {commentData
              ? commentData.map((commentData) => (
                  <li
                    className='flex flex-col justify-start items-start p-5 text-xl bg-[#D4D4D4] w-[700px] h-[150px] border ml-auto mr-5 rounded-[15px]'
                    key={commentData.id}
                  >
                    <p className='flex bg-white p-2 mt-2 w-full h-full overflow-auto rounded-[15px] text-[15px]'>
                      {commentData.content}
                    </p>
                  </li>
                ))
              : null}
          </ul>
        </div>
        <form
          onSubmit={handleSubmit}
          className='border flex flex-col justify-start items-start p-3 m-5 bg-white w-[950px] h-[150px] rounded-[10px]'
        >
          <label htmlFor='content'>
            <input
              className='text-[15px] w-[920px] h-full flex m-auto'
              name='content'
              type='content'
              value={data.content}
              onChange={handleChange}
              placeholder='답변하기'
            />
          </label>
          <button
            type='submit'
            className='flex justify-center items-center w-[100px] h-[40px] rounded-[10px] bg-[#4A4A4A] text-white text-[15px] ml-auto mt-auto'
          >
            답변하기
          </button>
        </form>
      </div>
    </div>
  );
}

export default Question;
