package com.ms.rest.base.api.dto.node;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateNodeRequest {
    @NotEmpty
    private String fqdn;

    @NotEmpty
    private String rpcPort;
}
