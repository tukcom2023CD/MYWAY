import React, { useState, useEffect } from 'react';
import axios from 'axios';

interface TeamData {
  id: number;
  nickname: string;
  rank: string;
  isAcceptMember: boolean;
  isAcceptTeam: boolean;
  name: string;
  industryGroup: string;
}

function Teams() {
  const [teamData, setTeamData] = useState<TeamData[] | null>();

  useEffect(() => {
    getTeamData();
  }, []);

  const getTeamData = async () => {
    try {
      const response = await axios.get<TeamData[]>('staffs/myteam');
      setTeamData(response.data);
      console.log(response);
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <ul className='w-[500px] h-[50px]'>
      {teamData
        ? teamData.map((team) => (
            <li
              className='border flex space-x-2 justify-start items-center w-[500px] h-[50px]'
              key={team.id}
            >
              {team.name}
              {team.nickname}
              {team.industryGroup}
            </li>
          ))
        : null}
    </ul>
  );
}

export default Teams;
