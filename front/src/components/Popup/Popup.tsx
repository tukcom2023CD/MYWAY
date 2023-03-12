/* eslint-disable jsx-a11y/click-events-have-key-events */
/* eslint-disable jsx-a11y/no-static-element-interactions */
import React, { useState, PropsWithChildren } from 'react';
import Team from './TeamPopup';

interface PopupDefaultType {
  onClickTogglePopup: () => void;
}

function TeamPopup({
  onClickTogglePopup,
}: PropsWithChildren<PopupDefaultType>) {
  const [isOpenPopup, setOpenPopup] = useState<boolean>(false);

  const closePopup = () => {
    setOpenPopup(!isOpenPopup);
  };
  return (
    <div>
      <div>
        <Team onClosePopup={closePopup} />
      </div>
      <div
        onClick={(e: React.MouseEvent) => {
          e.preventDefault();

          if (onClickTogglePopup) {
            onClickTogglePopup();
          }
        }}
      />
    </div>
  );
}

export default TeamPopup;
