import React, { useState } from 'react';
import Modal from 'react-modal';

function TeamPopup() {
  const [modalIsOpen, setIsOpen] = useState(false);

  function openModal() {
    setIsOpen(true);
  }

  function closeModal() {
    setIsOpen(false);
  }

  return (
    <div>
      <button type='button' onClick={openModal}>
        Open Modal
      </button>
      <Modal isOpen={modalIsOpen} contentLabel='Example Modal'>
        <button type='button' onClick={closeModal}>
          close
        </button>
        <div>I am a modal</div>
        <form>
          <input />
          <button type='button'>tab navigation</button>
          <button type='button'>stays</button>
          <button type='button'>inside</button>
          <button type='button'>the modal</button>
        </form>
      </Modal>
    </div>
  );
}

export default TeamPopup;
