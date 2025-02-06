package com.ms.rest.base.api.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiResponse {
    private Object data;

}
