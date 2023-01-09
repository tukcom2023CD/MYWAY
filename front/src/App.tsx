import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Main from './pages/main/MainPage';
import Login from './pages/main/Login';
import Register from './pages/main/Register';
import ProjectMain from './pages/project/ProjectMain';
import ProjectMake from './pages/project/ProjectMake';
import SprintMain from './pages/sprint/SprintMain';
import SprintMake from './pages/sprint/SprintMake';
import TaskMain from './pages/task/TaskMain';
import TaskMake from './pages/task/TaskMake';
import TicketMain from './pages/ticket/TicketMain';
import TicketMake from './pages/ticket/TicketMake';
import Daily from './pages/scrum/DailyPage';
import Scrum from './pages/scrum/ScrumPage';
import Result from './pages/graph/Result';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<Main />} />
        <Route path='/Login' element={<Login />} />
        <Route path='/Register' element={<Register />} />

        <Route path='/ProjectMain' element={<ProjectMain />} />
        <Route path='/ProjectMake' element={<ProjectMake />} />

        <Route path='/SprintMain' element={<SprintMain />} />
        <Route path='/SprintMake' element={<SprintMake />} />

        <Route path='/TaskMain' element={<TaskMain />} />
        <Route path='/TaskMake' element={<TaskMake />} />

        <Route path='/TicketMain' element={<TicketMain />} />
        <Route path='/TicketMake' element={<TicketMake />} />

        <Route path='/Daily' element={<Daily />} />
        <Route path='/Scrum' element={<Scrum />} />

        <Route path='/Result' element={<Result />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
