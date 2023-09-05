import React from "react";
import ProfileImg from "../../../images/members.png";
import { useUser } from "../token/UserContext";

function Profile() {
  const [user] = useUser();

  return (
    <div className='flex justify-center items-center mr-auto w-[150px] h-[50px] rounded-[30px]'>
      <img
        className='w-[30px] h-[30px] bg-gray-400 rounded-[30px] mr-auto'
        alt='ProfileImg'
        src={ProfileImg}
      />
      <div className='flex justify-center items-center m-auto ml-1 text-white'>
        {user ? user.nickname : "최정훈"}
      </div>
    </div>
  );
}

export default Profile;
