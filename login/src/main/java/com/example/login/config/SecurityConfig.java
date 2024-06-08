package com.example.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//SpringSecurity 5.4이하
/* 지금은 잘 안쓰는 예전 시큐리티 방식
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected  void configure(HttpSecurity http) throws Exception {

        super.configure(http);
    }
}
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    //SpringSecurity 5.5 이상에서 사용되는 방식
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { //기본으로 설정하는 메소드
        //폼 기반 로그인 비활성화
        http.formLogin( (login) -> login.disable() ); //람다식을 이용하여 비활성화 처리를 권고하여 해당방식으로 처리 하였다.

        //HTTP 기본 인증 비활성화
        http.httpBasic( (basic) -> basic.disable() );

        //CSRF 공격 방어 기능 비활성화
        http.csrf((csrf) -> csrf.disable());

        //세션 관리 정책 설정
        /* 세션 인증을 사용하지 않고, JWT를 사용하여 인증되기 때문에 세션은 필요 하지 않음
          예전에는 세션으로 id, pw 에 대한 로그인 정보를 서버가 들고 있었다 지금은 그럴
          필요가 없이 JWT로 토큰 인증방식을 사용할것이기 때문에 세션도 함께 비활성화 처리 한다.
        */
        http.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build(); //http 객체를 반환
    }
}