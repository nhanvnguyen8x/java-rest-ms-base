package com.ms.modelex.ai.api.dto.integration;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ModelexModelDto {
    private Long id;
    private String name;
    private String hashWB;
}
