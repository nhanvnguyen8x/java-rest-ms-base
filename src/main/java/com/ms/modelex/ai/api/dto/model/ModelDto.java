package com.ms.modelex.ai.api.dto.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ModelDto {
    private Long id;
    private String name;
    private String hashWB;
    private String nodeName;
}
