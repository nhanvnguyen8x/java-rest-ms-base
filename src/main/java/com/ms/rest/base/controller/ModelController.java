package com.ms.rest.base.controller;

import com.ms.rest.base.api.dto.ApiResponse;
import com.ms.rest.base.api.dto.model.ModelDto;
import com.ms.rest.base.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/models")
public class ModelController {
    private final ModelService modelService;

    @GetMapping
    public ResponseEntity<ApiResponse> getModels() {
        List<ModelDto> modelDtos = modelService.getModels();

        ApiResponse apiResponse = ApiResponse.builder().data(modelDtos).build();
        return ResponseEntity.ok(apiResponse);
    }
}
