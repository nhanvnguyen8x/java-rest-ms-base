package com.ms.rest.base.mapper;

import com.ms.rest.base.api.dto.model.ModelDto;
import com.ms.rest.base.domain.Model;
import com.ms.rest.base.domain.Node;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModelMapper {

    public List<ModelDto> toDtos(List<Model> models) {
        return models.stream().map(this::toDto).toList();
    }

    public ModelDto toDto(Model model) {
        ModelDto.ModelDtoBuilder builder = ModelDto.builder();
        builder.id(model.getId())
                .name(model.getName())
                .hashWB(model.getHashWB());

        Node node = model.getNode();
        if (node != null) {
            String nodeName = node.getName();
            builder.nodeName(nodeName);
        }

        return builder.build();
    }

    public Model toModel(ModelDto modelDto) {
        return Model.builder()
                .id(modelDto.getId())
                .name(modelDto.getName())
                .hashWB(modelDto.getHashWB())
                .build();
    }




}
