package com.example.flowtrack.seoulroad.controller;

import com.example.flowtrack.seoulroad.service.RoadFileProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/traffic")
@RequiredArgsConstructor
public class RoadController {

    private final RoadFileProcessor roadFileProcessor;

    @GetMapping()
    public String exportTraffic() throws Exception {
        // 저장만 하고 결과는 리턴하지 않음
        roadFileProcessor.processExcel("linkIdInfo_2503.xlsx");
        return "CSV 저장 완료";
    }
}