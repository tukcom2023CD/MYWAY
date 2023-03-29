import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import axios from 'axios';
import WelcomePage from './pages/main/WelcomePage';
import TeamList from './pages/main/TeamList';
import DashBoard from './pages/main/DashBoard';
import Login from './pages/main/Login';
import Project from './pages/project/Project';
import ProjectMake from './pages/project/ProjectMake';
import Sprint from './pages/sprint/Sprint';
import SprintMake from './pages/sprint/SprintMake';
import Task from './pages/task/Task';
import TaskMake from './pages/task/TaskMake';
import Members from './pages/member/MemberPage';
import Graph from './pages/graph/Graph';
import Agora from './pages/agora/Agora';
import AgoraMake from './pages/agora/AgoraMake';
import Analysis from './pages/anaylsis/Analysis';

axios.defaults.baseURL = process.env.REACT_APP_BASE_URL;
axios.defaults.withCredentials = true;
function App() {
  return (
    <BrowserRouter>
      <Routes>
        {/** 메인 페이지 및 로그인 페이지 */}
        <Route path='/' element={<WelcomePage />} />
        <Route path='/TeamList' element={<TeamList />} />
        <Route path='/DashBoard' element={<DashBoard />} />
        <Route path='/Login' element={<Login />} />
        {/** 프로젝트 페이지 */}
        <Route path='/Project' element={<Project />} />
        <Route path='/ProjectMake' element={<ProjectMake />} />
        {/** 스프린트 페이지 */}
        <Route path='/Sprint' element={<Sprint />} />
        <Route path='/SprintMake' element={<SprintMake />} />
        {/** 테스크 페이지 */}
        <Route path='/Task' element={<Task />} />
        <Route path='/TaskMake' element={<TaskMake />} />
        {/** 멤버 페이지 */}
        <Route path='/Members' element={<Members />} />
        {/** 성과분석 결과 페이지 */}
        <Route path='/Graph' element={<Graph />} />
        {/** 아고래 페이지 */}
        <Route path='/Agora' element={<Agora />} />
        <Route path='/AgoraMake' element={<AgoraMake />} />
        {/** 분석 페이지 */}
        <Route path='/Analysis' element={<Analysis />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
