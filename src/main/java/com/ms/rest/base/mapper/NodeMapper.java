package com.ms.rest.base.mapper;

import com.ms.rest.base.api.dto.model.ModelDto;
import com.ms.rest.base.api.dto.node.NodeDto;
import com.ms.rest.base.domain.Model;
import com.ms.rest.base.domain.Node;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class NodeMapper {

    private final ModelMapper modelMapper;

    public List<NodeDto> toDtos(List<Node> nodes) {
        return nodes.stream().map(this::toDto).toList();
    }

    public NodeDto toDto(Node node) {
        NodeDto.NodeDtoBuilder nodeDtoBuilder = NodeDto.builder();
        nodeDtoBuilder
                .id(node.getId())
                .name(node.getName())
                .fqdn(node.getFqdn())
                .ethereumAddress(node.getEthereumAddress())
                .publicKey(node.getPublicKey())
                .p2pPort(node.getP2pPort())
                .rpcPort(node.getRpcPort())
                .registered(node.getRegistered())
                .build();

        List<Model> models = node.getModels();
        if (models != null && !models.isEmpty()) {
            List<ModelDto> modelDtos = modelMapper.toDtos(models);
            nodeDtoBuilder.models(modelDtos);
        }

        return nodeDtoBuilder.build();
    }
}
