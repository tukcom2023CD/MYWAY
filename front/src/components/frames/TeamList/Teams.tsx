import React, { useState, useEffect } from 'react';
import axios from 'axios';

interface Member {
  id: string;
  name: string;
}

interface Team {
  id: string;
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
        console.log(response.data.map);
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
          ? teamData.map((teamData) => (
              <li
                className='border flex space-x-2 justify-start items-center w-[500px] h-[50px]'
                key={teamData.id}
              >
                {teamData.team.name}
              </li>
            ))
          : null}
      </ul>
    </div>
  );
}

export default Teams;
