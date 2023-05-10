import React from 'react';
import { NavLink } from 'react-router-dom';
import Profile from './Profile';
import menu from '../../../images/menu.png';
import dashboard from '../../../images/dashboard.png';
import project from '../../../images/project.png';
import agora from '../../../images/dailyscrum.png';
import anaylsis from '../../../images/graph.png';
import logout from '../../../images/login.png';

function Sidebar() {
  const activeStyle = {
    background: '#D8F1FF',
  };

  return (
    <div className='flex drop-shadow-xl'>
      <div className='flex flex-col items-center h-screen p-5 bg-[#404040] shadow w-60'>
        <div className='space-y-3'>
          <div className='flex items-center'>
            <img
              className='w-[24px] h-[24px] mr-[10px]'
              alt='dashboardicon'
              src={menu}
            />
            <h2 className='text-[#2093D3] text-xl font-bold'>CreWship</h2>
          </div>
          <Profile />
          <div className='flex-1'>
            <ul className='pt-2 pb-4 space-y-1 text-sm'>
              <li className='rounded-sm'>
                <NavLink
                  className='flex items-center p-2 space-x-3 rounded-xl'
                  style={({ isActive }) => (isActive ? activeStyle : {})}
                  to='/DashBoard'
                >
                  <img
                    className='w-[24px] h-[24px]'
                    alt='dashboardIcon'
                    src={dashboard}
                  />
                  <span className='text-white'>DashBoard</span>
                </NavLink>
              </li>
              <li className='rounded-sm'>
                <NavLink
                  className='flex items-center p-2 space-x-3 rounded-xl'
                  style={({ isActive }) => (isActive ? activeStyle : {})}
                  to='/Project'
                >
                  <img
                    className='w-[24px] h-[24px]'
                    alt='projectIcon'
                    src={project}
                  />
                  <span className='text-white'>Project</span>
                </NavLink>
              </li>
              <li className='rounded-sm'>
                <NavLink
                  className='flex items-center p-2 space-x-3 rounded-xl'
                  style={({ isActive }) => (isActive ? activeStyle : {})}
                  to='/Agora'
                >
                  <img
                    className='w-[24px] h-[24px]'
                    alt='agoraIcon'
                    src={agora}
                  />
                  <span className='text-white'>Agora</span>
                </NavLink>
              </li>
              <li className='rounded-sm'>
                <NavLink
                  className='flex items-center p-2 space-x-3 rounded-xl'
                  style={({ isActive }) => (isActive ? activeStyle : {})}
                  to='/Graph'
                >
                  <img
                    className='w-[24px] h-[24px]'
                    alt='analysisIcon'
                    src={anaylsis}
                  />
                  <span className='text-white'>Analysis</span>
                </NavLink>
              </li>
            </ul>
          </div>
        </div>
        <div className='flex justify-center items-center bg-gray-300 w-[240px] h-[50px] mt-auto mb-[100px] text-[20px]'>
          Logout
          <img
            className='w-[24px] h-[24px] ml-2'
            alt='analysisIcon'
            src={logout}
          />
        </div>
      </div>
    </div>
  );
}

export default Sidebar;
