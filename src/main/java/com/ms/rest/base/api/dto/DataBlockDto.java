package com.ms.rest.base.api.dto;

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
