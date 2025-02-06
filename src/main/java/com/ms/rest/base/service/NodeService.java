package com.ms.rest.base.service;

import com.ms.rest.base.api.dto.node.NodeDto;
import com.ms.rest.base.domain.Node;
import com.ms.rest.base.mapper.NodeMapper;
import com.ms.rest.base.repository.NodeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class NodeService {
    private final NodeRepository nodeRepository;
    private final NodeMapper nodeMapper;

    public List<NodeDto> getNodes() {
        List<Node> nodes = nodeRepository.findAll();

        return nodeMapper.toDtos(nodes);
    }


}
