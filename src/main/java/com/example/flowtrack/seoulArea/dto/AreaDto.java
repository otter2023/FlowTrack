package com.example.flowtrack.seoulArea.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 서울시 실시간 도시데이터 API - 인구 현황 및 신한카드 결제 데이터 DTO
 */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AreaDto {

    // 기본 지역 정보
    @JacksonXmlProperty(localName = "AREA_NM")
    private String areaNm;              // 핫스팟 장소명

    @JacksonXmlProperty(localName = "AREA_CD")
    private String areaCd;              // 핫스팟 코드명

    // 실시간 인구 현황
    @JacksonXmlProperty(localName = "LIVE_PPLTN_STTS")
    private String livePpltnStts;       // 실시간 인구현황

    @JacksonXmlProperty(localName = "AREA_CONGEST_LVL")
    private String areaCongestLvl;      // 장소 혼잡도 지표

    @JacksonXmlProperty(localName = "AREA_PPLTN_MIN")
    private String areaPpltnMin;        // 실시간 인구 지표 최소값

    @JacksonXmlProperty(localName = "AREA_PPLTN_MAX")
    private String areaPpltnMax;        // 실시간 인구 지표 최대값

    // 성별/연령별 인구 비율
    @JacksonXmlProperty(localName = "MALE_PPLTN_RATE")
    private String malePpltnRate;       // 남성 인구 비율

    @JacksonXmlProperty(localName = "FEMALE_PPLTN_RATE")
    private String femalePpltnRate;     // 여성 인구 비율

    @JacksonXmlProperty(localName = "PPLTN_RATE_0")
    private String ppltnRate0;          // 0~10세 인구 비율

    @JacksonXmlProperty(localName = "PPLTN_RATE_10")
    private String ppltnRate10;         // 10대 실시간 인구 비율

    @JacksonXmlProperty(localName = "PPLTN_RATE_20")
    private String ppltnRate20;         // 20대 실시간 인구 비율

    @JacksonXmlProperty(localName = "PPLTN_RATE_30")
    private String ppltnRate30;         // 30대 실시간 인구 비율

    @JacksonXmlProperty(localName = "PPLTN_RATE_40")
    private String ppltnRate40;         // 40대 실시간 인구 비율

    @JacksonXmlProperty(localName = "PPLTN_RATE_50")
    private String ppltnRate50;         // 50대 실시간 인구 비율

    @JacksonXmlProperty(localName = "PPLTN_RATE_60")
    private String ppltnRate60;         // 60대 실시간 인구 비율

    @JacksonXmlProperty(localName = "PPLTN_RATE_70")
    private String ppltnRate70;         // 70대 실시간 인구 비율

    // 상주/비상주 인구 비율
    @JacksonXmlProperty(localName = "RESNT_PPLTN_RATE")
    private String resntPpltnRate;      // 상주 인구 비율

    @JacksonXmlProperty(localName = "NON_RESNT_PPLTN_RATE")
    private String nonResntPpltnRate;   // 비상주 인구 비율

    // 인구 예측 데이터
    @JacksonXmlProperty(localName = "FCST_YN")
    private String fcstYn;              // 예측값 제공 여부

    @JacksonXmlProperty(localName = "FCST_PPLTN")
    private String fcstPpltn;           // 인구 예측값

    @JacksonXmlProperty(localName = "FCST_TIME")
    private String fcstTime;            // 인구 예측시점

    @JacksonXmlProperty(localName = "FCST_CONGEST_LVL")
    private String fcstCongestLvl;      // 장소 예측 혼잡도 지표

    // 실시간 상권 현황 (신한카드 결제 데이터)
    @JacksonXmlProperty(localName = "AREA_CMRCL_LVL")
    private String areaCmrclLvl;        // 장소 실시간 상권 현황

    @JacksonXmlProperty(localName = "AREA_SH_PAYMENT_CNT")
    private String areaShPaymentCnt;    // 장소 실시간 신한카드 결제 건수

    // 성별/연령별 소비 비율
    @JacksonXmlProperty(localName = "CMRCL_MALE_RATE")
    private String cmrclMaleRate;       // 남성 소비 비율

    @JacksonXmlProperty(localName = "CMRCL_FEMALE_RATE")
    private String cmrclFemaleRate;     // 여성 소비 비율

    @JacksonXmlProperty(localName = "CMRCL_10_RATE")
    private String cmrcl10Rate;         // 10대 이하 소비 비율

    @JacksonXmlProperty(localName = "CMRCL_20_RATE")
    private String cmrcl20Rate;         // 20대 소비 비율

    @JacksonXmlProperty(localName = "CMRCL_30_RATE")
    private String cmrcl30Rate;         // 30대 소비 비율

    @JacksonXmlProperty(localName = "CMRCL_40_RATE")
    private String cmrcl40Rate;         // 40대 소비 비율

    @JacksonXmlProperty(localName = "CMRCL_50_RATE")
    private String cmrcl50Rate;         // 50대 소비 비율

    @JacksonXmlProperty(localName = "CMRCL_60_RATE")
    private String cmrcl60Rate;         // 60대 이상 소비 비율

    // 업데이트 시간
    @JacksonXmlProperty(localName = "CMRCL_TIME")
    private String cmrclTime;           // 실시간 상권 현황 업데이트 시간

    // TODO : 안 불러와짐, 수정 필요
    @JacksonXmlProperty(localName = "PPLTN_TIME")
    private String ppltnTime;           // 실시간 인구 데이터 업데이트 시간
}