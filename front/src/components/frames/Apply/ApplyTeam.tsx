import axios from 'axios';
import React, { useState, useEffect } from 'react';

interface Apply {
  teamId: string;
}

function ApplyTeam() {
  const [apply, setApply] = useState<Apply>({
    teamId: '',
  });

  useEffect(() => {
    axios
      .get<Apply>(`staffs/apply`)
      .then((response) => setApply(response.data))
      .catch((error) => console.log(error));
  }, []);

  return <div>ApplyTeam</div>;
}

export default ApplyTeam;
