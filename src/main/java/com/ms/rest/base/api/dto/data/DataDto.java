package com.ms.rest.base.api.dto.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DataDto {
    private Long id;
    private String ipAddress;
    private String label;
    private String lastSession;
    private String method;
    private String status;
}
