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

interface PostAcceptApply {
  rank: string;
}

function InviteApprove() {
  const [modalIsOpen, setIsOpen] = useState(false);
  const [accept, setAccept] = useState<List[]>([]);
  const [acceptApply, setAcceptApply] = useState<PostAcceptApply>({
    rank: '',
  });

  function openModal() {
    setIsOpen(true);
  }

  function closeModal() {
    setIsOpen(false);
  }

  useEffect(() => {
    axios
      .get<List[]>(`staffs/apply?team-id=7`)
      .then((response) => setAccept(response.data))
      .catch((error) => console.log(error));
  }, []);

  const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    try {
      const response = await axios.post('staffs/1/accept-apply', acceptApply);
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
        승인 대기 목록
      </button>
      <Modal
        isOpen={modalIsOpen}
        className='w-[100vw] h-[100vh] flex justify-center items-center fixed bg-[rgba(0,0,0,0.2)]'
        contentLabel='Test Modal'
      >
        <div className='border flex flex-col justify-center items-center m-auto bg-white w-[480px] h-[600px] rounded-[40px]'>
          <form
            onSubmit={handleSubmit}
            className='mb-4 w-[430px] font-bold text-[20px]'
          >
            승인 대기 목록
            <ul>
              {accept.map((list) => (
                <li className='text-[20px] w-[430px] border-2' key={list.id}>
                  {list.rank}
                  <button
                    type='submit'
                    className='flex justify-center items-center w-[50px] h-[40px] rounded-[30px] bg-[#0075FF] text-white text-[12px]'
                  >
                    수락
                  </button>
                  <button
                    type='button'
                    className='flex justify-center items-center w-[50px] h-[40px] rounded-[40px] bg-[#f32861] text-white text-[12px]'
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
              className='flex justify-center items-center w-[100px] h-[40px] rounded-[40px] bg-[#0075FF] text-white text-[12px]'
            >
              닫기
            </button>
          </div>
        </div>
      </Modal>
    </div>
  );
}

export default InviteApprove;
