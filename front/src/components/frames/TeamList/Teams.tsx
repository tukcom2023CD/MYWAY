import React, { useState, useEffect } from 'react';
import axios from 'axios';

export type TeamData = {
  id: number;
  nickname: string;
  rank: string;
  isAcceptMember: boolean;
  isAcceptTeam: boolean;
  name: string;
  industryGroup: string;
};

function Teams() {
  const [teamData, setTeamData] = useState<TeamData[] | null>();

  useEffect(() => {
    axios.get('staffs/myteam').then((response) => {
      setTeamData(response.data);
    });
  }, []);

  return (
    <div className='border flex justify-start items-center w-[500px] h-[50px]'>
      {teamData ? teamData.map((team) => <p>{team.name}</p>) : null}
    </div>
  );
}

export default Teams;
