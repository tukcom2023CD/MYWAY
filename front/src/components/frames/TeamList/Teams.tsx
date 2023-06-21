import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { NavLink } from 'react-router-dom';
import moveImg from '../../../images/login.png';

interface Member {
  id: number;
  name: string;
}

interface Team {
  id: number;
  name: string;
  industryGroup: string;
}

interface TeamData {
  id: number;
  rank: string;
  isAcceptMember: boolean;
  isAcceptTeam: boolean;
  nickname: string;
  member: Member;
  team: Team;
}

function Teams() {
  const [teamData, setTeamData] = useState<TeamData[]>();

  useEffect(() => {
    async function fetchData(): Promise<void> {
      try {
        const response = await axios.get<TeamData[]>('staffs/myteam');
        setTeamData(response.data);
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
    <div>
      <ul className='w-[500px] h-[50px]'>
        {teamData
          ? teamData.map((teamData) => (
              <li
                className='border flex space-x-2 justify-start items-center w-[500px] h-[50px] p-3'
                key={teamData.id}
              >
                {teamData.team.name}
                <NavLink
                  className='flex justify-center items-center ml-auto w-[60px] h-[40px] rounded-[999px] bg-[#4A4A4A] text-white'
                  style={({ isActive }) => (isActive ? activeStyle : {})}
                  to='/dashboard'
                >
                  <img
                    className='w-[24px] h-[24px]'
                    alt='agoraIcon'
                    src={moveImg}
                  />
                </NavLink>
              </li>
            ))
          : null}
      </ul>
    </div>
  );
}

export default Teams;
