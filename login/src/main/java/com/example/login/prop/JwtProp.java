package com.example.login.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//application.properties에 미리 정의해둔 secret key를 정의하는 클래스

@Data //private으로 선언한 필드 secretKey를 다른곳에서도 사용 가능하도록 @Date 어노테이션을 붙여 getter, setter을 붙여준다.
@Component //IoC(제어의역전) 컨테이너에 해당 클래스를 빈으로 등록해주는 어노테이션
@ConfigurationProperties("com.example.login") //com.example.login 경로 하위 속성들을 지정한다.
public class JwtProp {
    //com.example.login.secret-key -> secretKey : {인코딩한 secret Key}
    private String secretKey;
}
