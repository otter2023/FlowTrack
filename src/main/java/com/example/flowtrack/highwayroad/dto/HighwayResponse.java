package com.example.flowtrack.highwayroad.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HighwayResponse {
    private int count;
    private String code;
    private String message;
    private List<HighwayInfoDto> list;
}
