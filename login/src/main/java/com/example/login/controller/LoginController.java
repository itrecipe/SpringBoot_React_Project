package com.example.login.controller;

import com.example.login.constants.SecurityConstants;
import com.example.login.domain.AuthenticationRequest;
import com.example.login.prop.JwtProp;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
public class LoginController {

    @Autowired //의존성 주입
    private JwtProp jwtProp;

    // - Login : username, password
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();

        log.info("username : " + username);
        log.info("password : " + password);

        //사용자 권한
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_USER");
        roles.add("ROLE_ADMIN");

        //시크릿키 -> 바이트
        byte[] signingKey = jwtProp.getSecretKey().getBytes(); //시그니처에 쓸때에는 byte로 꺼내준다.

        //토큰 생성 (JWT 구조 : 헤더 -> 페이로드 -> 시그니처)
        String jwt = Jwts.builder() //토큰은 해당 메소드를 호출하여 하나씩 생성할 수 있다.
                //.signWith( 시크릿키, 알고리즘)
                .signWith(Keys.hmacShaKeyFor(signingKey), Jwts.SIG.HS512) //시그니처에 사용할 비밀키와 알고리즘 설정을 한다.
                .header() //헤더 설정
                    .add("typ", SecurityConstants.TOKEN_TYPE) //typ : JWT
                .and()
                //.expiration : 만료일 설정
                //1000*60*60*24*5 : 1초,1분,1시간,24시간,5일
                //System.currentTimeMillis() : 현재 시간을 구해주는 Date 객체
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 5)) //토큰 만료 시간 설정 (5일)
                .claim("uid", username) // 클래임을 이용하여 payload - uid : user (사용자 아이디)를 보내주고,
                .claim("rol", roles) // 여기서도 클레임을 이용하여 payload - rol : [ROLE_USER, ROLE_ADMIN] (권한 정보) 를 넘겨준다.
                .compact(); //최종적으로 토큰을 생성

        log.info("jwt : " + jwt);

        //생성된 토큰을 클라이언트에게 반환한다.
        return new ResponseEntity<String>(jwt, HttpStatus.OK); //JWT 응답
    }

    //토큰 해석
    @GetMapping("/user/info")
    public ResponseEntity<?> userInfo(@RequestHeader(name="Authorization") String header) {

        log.info("==== header ====");
        log.info("Authorization : " + header);

        /* 69행의 Authorization에서 넘어 오는 실제 값은 Bearer인데 JWT 토큰은 아니기 때문에 걷어내야 한다.
           Authorization : Bearer ${jwt}
         */

        //베어러를 걷어내기 위해 빈 문자열로 변경해주고 SecurityConstants.TOKEN_PREFIX를 사용해야 토큰만 받아 올 수 있다.
        String jwt = header.replace(SecurityConstants.TOKEN_PREFIX, "");

        byte[] signingKey =  jwtProp.getSecretKey().getBytes();

        //토큰 해석 (파서를 통해 토큰을 해석한다.)
        Jws<Claims> parsedToKen = Jwts.parser()
                                .verifyWith( Keys.hmacShaKeyFor(signingKey))  //verifyWith 메소드로 암호화할때 쓰던 시크릿키를 지정한다.
                                .build()
                                .parseSignedClaims(jwt); //parse : 파싱은 하나의 형태에서 다른 형태로 변환하는 것을 말한다.
                                                        //SignedClaims : 암호화 된 것을 말함. (즉, 사람이 인식할 수 있는 문자열로 다시 변환해주는것 : decoding 작업)
                                                        //(jwt) : 이 부분에 토큰을 넣어주면 되고, 하나씩 필요한 정보를 꺼내다 쓸 수 있다.
        log.info("parsedToken : " + parsedToKen);
        log.info(jwt);

        //uid : user
        String username = parsedToKen.getPayload().get("uid").toString();
        log.info("username : " + username);

        // rol : [ROLE_USER, ROLE_ADMIN] 권한
        Claims claims = parsedToKen.getPayload();
        Object roles = claims.get("rol");
        log.info("roles : " + roles);

        return new ResponseEntity<String>(parsedToKen.toString(), HttpStatus.OK);
    }
}