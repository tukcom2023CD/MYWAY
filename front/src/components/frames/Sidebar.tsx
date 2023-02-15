import React from 'react';
import { NavLink } from 'react-router-dom';
import menu from '../../images/menu.png';
import dashboard from '../../images/dashboard.png';
import project from '../../images/project.png';
import dailyscrum from '../../images/dailyscrum.png';
import members from '../../images/members.png';

function Sidebar() {
  const activeStyle = {
    background: '#D8F1FF',
  };

  return (
    <div className='flex drop-shadow-xl'>
      <div className='flex flex-col items-center h-screen p-5 bg-white shadow w-60'>
        <div className='space-y-3'>
          <div className='flex items-center'>
            <img
              className='w-[24px] h-[24px] mr-[10px]'
              alt='dashboardicon'
              src={menu}
            />
            <h2 className='text-[#2093D3] text-xl font-bold'>CreWship</h2>
          </div>
          <div className='flex-1'>
            <ul className='pt-2 pb-4 space-y-1 text-sm'>
              <li className='rounded-sm'>
                <NavLink
                  className='flex items-center p-2 space-x-3 rounded-xl'
                  style={({ isActive }) => (isActive ? activeStyle : {})}
                  to='/'
                >
                  <img
                    className='w-[24px] h-[24px]'
                    alt='dashboardicon'
                    src={dashboard}
                  />
                  <span>DashBoard</span>
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
                    alt='dashboardicon'
                    src={project}
                  />
                  <span>Project</span>
                </NavLink>
              </li>
              <li className='rounded-sm'>
                <NavLink
                  className='flex items-center p-2 space-x-3 rounded-xl'
                  style={({ isActive }) => (isActive ? activeStyle : {})}
                  to='/DailyScrum'
                >
                  <img
                    className='w-[24px] h-[24px]'
                    alt='dashboardicon'
                    src={dailyscrum}
                  />
                  <span>DailyScrum</span>
                </NavLink>
              </li>
              <li className='rounded-sm'>
                <NavLink
                  className='flex items-center p-2 space-x-3 rounded-xl'
                  style={({ isActive }) => (isActive ? activeStyle : {})}
                  to='/Members'
                >
                  <img
                    className='w-[24px] h-[24px]'
                    alt='dashboardicon'
                    src={members}
                  />
                  <span>Members</span>
                </NavLink>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Sidebar;
