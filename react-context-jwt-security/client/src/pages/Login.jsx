import React from 'react'
import Header from '../components/header/Header.jsx'
import LoginForm from '../components/Login/LoginForm.jsx'

const Login = () => {
  return (
    <>
    <Header />
    <div className="container">
        {/* 기존에 작성한 코드
        <h1>Login</h1>
        <hr />
        <h2>로그인 페이지</h2>
        <LoginContextConsumer /> */}
        <LoginForm />
    </div>
</>
  )
}
export default Login
