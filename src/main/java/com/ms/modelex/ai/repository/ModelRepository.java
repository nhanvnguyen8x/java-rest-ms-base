package com.ms.modelex.ai.repository;

import com.ms.modelex.ai.domain.Model;
import com.ms.modelex.ai.domain.Node;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ModelRepository extends JpaRepository<Model, Long> {
    List<Model> findByNode(Node node);
}
