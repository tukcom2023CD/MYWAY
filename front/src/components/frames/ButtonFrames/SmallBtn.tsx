import React from 'react';

interface SmallBtn {
  button: void;
}

function SmallBtn() {
  return (
    <button
      type='button'
      className='flex justify-center items-center w-[50px] h-[40px] rounded-[999px] bg-[#4cb0eb] text-white'
    >
      큰 버튼
    </button>
  );
}

export default SmallBtn;
