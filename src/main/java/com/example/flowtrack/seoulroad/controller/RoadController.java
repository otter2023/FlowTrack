package com.example.flowtrack.seoulroad.controller;

import com.example.flowtrack.seoulroad.service.RoadDataProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seoul-traffic")
@RequiredArgsConstructor
public class RoadController {

    private final RoadDataProcessor roadDataProcessor;

    @GetMapping()
    public String exportTraffic() throws Exception {
        roadDataProcessor.processExcel("link_id_info_2503.xlsx");
        return "CSV 저장 완료";
    }
}