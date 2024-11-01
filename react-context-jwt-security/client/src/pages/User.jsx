import React from 'react'
import Header from '../components/header/Header.jsx'
import LoginContextConsumer from '../contexts/LoginContextConsumer.jsx'

const User = () => {
    return (
        <>
        <Header />
        <div className="container">
            <h1>User</h1>
            <hr />
            <h2>마이 페이지</h2>
            <LoginContextConsumer />
        </div>
    </>
  )
}
export default User
