package com.latiendadekellyb.demo.domain.repository;

import com.latiendadekellyb.demo.domain.model.ProductEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    List<ProductEntity> findAllByOrderBySortOrderAscCreatedAtDesc();
}
