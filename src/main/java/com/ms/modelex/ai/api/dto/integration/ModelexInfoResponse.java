package com.ms.modelex.ai.api.dto.integration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ms.modelex.ai.api.dto.DataBlockDto;
import com.ms.modelex.ai.api.dto.model.ModelDto;
import lombok.Data;

import java.util.List;

@Data
public class ModelexInfoResponse {
    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "public_key")
    private String publicKey;

    @JsonProperty(value = "ethereum_address")
    private String ethereumAddress;

    @JsonProperty(value = "p2pPort")
    private String p2pPort;

    @JsonProperty(value = "rpcPort")
    private String rpcPort;

    @JsonProperty(value = "registered")
    private Boolean registered;

    @JsonProperty(value = "models")
    private List<ModelDto> models;

    @JsonProperty(value = "data_blocks")
    private List<DataBlockDto> dataBlocks;
}
