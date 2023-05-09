/* eslint-disable jsx-a11y/click-events-have-key-events */
/* eslint-disable jsx-a11y/no-noninteractive-element-interactions */
import React, { useState } from 'react';
import Circle from './Circle';

function DropDown() {
  const [isOpen, setIsOpen] = useState(false);
  const [selectedOption, setSelectedOption] = useState('');

  // 각각의 li가 선택되었는지 여부를 나타내는 state 변수
  const [isSelected1, setIsSelected1] = useState(false);
  const [isSelected2, setIsSelected2] = useState(false);
  const [isSelected3, setIsSelected3] = useState(false);

  const onToggle = () => setIsOpen(!isOpen);

  const onSelectOption = (option: React.SetStateAction<string>) => {
    setSelectedOption(option);
    setIsOpen(false);
  };

  const liStyle1 = `flex justify-center items-center font-[12pt] border ${
    isSelected1 ? 'bg-gray-600 text-white' : 'bg-gray-500 text-black'
  }`;

  const liStyle2 = `flex justify-center items-center font-[12pt] ${
    isSelected2 ? 'bg-yellow-600 text-white' : 'bg-yellow-500 text-black'
  }`;

  const liStyle3 = `flex justify-center items-center font-[12pt] ${
    isSelected3 ? 'bg-green-600 text-white' : 'bg-green-500 text-black'
  }`;

  return (
    <div className='flex justify-center items-center mr-auto h-[20px] ml-2'>
      <button
        type='button'
        className='ml-auto w-[60px] h-[30px] rounded-[30px]'
        onClick={onToggle}
      >
        진행상황
      </button>
      <div>
        <ul className='flex flex-col w-[100%] h-[100%] list-none overflow-y-scroll'>
          {isOpen && (
            <>
              <li
                className={liStyle1}
                onClick={() => {
                  onSelectOption('대기');
                  setIsSelected1(true);
                  setIsSelected2(false);
                  setIsSelected3(false);
                }}
              >
                대기
              </li>
              <li
                className={liStyle2}
                onClick={() => {
                  onSelectOption('진행중');
                  setIsSelected1(false);
                  setIsSelected2(true);
                  setIsSelected3(false);
                }}
              >
                <Circle
                  size={100}
                  bgColor='blue'
                  borderSize={4}
                  borderColor='white'
                />
                진행중
              </li>
              <li
                className={liStyle3}
                onClick={() => {
                  onSelectOption('완료');
                  setIsSelected1(false);
                  setIsSelected2(false);
                  setIsSelected3(true);
                }}
              >
                완료
              </li>
            </>
          )}
          {!isOpen && selectedOption && (
            <li className='flex justify-center items-center font-[12pt]'>
              : {selectedOption}
            </li>
          )}
        </ul>
      </div>
    </div>
  );
}

export default DropDown;
