import React from "react";
import Header from "../components/header/Header.jsx";
import LoginContextConsumer from "../contexts/LoginContextConsumer.jsx";

const Home = () => {
    return (
        <>
            <Header />
            <div className="container">
                <h1>Home</h1>
                <hr />
                <h2>메인 페이지</h2>
                <LoginContextConsumer />
            </div>
        </>
    )
}
export default Home