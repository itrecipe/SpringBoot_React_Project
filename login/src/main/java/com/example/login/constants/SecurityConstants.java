package com.example.login.constants;

//Security 및 JWT 관련 상수를 관리하고 있는 클래스
/*
    - HTTP
        headers : {
            Authorization : Bearer ${jwt}
        }
 */
//해당 클래스를 final로 선언해 상속을 방지하고, 상수만을 정의하도록 만든다.
public final class SecurityConstants {

    //JWT 토큰을 담아줄 HTTP 요청 헤더명
    public static final String TOKEN_HEADER = "Authorization";

    //JWT 토큰의 접두사. 일반적으로 "Bearer " 다음에 실제 토큰이 온다. (헤더의 접두사)
    public static final String TOKEN_PREFIX = "Bearer "; //""안에 토큰앞에 넣을 접두사를 작성한다.

    //사용중인 JWT 토큰의 타입을 나타내는 상수
    public static final String TOKEN_TYPE = "JWT";

}
