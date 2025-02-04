package com.ms.modelex.ai.service;

import com.ms.modelex.ai.api.dto.integration.ModelexInfoResponse;
import com.ms.modelex.ai.api.dto.node.CreateNodeRequest;
import com.ms.modelex.ai.api.dto.node.NodeDto;
import com.ms.modelex.ai.domain.Model;
import com.ms.modelex.ai.domain.Node;
import com.ms.modelex.ai.mapper.NodeMapper;
import com.ms.modelex.ai.repository.NodeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public NodeDto createNode(CreateNodeRequest request, ModelexInfoResponse modelexInfoResponse) {
        String nodeName = modelexInfoResponse.getName();
        String rpcPort = request.getRpcPort();
        String fqdn = request.getFqdn();
        Optional<Node> nodeOptional = nodeRepository.findByFqdnAndRpcPort(fqdn, rpcPort);
        if (nodeOptional.isEmpty()) {
            log.info("Not existing Node with name: {}, Create new Node", nodeName);
            Node newNode = buildNode(modelexInfoResponse);
            newNode.setFqdn(request.getFqdn());

            Node createdNode = nodeRepository.save(newNode);
            return nodeMapper.toDto(createdNode);
        }

        log.info("Existing Node with name: {}, Update Node", nodeName);
        Node existingNode = nodeOptional.get();
        buildNode(existingNode, modelexInfoResponse);
        existingNode.setFqdn(request.getFqdn());

        Node updatedNode = nodeRepository.save(existingNode);
        return nodeMapper.toDto(updatedNode);
    }

    private Node buildNode(ModelexInfoResponse modelexInfoResponse) {
        Node newNode = new Node();
        newNode.setName(modelexInfoResponse.getName());
        newNode.setEthereumAddress(modelexInfoResponse.getEthereumAddress());
        newNode.setPublicKey(modelexInfoResponse.getPublicKey());
        newNode.setP2pPort(modelexInfoResponse.getP2pPort());
        newNode.setRpcPort(modelexInfoResponse.getRpcPort());
        newNode.setRegistered(modelexInfoResponse.getRegistered());
        return newNode;
    }

    private void buildNode(Node existingNode, ModelexInfoResponse modelexInfoResponse) {
        existingNode.setName(modelexInfoResponse.getName());
        existingNode.setEthereumAddress(modelexInfoResponse.getEthereumAddress());
        existingNode.setPublicKey(modelexInfoResponse.getPublicKey());
        existingNode.setP2pPort(modelexInfoResponse.getP2pPort());
        existingNode.setRpcPort(modelexInfoResponse.getRpcPort());
        existingNode.setRegistered(modelexInfoResponse.getRegistered());

    }
}
