import React, { useState } from 'react';
import {
  LineChart,
  Line,
  XAxis,
  YAxis,
  CartesianGrid,
  Tooltip,
  Legend,
} from 'recharts';
import Menu from '../../components/frames/Side/Sidebar';
import TaskImg from '../../images/project.png';

const data = [
  {
    date: '2022.02.01',
    최정훈: 15,
    권순호: 0,
    박현준: 20,
    염종협: 10,
  },
  {
    date: '2022.02.03',
    최정훈: 0,
    권순호: 20,
    박현준: 10,
    염종협: 10,
  },
  {
    date: '2022.02.08',
    최정훈: 15,
    권순호: 10,
    박현준: 15,
    염종협: 20,
  },
  {
    date: '2022.02.13',
    최정훈: 5,
    권순호: 15,
    박현준: 0,
    염종협: 0,
  },
  {
    date: '2022.02.15',
    최정훈: 15,
    권순호: 20,
    박현준: 15,
    염종협: 20,
  },
];

function Graph() {
  const [inputs, setInputs] = useState({ 최정훈: '' });
  const [points, setPoints] = useState(data);

  const newData = {
    date: '2022.02.16',
    최정훈: 30,
    권순호: 0,
    박현준: 0,
    염종협: 0,
  };

  const newDatas = {
    date: '2022.02.16',
    최정훈: 45,
    권순호: 0,
    박현준: 0,
    염종협: 0,
  };

  const onClick = () => {
    const addPoints = points.concat(newData);
    setPoints(addPoints);
  };

  const onRemove = () => {
    setPoints(points.filter((newData) => newData.date !== '2022.02.16'));
  };

  const onCreate = () => {
    const addPoints = points.concat(newDatas);
    setPoints(addPoints);
  };

  return (
    <div className='flex m-auto w-[1440px] h-[100vh] bg-[#D8F1FF]'>
      <Menu />
      <div className='flex flex-col p-5 justfiy-center items-center m-auto w-[1024px] h-[800px] bg-white rounded-[30px]'>
        <LineChart
          className='flex justify-center items-center m-auto'
          width={800}
          height={400}
          data={points}
          margin={{
            top: 5,
            right: 30,
            left: 20,
            bottom: 5,
          }}
        >
          <CartesianGrid strokeDasharray='3 3' />
          <XAxis dataKey='date' />
          <YAxis />
          <Tooltip />
          <Legend />
          <Line
            type='monotone'
            dataKey='최정훈'
            stroke='#8884d8'
            activeDot={{ r: 8 }}
          />
          <Line type='monotone' dataKey='권순호' stroke='#82ca9d' />
          <Line type='monotone' dataKey='박현준' stroke='#db951e' />
          <Line type='monotone' dataKey='염종협' stroke='#12bbdd' />
        </LineChart>
        <div className='border flex flex-col justify-center items-right mr-[24px] bg-white w-[500px] h-[300px] rounded-[30px]'>
          <div className='flex justify-center items-bottom w-[500px] h-[50px] p-6 mb-3'>
            <p className='m-auto text-[20px] font-bold'>진행중인 태스크 목록</p>
          </div>
          <div className='flex flex-col justify-start w-[500px] h-[400px] p-5 overflow-y-auto'>
            <div className='flex justify-start items-center w-[440px] h-[30px] mb-2 bg-[#DBDBDB] rounded-[30px]'>
              <img
                className='w-[30px] h-[30px] bg-gray-400 rounded-[30px]'
                alt='ProfileImg'
                src={TaskImg}
              />
              <div className='flex justify-center items-center ml-5'>
                태스크1
              </div>
              <div className='flex justify-center items-center ml-5'>30pt</div>
              <button
                type='button'
                onClick={onClick}
                className='flex justify-center items-center ml-[180px] w-[50px] h-[30px] bg-[#D8F1FF] rounded-full'
              >
                완료
              </button>
              <button
                type='button'
                onClick={onRemove}
                className='flex justify-center items-center ml-auto w-[50px] h-[30px] bg-[#f09696] rounded-full'
              >
                취소
              </button>
            </div>
            <div className='flex justify-start items-center w-[440px] h-[30px] mb-2 bg-[#DBDBDB] rounded-[30px]'>
              <img
                className='w-[30px] h-[30px] bg-gray-400 rounded-[30px]'
                alt='ProfileImg'
                src={TaskImg}
              />
              <div className='flex justify-center items-center ml-5'>
                태스크2
              </div>
              <div className='flex justify-center items-center ml-5'>15pt</div>
              <button
                type='button'
                onClick={onCreate}
                className='flex justify-center items-center ml-[180px] w-[50px] h-[30px] bg-[#D8F1FF] rounded-full'
              >
                완료
              </button>
              <button
                type='button'
                onClick={onClick}
                className='flex justify-center items-center ml-auto w-[50px] h-[30px] bg-[#f09696] rounded-full'
              >
                취소
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Graph;
