package kh.edu.react.provider.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
// 리액트 3000 포트와 연결을 주고 받을 때 어디까지 react가 springboot 에서
// 제공되는 값을 사용할 수 있는가 에 대한 설정
// !!! controller 에서 @CrossOrigin 이랑 같이 사용불가. 특정 연결만 설정, 전역설정의 차이
// 함부러 정보를 주고 받을 수가 없다가 핵심.
@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // registry.addMapping("/**")  -> 3000 port 에서 요청하는 모든 url api 허용
                registry.addMapping("/api/**") // 3000 port 에서 /api/ 라는 주소 명칭으로 시작하는 url api 요청 허용
                       // .allowedOrigins("http://localhost:3000","http://localhost:3001") // react 서버 3000 ~ 3001 포트에서 SpringBoot 접속 허용
                        .allowedOrigins("http://localhost:3000") // react 서버 3000 포트에서 SpringBoot 접속 허용
                        .allowCredentials(true) // 3000에서 API 요청을 보낼 때 쿠키나 세션 정보를 포함해서 요청을 받게 해줄 수 있는가 기본값 false
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*"); // 데이터 형식 타입 현재 모든타입 설정
            }
        };
    }
}
