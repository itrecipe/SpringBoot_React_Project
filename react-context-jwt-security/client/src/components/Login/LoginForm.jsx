import React from 'react'
import './LoginForm.css'

//로그인 함수 임의로 정의

const LoginForm = () => {

    const onLogin = () => {

    }

  return (
        <div className="form">
            <h2 className="login-title">Login</h2>
            <form className='login-form' onSubmit={ (e) =>onLogin }>
                <div>
                    <label htmlFor="name">username</label>
                    <input type="text"
                           id='username'
                           placeholder='username'
                           name='username'
                           autoComplete='username'
                           required
                        // TODO : ID 저장 기능 구현 후 추가 예정
                        // FIXME : remeUserId를 넣자
                        // defaultValue={}
                    />
                </div>

                <div>
                    <label htmlFor="password"></label>
                    <input type="text" 
                           id='password'
                           placeholder='password'
                           name='password'
                           autoComplete='password'
                           required
                    />
                </div>

                <button className='btn btn-form btn-login'>
                    Login
                </button>
            </form>
        </div>
  )
}
export default LoginForm
