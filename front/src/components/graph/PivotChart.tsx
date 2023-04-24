import React from 'react';
import { Line } from 'react-chartjs-2';

interface ChartData {
  labels: string[];
  datasets: {
    label: string;
    data: number[];
    fill?: boolean;
    backgroundColor?: string;
    borderColor?: string;
    tension?: number;
  }[];
}

interface ChartOptions {
  responsive?: boolean;
  maintainAspectRatio?: boolean;
}

interface LineChartProps {
  data: ChartData;
  options?: ChartOptions;
}

const PivotChart: React.FC<LineChartProps> = ({ data, options }) => {
  const defaultOptions = {
    responsive: true,
    maintainAspectRatio: false,
  };

  const chartOptions = options
    ? { ...defaultOptions, ...options }
    : defaultOptions;

  return <Line data={data} options={chartOptions} />;
};

PivotChart.defaultProps = {
  options: {
    responsive: true,
    maintainAspectRatio: false,
  },
};

export default PivotChart;
