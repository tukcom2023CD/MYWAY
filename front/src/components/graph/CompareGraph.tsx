/* eslint-disable no-nested-ternary */
/* eslint-disable no-plusplus */
/* eslint-disable no-restricted-syntax */
import React, { useState, useEffect } from "react";
import {
  Radar,
  RadarChart,
  PolarGrid,
  PolarAngleAxis,
  ResponsiveContainer,
} from "recharts";
import refresh from "../../images/refresh.png";
import mainData from "./GraphData/mainData";
import subData1 from "./GraphData/subData1";
import subData2 from "./GraphData/subData2";

type AverageData = {
  [key: string]: {
    main: number;
    sub1: number;
    sub2: number;
  };
};

function calculateSubjectAverage(
  datasets: { subject: string; A: number; fullMark: number }[][],
  subject: string
) {
  const sum = { main: 0, sub1: 0, sub2: 0 };
  const count = { main: 0, sub1: 0, sub2: 0 };

  // Main data
  const foundSubjectMain = datasets[0].find((item) => item.subject === subject);
  if (foundSubjectMain) {
    sum.main += foundSubjectMain.A;
    count.main++;
  }

  // Sub data 1
  const foundSubjectSub1 = datasets[1].find((item) => item.subject === subject);
  if (foundSubjectSub1) {
    sum.sub1 += foundSubjectSub1.A;
    count.sub1++;
  }

  // Sub data 2
  const foundSubjectSub2 = datasets[2].find((item) => item.subject === subject);
  if (foundSubjectSub2) {
    sum.sub2 += foundSubjectSub2.A;
    count.sub2++;
  }

  return {
    main: count.main === 0 ? 0 : sum.main / count.main,
    sub1: count.sub1 === 0 ? 0 : sum.sub1 / count.sub1,
    sub2: count.sub2 === 0 ? 0 : sum.sub2 / count.sub2,
  };
}

function CompareGraph() {
  const [averages, setAverages] = useState<AverageData>({});

  useEffect(() => {
    const newAverages: AverageData = {};
    for (const item of mainData) {
      const average = calculateSubjectAverage(
        [mainData, subData1, subData2],
        item.subject
      );
      newAverages[item.subject] = average;
    }
    setAverages(newAverages);
  }, []);

  return (
    <div className='flex flex-col bg-white w-[500px] h-[400px] border'>
      <div className='flex justify-between items-center p-5 h-[50px] bg-[#6A6A6A]'>
        <p className='text-white text-md font-bold'>기여도 비교분석</p>
        <img
          className='w-[24px] h-[24px] bg-[#EAEAEA] rounded-[5px]'
          alt='refresh'
          src={refresh}
        />
      </div>
      <div className='flex m-auto w-[500px] h-[500px]'>
        {/* 부모 요소의 크기 조정 */}
        <div className='m-auto w-[500px] h-[300px]'>
          {/* RadarChart 영역 */}
          <ResponsiveContainer width='100%' height='100%'>
            <RadarChart cx='50%' cy='50%' outerRadius='80%' data={mainData}>
              <PolarGrid />
              <PolarAngleAxis dataKey='subject' />
              <Radar
                name='Mike'
                dataKey='A'
                stroke='#8884d8'
                fill='#8884d8'
                fillOpacity={0.6}
              />
            </RadarChart>
          </ResponsiveContainer>
          <div className='text-center mt-4'>
            <p>평균 기여도 (Subject-wise)</p>
            {Object.keys(averages).map((subject) => (
              <div key={subject}>
                <p>{subject}</p>
                <p>Main: {averages[subject]?.main.toFixed(2)}</p>
                <p>Sub1: {averages[subject]?.sub1.toFixed(2)}</p>
                <p>Sub2: {averages[subject]?.sub2.toFixed(2)}</p>

                {/* MainData와 비교 로직 */}
                <p>
                  MainData 비교 결과:{" "}
                  {averages[subject]?.main >
                  Math.max(averages[subject]?.sub1, averages[subject]?.sub2)
                    ? "가장 높음"
                    : averages[subject]?.main <
                      Math.min(averages[subject]?.sub1, averages[subject]?.sub2)
                    ? "가장 낮음"
                    : "중간"}
                </p>
              </div>
            ))}
          </div>
        </div>
      </div>
    </div>
  );
}

export default CompareGraph;
