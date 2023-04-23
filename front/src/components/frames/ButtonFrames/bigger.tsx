import React from 'react';

interface BigBtn {
  button: void;
}

function bigger() {
  return (
    <button
      type='button'
      className='flex justify-center items-center w-[150px] h-[60px] rounded-[999px] bg-[#1AAAFB] text-white'
    >
      큰 버튼
    </button>
  );
}

export default bigger;
