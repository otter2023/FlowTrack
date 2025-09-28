package com.example.flowtrack.seoulArea.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AreaResponse {

    @JacksonXmlProperty(localName = "list_total_count")
    private String listTotalCount;

    @JacksonXmlProperty(localName = "RESULT")
    private Result result;

    @JacksonXmlProperty(localName = "CITYDATA")
    private CityData cityData;

    @Getter @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result {
        @JacksonXmlProperty(localName = "RESULT.CODE")
        private String code;

        @JacksonXmlProperty(localName = "RESULT.MESSAGE")
        private String message;
    }

    @Getter @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CityData {
        @JacksonXmlProperty(localName = "AREA_NM")
        private String areaNm;

        @JacksonXmlProperty(localName = "AREA_CD")
        private String areaCd;

        @JacksonXmlProperty(localName = "LIVE_PPLTN_STTS")
        private LivePopulationStatus livePopulationStatus;

        @JacksonXmlProperty(localName = "LIVE_CMRCL_STTS")
        private LiveCommercialStatus liveCommercialStatus;

        // 통합 변환 메서드
        public AreaDto toAreaDto() {
            AreaDto dto = new AreaDto();

            // 기본 정보
            dto.setAreaNm(this.areaNm);
            dto.setAreaCd(this.areaCd);
            dto.setLivePpltnStts("");

            // 인구 데이터
            if (this.livePopulationStatus != null &&
                    this.livePopulationStatus.getLivePopulationData() != null) {
                LivePopulationData popData = this.livePopulationStatus.getLivePopulationData();

                dto.setAreaCongestLvl(popData.getAreaCongestLvl());
                dto.setAreaPpltnMin(popData.getAreaPpltnMin());
                dto.setAreaPpltnMax(popData.getAreaPpltnMax());
                dto.setMalePpltnRate(popData.getMalePpltnRate());
                dto.setFemalePpltnRate(popData.getFemalePpltnRate());
                dto.setPpltnRate0(popData.getPpltnRate0());
                dto.setPpltnRate10(popData.getPpltnRate10());
                dto.setPpltnRate20(popData.getPpltnRate20());
                dto.setPpltnRate30(popData.getPpltnRate30());
                dto.setPpltnRate40(popData.getPpltnRate40());
                dto.setPpltnRate50(popData.getPpltnRate50());
                dto.setPpltnRate60(popData.getPpltnRate60());
                dto.setPpltnRate70(popData.getPpltnRate70());
                dto.setResntPpltnRate(popData.getResntPpltnRate());
                dto.setNonResntPpltnRate(popData.getNonResntPpltnRate());
                dto.setPpltnTime(popData.getPpltnTime());
                dto.setFcstYn(popData.getFcstYn());
                dto.setFcstTime(popData.getFcstTime());
                dto.setFcstCongestLvl(popData.getFcstCongestLvl());
            }

            if (this.liveCommercialStatus != null) {
                dto.setAreaCmrclLvl(this.liveCommercialStatus.getAreaCmrclLvl());
                dto.setAreaShPaymentCnt(this.liveCommercialStatus.getAreaShPaymentCnt());
                dto.setCmrclMaleRate(this.liveCommercialStatus.getCmrclMaleRate());
                dto.setCmrclFemaleRate(this.liveCommercialStatus.getCmrclFemaleRate());
                dto.setCmrcl10Rate(this.liveCommercialStatus.getCmrcl10Rate());
                dto.setCmrcl20Rate(this.liveCommercialStatus.getCmrcl20Rate());
                dto.setCmrcl30Rate(this.liveCommercialStatus.getCmrcl30Rate());
                dto.setCmrcl40Rate(this.liveCommercialStatus.getCmrcl40Rate());
                dto.setCmrcl50Rate(this.liveCommercialStatus.getCmrcl50Rate());
                dto.setCmrcl60Rate(this.liveCommercialStatus.getCmrcl60Rate());
                dto.setCmrclTime(this.liveCommercialStatus.getCmrclTime());
            } else {
                // 상권 데이터가 없는 경우 빈 값
                dto.setAreaCmrclLvl("");
                dto.setAreaShPaymentCnt("");
                dto.setCmrclMaleRate("");
                dto.setCmrclFemaleRate("");
                dto.setCmrcl10Rate("");
                dto.setCmrcl20Rate("");
                dto.setCmrcl30Rate("");
                dto.setCmrcl40Rate("");
                dto.setCmrcl50Rate("");
                dto.setCmrcl60Rate("");
                dto.setCmrclTime("");
            }

            return dto;
        }
    }

    @Getter @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LivePopulationStatus {
        @JacksonXmlProperty(localName = "LIVE_PPLTN_STTS")
        private LivePopulationData livePopulationData;
    }

    @Getter @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LiveCommercialStatus {
        @JacksonXmlProperty(localName = "AREA_CMRCL_LVL")
        private String areaCmrclLvl;

        @JacksonXmlProperty(localName = "AREA_SH_PAYMENT_CNT")
        private String areaShPaymentCnt;

        @JacksonXmlProperty(localName = "AREA_SH_PAYMENT_AMT_MIN")
        private String areaShPaymentAmtMin;

        @JacksonXmlProperty(localName = "AREA_SH_PAYMENT_AMT_MAX")
        private String areaShPaymentAmtMax;

        @JacksonXmlProperty(localName = "CMRCL_MALE_RATE")
        private String cmrclMaleRate;

        @JacksonXmlProperty(localName = "CMRCL_FEMALE_RATE")
        private String cmrclFemaleRate;

        @JacksonXmlProperty(localName = "CMRCL_10_RATE")
        private String cmrcl10Rate;

        @JacksonXmlProperty(localName = "CMRCL_20_RATE")
        private String cmrcl20Rate;

        @JacksonXmlProperty(localName = "CMRCL_30_RATE")
        private String cmrcl30Rate;

        @JacksonXmlProperty(localName = "CMRCL_40_RATE")
        private String cmrcl40Rate;

        @JacksonXmlProperty(localName = "CMRCL_50_RATE")
        private String cmrcl50Rate;

        @JacksonXmlProperty(localName = "CMRCL_60_RATE")
        private String cmrcl60Rate;

        @JacksonXmlProperty(localName = "CMRCL_TIME")
        private String cmrclTime;
    }

    @Getter @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LivePopulationData {
        @JacksonXmlProperty(localName = "AREA_NM")
        private String areaNm;

        @JacksonXmlProperty(localName = "AREA_CD")
        private String areaCd;

        @JacksonXmlProperty(localName = "AREA_CONGEST_LVL")
        private String areaCongestLvl;

        @JacksonXmlProperty(localName = "AREA_PPLTN_MIN")
        private String areaPpltnMin;

        @JacksonXmlProperty(localName = "AREA_PPLTN_MAX")
        private String areaPpltnMax;

        @JacksonXmlProperty(localName = "MALE_PPLTN_RATE")
        private String malePpltnRate;

        @JacksonXmlProperty(localName = "FEMALE_PPLTN_RATE")
        private String femalePpltnRate;

        @JacksonXmlProperty(localName = "PPLTN_RATE_0")
        private String ppltnRate0;

        @JacksonXmlProperty(localName = "PPLTN_RATE_10")
        private String ppltnRate10;

        @JacksonXmlProperty(localName = "PPLTN_RATE_20")
        private String ppltnRate20;

        @JacksonXmlProperty(localName = "PPLTN_RATE_30")
        private String ppltnRate30;

        @JacksonXmlProperty(localName = "PPLTN_RATE_40")
        private String ppltnRate40;

        @JacksonXmlProperty(localName = "PPLTN_RATE_50")
        private String ppltnRate50;

        @JacksonXmlProperty(localName = "PPLTN_RATE_60")
        private String ppltnRate60;

        @JacksonXmlProperty(localName = "PPLTN_RATE_70")
        private String ppltnRate70;

        @JacksonXmlProperty(localName = "RESNT_PPLTN_RATE")
        private String resntPpltnRate;

        @JacksonXmlProperty(localName = "NON_RESNT_PPLTN_RATE")
        private String nonResntPpltnRate;

        @JacksonXmlProperty(localName = "PPLTN_TIME")
        private String ppltnTime;

        @JacksonXmlProperty(localName = "FCST_YN")
        private String fcstYn;

        @JacksonXmlProperty(localName = "FCST_TIME")
        private String fcstTime;

        @JacksonXmlProperty(localName = "FCST_CONGEST_LVL")
        private String fcstCongestLvl;
    }
}