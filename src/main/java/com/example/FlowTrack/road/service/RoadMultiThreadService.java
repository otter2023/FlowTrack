package com.example.FlowTrack.road.service;

import com.example.FlowTrack.road.dto.RoadInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RoadMultiThreadService {

    private final RoadService roadService;

    public void fetchAndSave(List<String> linkIds, String outPath) throws Exception {
        int threads = 10; // 동시에 몇 개 스레드 돌릴지 (5~10 추천)
        ExecutorService executor = Executors.newFixedThreadPool(threads);

        // 직접 열고 닫기
        PrintWriter writer = new PrintWriter(new FileWriter(outPath, false));

        try {
            // 🔹 CSV 헤더 기록
            writer.println("link_id,road_name,st_node_nm,ed_node_nm,map_dist,reg_cd,speed,travel_time");
            writer.flush();

            // 🔹 각 linkId 작업을 스레드 풀에 제출
            for (String linkId : linkIds) {
                executor.submit(() -> {
                    try {
                        RoadInfoDto info = roadService.getRoadInfo(linkId);
                        if (info != null) {
                            // ✅ KST 시간 포맷

                            String line = String.join(",",
                                    nz(info.getLinkId()),
                                    nz(info.getRoadName()),
                                    nz(info.getStNodeNm()),
                                    nz(info.getEdNodeNm()),
                                    nz(info.getMapDist()),
                                    nz(info.getRegCd()),
                                    nz(info.getSpeed()),
                                    nz(info.getTravelTime())
                            );

                            synchronized (writer) { // 동시 쓰기 충돌 방지
                                writer.println(line);
                                writer.flush();
                            }
                        }
                    } catch (Exception e) {
                        System.err.println("Error fetching linkId=" + linkId + ": " + e.getMessage());
                    }
                });
            }
        } finally {
            executor.shutdown();
            // 🔹 모든 작업이 끝날 때까지 대기
            executor.awaitTermination(10, TimeUnit.MINUTES);
            writer.close(); // 🔹 작업 끝난 후에만 닫기
        }

        System.out.println("모든 데이터 저장 완료: " + outPath);
    }

    private String nz(Object o) {
        return (o == null) ? "" : o.toString().replace(",", " ");
    }
}
