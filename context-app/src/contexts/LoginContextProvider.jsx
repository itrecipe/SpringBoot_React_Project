//로그인 관련 작업, 리턴하는 컴포넌트로 생성
import React, { createContext, useEffect, useState } from 'react' //createContext 임포트하기

//context 정의
export const LoginContext = createContext();
LoginContext.displayName = 'LoginContextName'

//프로바이더로 내려줄 자식 요소들인 childeren도 여기 정의한다.
const LoginContextProvider = ({ children }) => {

  //context value : 로그인 여부, 로그아웃 함수
    const [isLogin, setLogin] = useState(false);

    const logout = () => {
        setLogin(false)
    }

    useEffect ( () => {
        // 3초 뒤 로그인
        setTimeout( () => {
            setLogin(true)
        }, 3000)
    }, [])

    return (
        <div>
            <LoginContext.Provider value={ {isLogin, logout} }>
                {children}
            </LoginContext.Provider>
        </div>
  )
}

export default LoginContextProvider
