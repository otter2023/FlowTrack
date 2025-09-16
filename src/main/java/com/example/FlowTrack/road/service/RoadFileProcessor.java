package com.example.FlowTrack.road.service;

import com.example.FlowTrack.road.dto.RoadInfoDto;
import com.example.FlowTrack.road.ingest.ExcelReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoadFileProcessor {

    private final ExcelReader excelReader;
    private final RoadMultiThreadService roadMultiThreadService;
    private final RoadService roadService;

    /**
     * 엑셀에서 linkId 읽고 → TrafficService 호출 → 결과 리스트 반환
     */
    public List<RoadInfoDto> processExcel(String excelPath) throws Exception {
        List<String> linkIds = excelReader.readLinkIds("linkIdInfo_2503.xlsx");
        roadMultiThreadService.fetchAndSave(linkIds, "result.csv");

        List<RoadInfoDto> results = new ArrayList<>();

        for (String linkId : linkIds) {
            RoadInfoDto info = roadService.getRoadInfo(linkId);
            if (info != null) results.add(info);
            Thread.sleep(100);
        }
        return results;
    }
}
