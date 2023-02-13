import React from 'react';
import { NavLink } from 'react-router-dom';

function menu() {
  const menus = [
    { name: 'Dashbord', path: '/' },
    { name: 'Project', path: '/Project' },
    { name: 'DailyScrum', path: '/DailyScrum' },
    { name: 'Members', path: '/Members' },
  ];
  return <div className='w-[300px] h-[1024px] bg-white drop-shadow-xl' />;
}

export default menu;
