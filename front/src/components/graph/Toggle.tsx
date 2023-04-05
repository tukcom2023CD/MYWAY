/* eslint-disable react/destructuring-assignment */
/* eslint-disable react/no-access-state-in-setstate */
/* eslint-disable react/sort-comp */
/* eslint-disable react/no-unused-class-component-methods */
import React from 'react';

interface IProps {
  labelChecked: string;
  labelUnChecked: string;
  triggerFunction: (state: boolean) => void;
}

interface IState {
  isChecked: boolean;
}

export default class ToggleButton extends React.Component<IProps, IState> {
  labelChecked: string;

  labelUnChecked: string;

  constructor(props: IProps) {
    super(props);

    this.state = {
      isChecked: true,
    };
    this.labelChecked = props.labelChecked;
    this.labelUnChecked = props.labelUnChecked;
    this.parentsComponentTriggerFunction = props.triggerFunction;
  }

  parentsComponentTriggerFunction: (state: boolean) => void;

  onToggleSwitchClicked = () => {
    const newState = !this.state.isChecked;
    this.parentsComponentTriggerFunction(newState);
    this.setState({
      isChecked: newState,
    });
  };
}
