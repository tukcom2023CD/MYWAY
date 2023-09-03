import React, { useEffect } from "react";
import TeamListBox from "../../components/frames/TeamList/TeamListBox";
import { useUser } from "../../components/frames/token/UserContext";

function TeamList() {
  const [user] = useUser();

  useEffect(() => {
    if (user) {
      console.log("Changed nickname: ", user.nickname);
    }
  }, [user]);

  return (
    <div className='flex flex-col justify-center items-center m-auto w-[100vw] h-[100vh]'>
      <TeamListBox />
    </div>
  );
}

export default TeamList;
