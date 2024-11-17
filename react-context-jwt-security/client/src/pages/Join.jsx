import React from 'react'
import Header from '../components/header/Header.jsx'
import LoginContextConsumer from '../contexts/LoginContextConsumer.jsx'
import JoinForm from '../components/join/JoinForm.jsx'

 const Join = () => {
  return (
    <>
    <Header />
    <div className="container">
      <JoinForm />
    </div>
    </>
  )
}
export default Join