import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import axios from 'axios';
import WelcomePage from './pages/main/WelcomePage';
import DashBoard from './pages/main/DashBoard';
import Login from './pages/main/Login';
import Register from './pages/main/Register';
import Project from './pages/project/Project';
import ProjectMake from './pages/project/ProjectMake';
import Sprint from './pages/sprint/Sprint';
import SprintMake from './pages/sprint/SprintMake';
import Task from './pages/project/Task';
import Members from './pages/member/MemberPage';
import Graph from './pages/graph/Graph';

axios.defaults.baseURL = process.env.REACT_APP_BASE_URL;
axios.defaults.withCredentials = true;
function App() {
  return (
    <BrowserRouter>
      <Routes>
        {/** 메인 페이지 및 로그인 페이지 */}
        <Route path='/' element={<WelcomePage />} />
        <Route path='/DashBoard' element={<DashBoard />} />
        <Route path='/Login' element={<Login />} />
        <Route path='/Register' element={<Register />} />
        {/** 프로젝트 페이지 */}
        <Route path='/Project' element={<Project />} />
        <Route path='/ProjectMake' element={<ProjectMake />} />
        {/** 스프린트 페이지 */}
        <Route path='/Sprint' element={<Sprint />} />
        <Route path='/SprintMake' element={<SprintMake />} />
        <Route path='/Task' element={<Task />} />
        {/** 멤버 페이지 */}
        <Route path='/Members' element={<Members />} />
        {/** 성과분석 결과 페이지 */}
        <Route path='/Graph' element={<Graph />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
