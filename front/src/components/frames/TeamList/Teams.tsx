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

  return (
    <div>
      <ul className='w-[500px] h-[50px]'>
        {teamData
          ? teamData.map((team) => (
              <li
                className='border flex space-x-2 justify-start items-center w-[500px] h-[50px]'
                key={team.name}
              >
                {team.name}
              </li>
            ))
          : null}
      </ul>
    </div>
  );
}

export default Teams;
