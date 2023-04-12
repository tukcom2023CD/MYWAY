/* eslint-disable react/prefer-stateless-function */
/* eslint-disable no-param-reassign */
import * as React from 'react';
import * as FlexmonsterReact from 'react-flexmonster';
import 'flexmonster';

class PivotTableDemo extends React.Component {
  render() {
    return (
      <>
        <h1 className='page-title'>Pivot Table Demo</h1>

        <div className='description-blocks first-description-block'>
          <p>
            Visit
            <a
              href='https://www.flexmonster.com/doc/?r=rm_react'
              target='_blank'
              rel='noopener noreferrer'
              className='title-link'
            >
              our documentation
            </a>
          </p>
        </div>

        <div className='App'>
          <FlexmonsterReact.Pivot
            toolbar
            beforetoolbarcreated={(toolbar) => {
              toolbar.showShareReportTab = true;
            }}
            shareReportConnection={{
              url: 'https://olap.flexmonster.com:9500',
            }}
            width='100%'
            height={600}
            report='https://cdn.flexmonster.com/github/demo-report.json'
            // licenseKey="XXXX-XXXX-XXXX-XXXX-XXXX"
          />
        </div>
      </>
    );
  }
}

export default PivotTableDemo;

/** react pivvottable */
/** react-flexmonster */
