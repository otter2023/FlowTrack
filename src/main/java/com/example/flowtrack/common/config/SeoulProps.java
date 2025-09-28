package com.example.flowtrack.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter @Setter
@Component // 해당 클래스 자체를 Bean으로 자동 등록
@ConfigurationProperties(prefix = "seoul") // application.yml의 road: 설정 블록을 매핑
public class SeoulProps {
    private String baseUrl;
    private String apiKey;
}
