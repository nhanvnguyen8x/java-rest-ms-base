package com.ms.modelex.ai.service;

import com.ms.modelex.ai.api.dto.model.ModelDto;
import com.ms.modelex.ai.domain.Model;
import com.ms.modelex.ai.domain.Node;
import com.ms.modelex.ai.exception.BadRequestException;
import com.ms.modelex.ai.mapper.ModelMapper;
import com.ms.modelex.ai.repository.ModelRepository;
import com.ms.modelex.ai.repository.NodeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class ModelService {
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;
    private final NodeRepository nodeRepository;

    public List<ModelDto> getModels() {
        List<Model> models = modelRepository.findAll();

        return modelMapper.toDtos(models);
    }

    public List<ModelDto> createModel(Long nodeId, List<ModelDto> modelDtos) {
        if (modelDtos.isEmpty()) {
            log.info("Modelex response Model is empty");
            return Collections.emptyList();
        }

        Node node = nodeRepository.findById(nodeId).orElseThrow(() -> new BadRequestException("Node is not found"));
        List<Model> existingModels = modelRepository.findByNode(node);
        if (existingModels.isEmpty()) {
            // Add new models
            log.info("Model of this Node is empty, create new model");
            List<Model> models = modelDtos.stream().map(modelDto -> {
                Model model = modelMapper.toModel(modelDto);
                model.setNode(node);
                return model;
            }).toList();

            List<Model> createdModels = modelRepository.saveAll(models);
            return modelMapper.toDtos(createdModels);
        }

        // Update model for this node
        log.info("Model of this Node is already exist, sync models");
        Map<String, ModelDto> modelDtoMap = toModelMap(modelDtos);
        existingModels.forEach(existingModel -> {
            String modelName = existingModel.getName();
            ModelDto modelDto = modelDtoMap.get(modelName);

            existingModel.setName(modelDto.getName());
            existingModel.setHashWB(modelDto.getHashWB());
            existingModel.setNode(node);
        });

        List<Model> updatedModels = modelRepository.saveAll(existingModels);
        return modelMapper.toDtos(updatedModels);
    }

    private Map<String, ModelDto> toModelMap(List<ModelDto> modelDtos) {
        return modelDtos.stream().collect(Collectors.toMap(ModelDto::getName, model -> model));

    }
}
