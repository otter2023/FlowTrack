package com.example.FlowTrack.road.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration // 스프링 설정 클래스임을 나타냄, 싱글톤 보장
public class RestClientConfig {

    @Bean // @Configuration보고 Bean으로 등록
    public RestClient restClient() {
        return RestClient.create(); // 기본 세팅으로 생성, 커스터마이징 시 .builder() 사용
    }

    /**
     RestClient란?
     RestTemplate, WebClient와 비슷한 역할 (RestClient가 신버전)
     JAVA에서 외부 REST API를 사용할 때 사용
     */

}
