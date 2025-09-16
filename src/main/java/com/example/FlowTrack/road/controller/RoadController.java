package com.example.FlowTrack.road.controller;

import com.example.FlowTrack.road.service.RoadFileProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/traffic")
@RequiredArgsConstructor
public class RoadController {

    private final RoadFileProcessor roadFileProcessor;

    /**
     * 예: GET /api/traffic/export?excel=linkIdInfo_2503.xlsx
     */
    @GetMapping("/export")
    public String exportTraffic() throws Exception {
        // 저장만 하고 결과는 리턴하지 않음
        roadFileProcessor.processExcel("linkIdInfo_2503.xlsx");
        return "✅ CSV 저장 완료";
    }
}