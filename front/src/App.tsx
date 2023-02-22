import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import axios from 'axios';
import Main from './pages/main/MainPage';
import Login from './pages/main/Login';
import Register from './pages/main/Register';
import Project from './pages/project/Project';
import DailyScrum from './pages/scrum/DailyScrum';
import Members from './pages/member/MemberPage';
import Graph from './pages/graph/Graph';

axios.defaults.baseURL = process.env.REACT_APP_BASE_URL;
axios.defaults.withCredentials = true;

function App() {
  return (
    <BrowserRouter>
      <Routes>
        {/** 메인 페이지 및 로그인 페이지 */}
        <Route path='/' element={<Main />} />
        <Route path='/Login' element={<Login />} />
        <Route path='/Register' element={<Register />} />
        {/** 프로젝트 페이지 */}
        <Route path='/Project' element={<Project />} />
        {/** 일정/스크럼 페이지 */}
        <Route path='/DailyScrum' element={<DailyScrum />} />
        {/** 멤버 페이지 */}
        <Route path='/Members' element={<Members />} />
        {/** 성과분석 결과 페이지 */}
        <Route path='/Graph' element={<Graph />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
