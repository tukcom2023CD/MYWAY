import React, { useState, useEffect } from "react";
import TeamListBox from "../../components/frames/TeamList/TeamListBox";

function TeamList() {
  const [nickname, setNickname] = useState("sample");

  useEffect(() => {
    const isLoginSuccessful = true;

    if (isLoginSuccessful) {
      const newNickname = "최정훈";
      setNickname(newNickname);
    }
    console.log(setNickname);
  }, []);

  return (
    <div className='flex flex-col justify-center items-center m-auto w-[100vw] h-[100vh]'>
      <TeamListBox />
    </div>
  );
}

export default TeamList;
