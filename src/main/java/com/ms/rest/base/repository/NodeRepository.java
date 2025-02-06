package com.ms.rest.base.repository;

import com.ms.rest.base.domain.Node;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NodeRepository extends JpaRepository<Node, Long> {
}
