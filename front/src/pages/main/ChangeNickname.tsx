import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useUser } from "../../components/frames/token/UserContext";

function ChangeNickname() {
  const [user, setUser] = useUser();
  const [nickname, setNickname] = useState("");
  const navigate = useNavigate();

  const handleNicknameChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setNickname(e.target.value);
  };

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    if (user) {
      setUser({ ...user, nickname, isNewUser: false });
    }
    localStorage.setItem("nickname", nickname);
    localStorage.setItem("isNewUser", "false");

    // '/TeamList' 로 리다이렉션
    navigate("/TeamList");
  };

  return (
    <div className='w-[100vw] h-[100vh] flex justify-center items-center fixed bg-[#404040]'>
      <form
        className='border flex flex-col justify-center items-center m-auto bg-white w-[480px] h-[600px] rounded-[30px]'
        onSubmit={handleSubmit}
      >
        <label
          htmlFor='summary'
          className='mb-4 w-[430px] font-bold text-[20px]'
        >
          닉네임 변경
          <input
            type='text'
            placeholder='닉네임을 입력하세요.'
            className='text-[20px] w-[430px] border-b-2'
            onChange={handleNicknameChange}
            value={nickname}
          />
        </label>
        <button
          type='submit'
          className='flex justify-center items-center w-[100px] h-[40px] rounded-[10px] bg-[#4A4A4A] text-white text-[15px]'
        >
          변경하기
        </button>
      </form>
    </div>
  );
}

export default ChangeNickname;
