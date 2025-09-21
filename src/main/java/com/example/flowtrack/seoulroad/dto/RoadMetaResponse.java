package com.example.flowtrack.seoulroad.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@JacksonXmlRootElement(localName = "row")  // 최상단이 <row>
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoadMetaResponse {

    @JacksonXmlProperty(localName = "link_id")
    private String linkId;

    @JacksonXmlProperty(localName = "road_name")
    private String roadName;

    @JacksonXmlProperty(localName = "st_node_nm")
    private String stNodeNm;

    @JacksonXmlProperty(localName = "ed_node_nm")
    private String edNodeNm;

    @JacksonXmlProperty(localName = "map_dist")
    private String mapDist;

    @JacksonXmlProperty(localName = "reg_cd")
    private String regCd;

/**
 XML구조를 담기 위한 dto 클래스 (여기서는 XML -> JAVA 객체 -> JSON으로 변환할 떄 사용)
 */

}




