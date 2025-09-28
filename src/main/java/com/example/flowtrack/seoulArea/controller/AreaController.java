package com.example.flowtrack.seoulArea.controller;

import com.example.flowtrack.seoulArea.service.AreaDataProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/seoul-area")
public class AreaController {

    private final AreaDataProcessor areaDataProcessor;

    @GetMapping()
    public String exportTraffic() throws Exception {
        areaDataProcessor.processExcel("seoul_area_list_120_2505.xlsx");
        return "CSV 저장 완료";
    }
}
