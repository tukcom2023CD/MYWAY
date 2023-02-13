import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Main from './pages/main/MainPage';
import Login from './pages/main/Login';
import Register from './pages/main/Register';
import Project from './pages/project/Project';
import SprintMain from './pages/sprint/SprintMain';
import SprintMake from './pages/sprint/SprintMake';
import TaskMain from './pages/task/TaskMain';
import TaskMake from './pages/task/TaskMake';
import TicketMain from './pages/ticket/TicketMain';
import TicketMake from './pages/ticket/TicketMake';
import DailyScrum from './pages/scrum/DailyScrum';
import Result from './pages/graph/Result';
import IssueMain from './pages/issue/IssueMain';
import IssueMake from './pages/issue/IssueMake';
import IssueManage from './pages/issue/IssueManage';
import StatusMain from './pages/status/StatusMain';

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
        {/** 스프린트 생성 페이지 */}
        <Route path='/SprintMain' element={<SprintMain />} />
        <Route path='/SprintMake' element={<SprintMake />} />
        {/** 태스크 생성 페이지 */}
        <Route path='/TaskMain' element={<TaskMain />} />
        <Route path='/TaskMake' element={<TaskMake />} />
        {/** 티켓 생성 페이지 */}
        <Route path='/TicketMain' element={<TicketMain />} />
        <Route path='/TicketMake' element={<TicketMake />} />
        {/** 일정/스크럼 페이지 */}
        <Route path='/Daily' element={<DailyScrum />} />
        {/** 성과분석 결과 페이지 */}
        <Route path='/Result' element={<Result />} />
        {/** 이슈 페이지 */}
        <Route path='/IssueMain' element={<IssueMain />} />
        <Route path='/IssueMake' element={<IssueMake />} />
        <Route path='/IssueManage' element={<IssueManage />} />
        {/** 역량 페이지 */}
        <Route path='/StatusMain' element={<StatusMain />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
