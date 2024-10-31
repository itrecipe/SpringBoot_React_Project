import React from "react";
import logo from "./logo.svg";
import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./pages/Home";
import Login from "./pages/Login";
import User from "./pages/User";
import About from "./pages/About";
import Join from "./pages/Join";
import LoginContextProvider from "./contexts/LoginContextProvider";

// 라우터로 페이지 설정하기
function App() {
  return (
    <BrowserRouter>
      <LoginContextProvider> {/* 전체적인 컴포넌트로 사용할때 이렇게 쓴다, 임포트 해줘야 한다. */}
        <Routes>
          <Route path="/" element={<Home />}></Route>
          <Route path="/login" element={<Login />}></Route>
          <Route path="/join" element={<Join />}></Route>
          <Route path="/user" element={<User />}></Route>
          <Route path="/about" element={<About />}></Route>
      </Routes>
      </LoginContextProvider>
    </BrowserRouter>
  );
}

export default App;
