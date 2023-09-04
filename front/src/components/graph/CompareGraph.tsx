/* eslint-disable no-plusplus */
/* eslint-disable no-restricted-syntax */
/* eslint-disable no-unsafe-optional-chaining */
import React, { useState, useEffect } from "react";
import {
  Radar,
  RadarChart,
  PolarGrid,
  PolarAngleAxis,
  ResponsiveContainer,
} from "recharts";
import { useUser } from "../frames/token/UserContext";
import refresh from "../../images/refresh.png";
import mainData from "./GraphData/mainData";
import subData1 from "./GraphData/subData1";
import subData2 from "./GraphData/subData2";

type AverageData = {
  [key: string]: {
    main: number;
    sub1: number;
    sub2: number;
    average: number;
  };
};

function calculateSubjectAverage(
  datasets: { subject: string; A: number; fullMark: number }[][],
  subject: string
) {
  let sum = 0;
  let count = 0;

  for (const dataset of datasets) {
    const foundSubject = dataset.find(
      (item: { subject: any }) => item.subject === subject
    );
    if (foundSubject) {
      sum += foundSubject.A;
      count++;
    }
  }

  return count === 0 ? 0 : sum / count;
}

function CompareGraph() {
  const [averages, setAverages] = useState<AverageData>({});
  const [chartData, setChartData] = useState<any[]>([]);

  const [user] = useUser();
  const currentNickname = user ? user.nickname : "Guest";

  useEffect(() => {
    const activeData = currentNickname === "최정훈" ? mainData : subData1;

    const newAverages: AverageData = {};
    for (const item of activeData) {
      const average = calculateSubjectAverage(
        [mainData, subData1, subData2],
        item.subject
      );
      newAverages[item.subject] = {
        main: calculateSubjectAverage([activeData], item.subject),
        sub1: calculateSubjectAverage([subData1], item.subject),
        sub2: calculateSubjectAverage([subData2], item.subject),
        average,
      };
    }
    setAverages(newAverages);

    const calculatedChartData = activeData.map((data) => ({
      ...data,
      average: newAverages[data.subject]?.average || 0,
    }));
    setChartData(calculatedChartData);
  }, [currentNickname]);

  const getWarningMessage = () => {
    const subjectsBelowAverage = Object.keys(averages).filter(
      (subject) => averages[subject]?.main < averages[subject]?.average
    );

    if (subjectsBelowAverage.length === 0) return null;

    const subjectsList = subjectsBelowAverage.join(", ");
    return `해당 부분에 대한 보완이 필요\n -> ${subjectsList}`;
  };

  return (
    <div className='flex flex-col mt-[20px] bg-white w-[1000px] h-[400px] border'>
      <div className='flex justify-between items-center p-5 h-[50px] bg-[#6A6A6A]'>
        <p className='text-white text-md font-bold'>프로젝트 기여도</p>
        <img
          className='w-[24px] h-[24px] bg-[#EAEAEA] rounded-[5px]'
          alt='refresh'
          src={refresh}
        />
      </div>
      <div className='flex justify-evenly itmes-center m-auto w-[1000px] h-[500px]'>
        <div className='flex flex-col justify-center items-center w-[500px] h-[300px] m-auto'>
          <ResponsiveContainer width='100%' height='100%'>
            <RadarChart cx='50%' cy='50%' outerRadius='80%' data={chartData}>
              <PolarGrid />
              <PolarAngleAxis dataKey='subject' />
              <Radar
                name='Main'
                dataKey='A'
                stroke='#8884d8'
                fill='#8884d8'
                fillOpacity={0.6}
              />
              <Radar
                name='Average'
                dataKey='average'
                stroke='#82ca9d'
                fill='#82ca9d'
                fillOpacity={0.6}
              />
            </RadarChart>
          </ResponsiveContainer>
          <div className='text-center flex justify-center'>
            <div className='flex items-center'>
              <div className='w-4 h-4 bg-[#8884d8] inline-block mr-2' />
              <span>내 기여도</span>
            </div>
            <div className='flex items-center ml-4'>
              <div className='w-4 h-4 bg-[#82ca9d] inline-block mr-2' />
              <span>평균</span>
            </div>
          </div>
        </div>
        <div className='flex flex-col justify-center items-start space-y-2 w-[400px] p-2 m-auto'>
          <p>평균 기여도</p>
          {Object.keys(averages).map((subject) => (
            <div key={subject}>
              <p>
                {subject}
                {` : `}
                {averages[subject]?.main > averages[subject]?.average
                  ? `평균보다 ${(
                      averages[subject]?.main - averages[subject]?.average
                    ).toFixed(0)}P 높음`
                  : `평균보다 ${(
                      averages[subject]?.average - averages[subject]?.main
                    ).toFixed(0)}P 낮음`}
              </p>
            </div>
          ))}
          {getWarningMessage() && (
            <p className='text-red-500' style={{ whiteSpace: "pre-line" }}>
              {getWarningMessage()}
            </p>
          )}
        </div>
      </div>
    </div>
  );
}

export default CompareGraph;
