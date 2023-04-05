/* eslint-disable react/prefer-stateless-function */
import * as React from 'react';
import { NavLink } from 'react-router-dom';

export default class SideMenu extends React.Component {
  render() {
    return (
      <div className='side-menu'>
        <ol>
          <li className='tab-button'>
            <NavLink to='/pivot-table-demo'>PIVOT TABLE DEMO</NavLink>
          </li>
        </ol>
        <div className='sub-title'>API and Events</div>
        <ol>
          <li className='tab-button'>
            <NavLink to='/handling-events'>HANDLING EVENTS</NavLink>
          </li>
          <li className='tab-button'>
            <NavLink to='/using-api-calls'>USING API CALLS</NavLink>
          </li>
          <li className='tab-button'>
            <NavLink to='/updating-data'>UPDATING DATA</NavLink>
          </li>
        </ol>
        <div className='sub-title'>Customization</div>
        <ol>
          <li className='tab-button'>
            <NavLink to='/customize-toolbar'>CUSTOMIZING THE TOOLBAR</NavLink>
          </li>
          <li className='tab-button'>
            <NavLink to='/customize-grid'>CUSTOMIZING THE GRID</NavLink>
          </li>
        </ol>
        <div className='sub-title'>Integration</div>
        <ol>
          <li className='tab-button'>
            <NavLink to='/with-highcharts'>WITH HIGHCHARTS</NavLink>
          </li>
          <li className='tab-button'>
            <NavLink to='/with-amcharts'>WITH AMCHARTS</NavLink>
          </li>
        </ol>
      </div>
    );
  }
}
