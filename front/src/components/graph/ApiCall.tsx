/* eslint-disable no-param-reassign */
/* eslint-disable react/no-unused-class-component-methods */
/* eslint-disable @typescript-eslint/ban-types */
/* eslint-disable no-unused-expressions */
import * as React from 'react';
import * as FlexmonsterReact from 'react-flexmonster';
import ToggleSwitch from './Toggle';
import 'flexmonster';

class UsingAPICalls extends React.Component<any, {}> {
  private pivotRef: React.RefObject<FlexmonsterReact.Pivot> =
    React.createRef<FlexmonsterReact.Pivot>();

  private flexmonster!: Flexmonster.Pivot;

  componentDidMount() {
    this.flexmonster = this.pivotRef.current!.flexmonster;
  }

  controllGridCharts = (isGrid: boolean) => {
    isGrid ? this.showGrid() : this.showChart();
  };

  controllInteractiveness = (isInteractive: boolean) => {
    isInteractive ? this.interactive() : this.readOnly();
  };

  showChart = () => {
    this.flexmonster.showCharts('column');
  };

  showGrid = () => {
    this.flexmonster.showGrid();
  };

  readOnly = () => {
    this.flexmonster.setOptions({
      readOnly: true,
    });
    // refresh to apply new options changes
    this.flexmonster.refresh();
  };

  interactive = () => {
    this.flexmonster.setOptions({
      readOnly: false,
    });
    // refresh to apply new options changes
    this.flexmonster.refresh();
  };

  hideContextMenu = () => {
    this.flexmonster.customizeContextMenu(() => []);
  };

  showContextMenu = () => {
    this.flexmonster.customizeContextMenu(null as any);
  };

  render() {
    return (
      <>
        <h1 className='page-title'>Using Flexmonster API calls</h1>

        <div className='description-blocks first-description-block'>
          <p>
            Flexmonster provides{' '}
            <a
              href='https://www.flexmonster.com/api/methods/?r=rm_react'
              target='_blank'
              rel='noopener noreferrer'
              className='title-link'
            >
              API calls
            </a>
          </p>
        </div>

        <div className='description-blocks'>
          <ToggleSwitch
            triggerFunction={this.controllGridCharts}
            labelChecked='Grid'
            labelUnChecked='Column chart'
          />
          {/* <ToggleSwitch
            triggerFunction={this.controllInteractiveness}
            labelChecked='Interactive'
            labelUnChecked='Read-only'
          /> */}
        </div>

        <FlexmonsterReact.Pivot
          ref={this.pivotRef}
          toolbar
          beforetoolbarcreated={(toolbar) => {
            toolbar.showShareReportTab = true;
          }}
          shareReportConnection={{
            url: 'https://olap.flexmonster.com:9500',
          }}
          width='100%'
          height={600}
          componentFolder='https://cdn.flexmonster.com/'
          report='https://cdn.flexmonster.com/github/demo-report.json'
          // licenseKey="XXXX-XXXX-XXXX-XXXX-XXXX"
        />
      </>
    );
  }
}

export default UsingAPICalls;
