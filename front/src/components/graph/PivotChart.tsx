import * as d3 from 'd3';
import React, { FunctionComponent, useEffect, useRef } from 'react';

interface PivotLineChartProps {
  data: { x: number; y: number }[];
}

const PivotLineChart: FunctionComponent<PivotLineChartProps> = ({ data }) => {
  const svgRef = useRef<SVGSVGElement>(null);

  useEffect(() => {
    // 차트의 크기를 정의합니다.
    const margin = { top: 20, right: 20, bottom: 30, left: 50 };
    const width = 600 - margin.left - margin.right;
    const height = 400 - margin.top - margin.bottom;

    // SVG 요소를 생성하고 크기를 설정합니다.
    const svg = d3
      .select(svgRef.current)
      .attr('width', width + margin.left + margin.right)
      .attr('height', height + margin.top + margin.bottom)
      .append('g')
      .attr('transform', `translate(${margin.left}, ${margin.top})`);

    // 스케일을 정의합니다.
    const xScale = d3
      .scaleLinear()
      .domain(d3.extent(data, (d) => d.x) as [number, number])
      .range([0, width]);

    const yScale = d3
      .scaleLinear()
      .domain([0, d3.max(data, (d) => d.y) as number])
      .range([height, 0]);

    // 라인 생성기를 정의합니다.
    const line = d3
      .line<{ x: number; y: number }>()
      .x((d) => xScale(d.x))
      .y((d) => yScale(d.y));

    // 라인을 그립니다.
    svg.append('path').datum(data).attr('class', 'line').attr('d', line);

    // x축을 그립니다.
    svg
      .append('g')
      .attr('class', 'x-axis')
      .attr('transform', `translate(0, ${height})`)
      .call(d3.axisBottom(xScale));

    // y축을 그립니다.
    svg.append('g').attr('class', 'y-axis').call(d3.axisLeft(yScale));
  }, [data]);

  return <svg ref={svgRef} />;
};

export default PivotLineChart;
