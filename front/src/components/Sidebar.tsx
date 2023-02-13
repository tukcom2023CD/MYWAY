import React from 'react';
import dashboard from '../images/dashboard.png';
import project from '../images/project.png';
import dailyscrum from '../images/dailyscrum.png';
import members from '../images/members.png';

function Sidebar() {
  return (
    <div className='flex'>
      <div className='flex flex-col items-center h-screen p-3 bg-white shadow w-60'>
        <div className='space-y-3'>
          <div className='flex items-center'>
            <h2 className='text-xl font-bold'>CreWship</h2>
          </div>
          <div className='flex-1'>
            <ul className='pt-2 pb-4 space-y-1 text-sm'>
              <li className='rounded-sm'>
                <a
                  href='http://localhost:3000/'
                  className='flex items-center p-2 space-x-3 rounded-md'
                >
                  <img
                    className='w-[24px] h-[24px]'
                    alt='dashboardicon'
                    src={dashboard}
                  />
                  <span>DashBoard</span>
                </a>
              </li>
              <li className='rounded-sm'>
                <a
                  href='http://localhost:3000/Project'
                  className='flex items-center p-2 space-x-3 rounded-md'
                >
                  <img
                    className='w-[24px] h-[24px]'
                    alt='dashboardicon'
                    src={project}
                  />
                  <span>Project</span>
                </a>
              </li>
              <li className='rounded-sm'>
                <a
                  href='http://localhost:3000/DailyScrum'
                  className='flex items-center p-2 space-x-3 rounded-md'
                >
                  <img
                    className='w-[24px] h-[24px]'
                    alt='dashboardicon'
                    src={dailyscrum}
                  />
                  <span>DailyScrum</span>
                </a>
              </li>
              <li className='rounded-sm'>
                <a
                  href='http://localhost:3000/Members'
                  className='flex items-center p-2 space-x-3 rounded-md'
                >
                  <img
                    className='w-[24px] h-[24px]'
                    alt='dashboardicon'
                    src={members}
                  />
                  <span>Members</span>
                </a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Sidebar;
