import axios from 'axios';
import React, { useState, useEffect } from 'react';

interface AcceptApply {
  rank: string;
}

function AcceptApply() {
  const [acceptApply, setAcceptApply] = useState<AcceptApply>({
    rank: '',
  });

  useEffect(() => {
    axios
      .get<AcceptApply>(`staffs/apply`)
      .then((response) => setAcceptApply(response.data))
      .catch((error) => console.log(error));
  }, []);
  return <div>AcceptApply</div>;
}

export default AcceptApply;
