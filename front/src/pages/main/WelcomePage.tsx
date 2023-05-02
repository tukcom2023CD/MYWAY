import React from 'react';
import Header from '../../components/frames/Header/WelcomeHeader';
import WelcomeStart from '../../components/frames/Welcome/WelcomeStart';
import WelcomeProject from '../../components/frames/Welcome/WelcomeProject';
import WelcomeSprint from '../../components/frames/Welcome/WelcomeSprint';

function WelcomePage() {
  return (
    <div className='bg-gradient-to-r from-[#c3efc0] to-[#8ad3f0]'>
      <Header />
      <WelcomeStart />
      <WelcomeProject />
      <WelcomeSprint />
    </div>
  );
}

export default WelcomePage;
