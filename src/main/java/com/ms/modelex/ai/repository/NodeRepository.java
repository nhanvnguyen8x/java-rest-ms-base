package com.ms.modelex.ai.repository;

import com.ms.modelex.ai.domain.Node;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface NodeRepository extends JpaRepository<Node, Long> {
    Optional<Node> findByNameAndFqdn(String nodeName, String fqdn);

    Optional<Node> findByFqdnAndRpcPort(String fqdn, String port);
}
