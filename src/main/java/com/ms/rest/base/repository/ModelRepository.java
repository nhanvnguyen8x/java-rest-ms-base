package com.ms.rest.base.repository;

import com.ms.rest.base.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ModelRepository extends JpaRepository<Model, Long> {
}
