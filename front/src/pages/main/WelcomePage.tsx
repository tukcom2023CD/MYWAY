import React from 'react';
import Header from '../../components/frames/Welcome/Header';
import WelcomeStart from '../../components/frames/Welcome/WelcomeStart';
import WelcomeProject from '../../components/frames/Welcome/WelcomeProject';
import WelcomeSprint from '../../components/frames/Welcome/WelcomeSprint';

function WelcomePage() {
  return (
    <div className='bg-gradient-to-r from-green-400 to-blue-500'>
      <Header />
      <WelcomeStart />
      <WelcomeProject />
      <WelcomeSprint />
    </div>
  );
}

export default WelcomePage;
