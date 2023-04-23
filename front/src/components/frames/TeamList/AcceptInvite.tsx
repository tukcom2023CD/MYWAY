import axios from 'axios';
import React, { useState, useEffect } from 'react';
import Modal from 'react-modal';

interface List {
  id: number;
  nickname: string;
  rank: string;
  isAcceptMember: boolean;
  isAcceptTeam: boolean;
  name: string;
  industryGroup: string;
}

interface PostAcceptInvite {
  nickname: string;
}

function InviteList() {
  const [modalIsOpen, setIsOpen] = useState(false);
  const [inviteList, setInviteList] = useState<List[]>([]);
  const [accept, setAccept] = useState<PostAcceptInvite>({
    nickname: '',
  });

  function openModal() {
    setIsOpen(true);
  }

  function closeModal() {
    setIsOpen(false);
  }

  useEffect(() => {
    getList();
  }, []);

  const getList = async () => {
    try {
      const response = await axios.get<List[]>('staffs/invite?id=1');
      setInviteList(response.data);
      console.log(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    try {
      const response = await axios.post('staffs/1/accept-invite', accept);
      console.log(response.data);
    } catch (error) {
      console.error(error);
    }
  };

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
        <div className='border flex flex-col justify-center items-center m-auto bg-white w-[480px] h-[600px] rounded-[30px]'>
          <form
            onSubmit={handleSubmit}
            className='mb-4 w-[430px] font-bold text-[20px]'
          >
            초대온 목록
            <ul>
              {inviteList.map((list: List) => (
                <li className='flex space-x-2 text-[20px] w-[430px] border-2'>
                  {list.name}
                  {list.rank}
                  {list.nickname}
                  <button
                    type='submit'
                    className='flex justify-center items-center w-[50px] h-[40px] rounded-[30px] bg-[#0075FF] text-white text-[12px]'
                  >
                    수락
                  </button>
                  <button
                    type='button'
                    className='flex justify-center items-center w-[50px] h-[40px] rounded-[30px] bg-[#f32861] text-white text-[12px]'
                  >
                    거절
                  </button>
                </li>
              ))}
            </ul>
          </form>
          <div className='flex space-x-2'>
            <button
              type='button'
              onClick={closeModal}
              className='flex justify-center items-center w-[100px] h-[40px] rounded-[30px] bg-[#0075FF] text-white text-[12px]'
            >
              닫기
            </button>
          </div>
        </div>
      </Modal>
    </div>
  );
}

export default InviteList;
