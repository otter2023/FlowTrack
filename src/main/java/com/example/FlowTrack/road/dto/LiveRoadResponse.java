package com.example.FlowTrack.road.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor
@JacksonXmlRootElement(localName = "TrafficInfo") // XML 루트 요소 <TrafficInfo>를 다룸
@JsonIgnoreProperties(ignoreUnknown = true) // 정의되지 않은 필드는 무시 (API 구조 변경에 유리)
public class LiveRoadResponse {

    @JacksonXmlProperty(localName = "list_total_count")
    private Integer listTotalCount;

    @JacksonXmlProperty(localName = "RESULT")
    private Result result;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "row")
    private List<Row> rows;

    @Getter @Setter @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result {
        @JacksonXmlProperty(localName = "CODE")
        private String code;
        @JacksonXmlProperty(localName = "MESSAGE")
        private String message;
    }

    @Getter @Setter @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Row {
        @JacksonXmlProperty(localName = "link_id")
        private String linkId;

        @JacksonXmlProperty(localName = "prcs_spd")
        private Double prcsSpd;

        @JacksonXmlProperty(localName = "prcs_trv_time")
        private Integer prcsTrvTime;
    }
}