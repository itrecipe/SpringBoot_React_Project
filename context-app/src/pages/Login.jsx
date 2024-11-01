import React from 'react'
import Header from '../components/header/Header.jsx'
import LoginContextConsumer from '../contexts/LoginContextConsumer.jsx'

const Login = () => {
  return (
    <>
    <Header />
    <div className="container">
        <h1>Login</h1>
        <hr />
        <h2>로그인 페이지</h2>
        <LoginContextConsumer />
    </div>
</>
  )
}
export default Login
