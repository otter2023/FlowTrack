package com.example.flowtrack.seoulroad.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * RoadMetaDto + LiveRoadDto.Row 를 합쳐서 사용하는 최종 DTO
 */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoadInfoDto {
    private String linkId;
    private String roadName;
    private String stNodeNm;
    private String edNodeNm;
    private String mapDist;
    private String regCd;
    private Double speed;       // prcs_spd
    private Integer travelTime; // prcs_trv_time
}
