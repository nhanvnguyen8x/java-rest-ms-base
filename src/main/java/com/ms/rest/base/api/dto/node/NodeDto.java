package com.ms.rest.base.api.dto.node;

import com.ms.rest.base.api.dto.model.ModelDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class NodeDto {
    private Long id;
    private String name;
    private String fqdn;
    private String publicKey;
    private String ethereumAddress;
    private String p2pPort;
    private String rpcPort;
    private Boolean registered;

    private List<ModelDto> models;
}
