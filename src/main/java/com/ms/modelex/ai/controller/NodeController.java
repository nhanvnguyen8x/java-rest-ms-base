package com.ms.modelex.ai.controller;

import com.ms.modelex.ai.api.dto.ApiResponse;
import com.ms.modelex.ai.api.dto.integration.ModelexInfoResponse;
import com.ms.modelex.ai.api.dto.model.ModelDto;
import com.ms.modelex.ai.api.dto.node.CreateNodeRequest;
import com.ms.modelex.ai.api.dto.node.NodeDto;
import com.ms.modelex.ai.domain.Node;
import com.ms.modelex.ai.exception.DownstreamBusinessException;
import com.ms.modelex.ai.integration.ModelexClient;
import com.ms.modelex.ai.service.ModelService;
import com.ms.modelex.ai.service.NodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/nodes")
public class NodeController {
    private final NodeService nodeService;
    private final ModelService modelService;
    private final ModelexClient modelexClient;

    @GetMapping
    public ResponseEntity<ApiResponse> getNodes() {
        List<NodeDto> nodeDtos = nodeService.getNodes();

        ApiResponse apiResponse = ApiResponse.builder()
                .data(nodeDtos).build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<NodeDto> createNode(@RequestBody CreateNodeRequest request) {
        log.info("Create node with FQDN: {}, RPC Port: {}", request.getFqdn(), request.getRpcPort());

        ModelexInfoResponse modelexInfoResponse = modelexClient.getInfo(request.getFqdn(), request.getRpcPort());
        String nodeName = modelexInfoResponse.getName();
        if (StringUtils.isBlank(nodeName)) {
            log.info("Get Info return empty Node name");
            throw new DownstreamBusinessException("Empty Node name");
        }

        log.info("Get Info successfully, Node name: {}", nodeName);

        NodeDto nodeDto = nodeService.createNode(request, modelexInfoResponse);
        Long nodeId = nodeDto.getId();
        log.info("Create node with ID: {}", nodeId);

        List<ModelDto> modelDtos = modelService.createModel(nodeId, modelexInfoResponse.getModels());
        nodeDto.setModels(modelDtos);

        return ResponseEntity.ok(nodeDto);
    }
}
