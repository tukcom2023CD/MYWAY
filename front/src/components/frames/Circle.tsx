import React from 'react';

type Props = {
  size: number;
  bgColor: string;
  borderSize: number;
  borderColor: string;
};

const Circle: React.FC<Props> = ({
  size = 50,
  bgColor = 'gray',
  borderSize = 2,
  borderColor = 'black',
}) => (
  <div
    className={`w-${size} h-${size} rounded-full bg-${bgColor} border-${borderSize} border-${borderColor}`}
  />
);

export default Circle;
