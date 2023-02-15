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
import Menu from '../../components/frames/Sidebar';
import TaskList from '../../components/graph/TaskList';

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
  const [points, setPoints] = useState(data);

  const newData = {
    date: '2022.02.16',
    최정훈: 30,
    권순호: 0,
    박현준: 0,
    염종협: 0,
  };

  const onClick = () => {
    const addPoints = points.concat(newData);
    console.log(addPoints);
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
        <TaskList />
        <button
          type='button'
          onClick={onClick}
          className='flex justify-center items-center mt-1 ml-[430px] w-[50px] h-[30px] bg-[#D8F1FF] rounded-full'
        >
          완료
        </button>
      </div>
    </div>
  );
}

export default Graph;
