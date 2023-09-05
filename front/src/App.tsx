import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import axios from "axios";
import { UserProvider } from "./components/frames/token/UserContext";
import WelcomePage from "./pages/main/WelcomePage";
import TeamList from "./pages/main/TeamList";
import DashBoard from "./pages/main/DashBoard";
import Login from "./pages/main/Login";
import Project from "./pages/project/Project";
import Sprint from "./pages/sprint/Sprint";
import Task from "./pages/task/Task";
import Members from "./pages/member/MemberPage";
import Graph from "./pages/graph/Graph";
import Agora from "./pages/agora/Agora";
import Question from "./pages/agora/Question";
import Question1 from "./pages/agora/Question1";
import Question2 from "./pages/agora/Question2";
import ChangeNickname from "./pages/main/ChangeNickname";

axios.defaults.baseURL = process.env.REACT_APP_BASE_URL;
axios.defaults.withCredentials = true;

function App() {
  return (
    <BrowserRouter>
      <UserProvider>
        <Routes>
          <Route path='/Login' element={<Login />} />
          <Route path='/TeamList' element={<TeamList />} />
          <Route path='/DashBoard' element={<DashBoard />} />
          <Route path='/Project' element={<Project />} />
          <Route path='/Sprint' element={<Sprint />} />
          <Route path='/Task' element={<Task />} />
          <Route path='/Members' element={<Members />} />
          <Route path='/Graph' element={<Graph />} />
          <Route path='/Agora' element={<Agora />} />
          <Route path='/Question' element={<Question />} />
          <Route path='/Question1' element={<Question1 />} />
          <Route path='/Question2' element={<Question2 />} />
          <Route path='/ChangeNickname' element={<ChangeNickname />} />
          <Route path='/' element={<WelcomePage />} />
        </Routes>
      </UserProvider>
    </BrowserRouter>
  );
}

export default App;
