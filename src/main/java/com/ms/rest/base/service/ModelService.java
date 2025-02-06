package com.ms.rest.base.service;

import com.ms.rest.base.api.dto.model.ModelDto;
import com.ms.rest.base.domain.Model;
import com.ms.rest.base.mapper.ModelMapper;
import com.ms.rest.base.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ModelService {
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public List<ModelDto> getModels() {
        List<Model> models = modelRepository.findAll();

        return modelMapper.toDtos(models);
    }

}
