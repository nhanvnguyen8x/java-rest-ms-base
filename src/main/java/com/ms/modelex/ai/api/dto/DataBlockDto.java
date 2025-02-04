package com.ms.modelex.ai.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DataBlockDto {
    private String name;
    private String hashDB;
}
