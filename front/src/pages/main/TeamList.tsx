import React, { useState, useEffect } from "react";
import TeamListBox from "../../components/frames/TeamList/TeamListBox";

function TeamList() {
  const [nickname, setNickname] = useState("sample");

  useEffect(() => {
    const isLoginSuccessful = true;

    if (isLoginSuccessful) {
      const newNickname = "최정훈";
    }
  }, []);

  useEffect(() => {
    console.log("Changed nickname: ", nickname);
  }, [nickname]);

  return (
    <div className='flex flex-col justify-center items-center m-auto w-[100vw] h-[100vh]'>
      <TeamListBox />
    </div>
  );
}

export default TeamList;
