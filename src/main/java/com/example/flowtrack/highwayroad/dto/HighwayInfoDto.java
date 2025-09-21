package com.example.flowtrack.highwayroad.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HighwayInfoDto {
    private String routeName;
    private String routeNo;
    private String trafficAmout;
    private String conzoneId;
    private String conzoneName;
    private String stdDate;
    private String stdHour;
    private String vdsId;
    private String speed;
    private String shareRatio;
    private String timeAvg;
    private String grade;
    private String updownTypeCode;
}