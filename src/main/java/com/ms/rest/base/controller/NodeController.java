package com.ms.rest.base.controller;

import com.ms.rest.base.api.dto.ApiResponse;
import com.ms.rest.base.api.dto.node.NodeDto;
import com.ms.rest.base.service.NodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/nodes")
public class NodeController {
    private final NodeService nodeService;

    @GetMapping
    public ResponseEntity<ApiResponse> getNodes() {
        List<NodeDto> nodeDtos = nodeService.getNodes();

        ApiResponse apiResponse = ApiResponse.builder()
                .data(nodeDtos).build();
        return ResponseEntity.ok(apiResponse);
    }

}
