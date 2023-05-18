import React from 'react';

interface BigBtn {
  button: void;
}

function BigBtn() {
  return (
    <button
      type='button'
      className='flex justify-center items-center w-[150px] h-[60px] rounded-[999px] bg-[#4cb0eb] text-white'
    >
      큰 버튼
    </button>
  );
}

export default BigBtn;
