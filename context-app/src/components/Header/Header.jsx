import React from "react";
import { Link } from 'react-router-dom'
import './Header.css'

const Header = () => {
    return(
        <header>
            <div className="logo">
                <Link to="/">
                    <img src="https://i.imgur.com/fzADqJo.png" alt="logo" className="logo" />
                </Link>
            </div>

            <div className="util">
                {/* 비 로그인시 */}
                <ul>
                    <li><Link to="/login">로그인</Link></li>
                    <li><Link to="/join">회원가입</Link></li>
                    <li><Link to="/about">소개</Link></li>
                </ul>
                
                {/* 로그인시 */}
                <ul>
                    <li><Link to="/user">마이페이지</Link></li>
                    {/* 로그아웃은 따로 링크가 있는것이 아니기에 버튼으로 만들었음 */}
                    <li><button className="link">로그아웃</button></li>
                </ul>
            </div>
        </header>        
    )
}


export default Header