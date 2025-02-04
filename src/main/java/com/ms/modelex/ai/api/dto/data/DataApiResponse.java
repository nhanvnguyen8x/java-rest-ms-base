package com.ms.modelex.ai.api.dto.data;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DataApiResponse {
    private Object data;

    private final Integer page = 1;
    private final Integer pageCount = 2;
    private final String sortField = null;
    private final String sortOrder = null;
    private final Integer totalCount = 10;
}
