import React from "react"
import Header from "../components/header/Header.jsx"
import LoginContextConsumer from "../contexts/LoginContextConsumer.jsx"

 const About = () => {
    return (
    <>
        <Header />
        <div className="container">
            <h1>About</h1>
            <hr />
            <h2>소개 페이지</h2>
            <LoginContextConsumer />
        </div>
    </>
    )
}
export default About