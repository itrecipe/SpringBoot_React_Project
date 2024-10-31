import React, { useContext } from 'react'
import { LoginContext } from './LoginContextProvider'

const LoginContextConsumer = () => {
    //로그인 여부에 대해 가져오고 싶을때 useContext 훅으로 내가 사용중인 LoginContext를 가져온다.  
    const { isLogin } = useContext(LoginContext) 
  return (
    <div>
        <h3>로그인 여부 : { isLogin ? '로그인' : '로그아웃'}</h3> {/* 이것에 따른 조건부 렌더링을 여기서 한다. */}
    </div>
  )
}

export default LoginContextConsumer
