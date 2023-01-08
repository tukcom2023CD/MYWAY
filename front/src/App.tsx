import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Main from './pages/main/MainPage';
import ProjectMain from './pages/project/ProjectMain';
import SprintMain from './pages/sprint/SprintMain';
import TaskMain from './pages/task/TaskMain';
import TicketMain from './pages/ticket/TicketMain';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<Main />} />
        <Route path='/ProjectMain' element={<ProjectMain />} />
        <Route path='/SprintMain' element={<SprintMain />} />
        <Route path='/TaskMain' element={<TaskMain />} />
        <Route path='/TicketMain' element={<TicketMain />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
