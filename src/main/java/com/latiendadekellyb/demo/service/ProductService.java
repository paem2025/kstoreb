package com.latiendadekellyb.demo.service;

import com.latiendadekellyb.demo.api.dto.ProductRequest;
import com.latiendadekellyb.demo.api.dto.ProductResponse;
import com.latiendadekellyb.demo.domain.model.ProductEntity;
import com.latiendadekellyb.demo.domain.repository.ProductRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> listAll() {
        return productRepository.findAllByOrderBySortOrderAscCreatedAtDesc()
            .stream()
            .map(this::toResponse)
            .toList();
    }

    @Transactional(readOnly = true)
    public ProductResponse getById(String id) {
        ProductEntity entity = productRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Product not found"));
        return toResponse(entity);
    }

    @Transactional
    public ProductResponse create(ProductRequest request) {
        ProductEntity entity = new ProductEntity();
        applyRequest(entity, request);
        return toResponse(productRepository.save(entity));
    }

    @Transactional
    public ProductResponse update(String id, ProductRequest request) {
        ProductEntity entity = productRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Product not found"));

        applyRequest(entity, request);
        return toResponse(productRepository.save(entity));
    }

    @Transactional
    public void delete(String id) {
        ProductEntity entity = productRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Product not found"));
        productRepository.delete(entity);
    }

    private void applyRequest(ProductEntity entity, ProductRequest request) {
        entity.setName(request.name().trim());
        entity.setPriceArs(request.price());
        entity.setDescription(request.description().trim());
        entity.setCategory(request.category().trim());
        entity.setImageUrl(request.image().trim());
        entity.setFeatured(request.featured() != null && request.featured());
        entity.setSortOrder(request.sortOrder() != null ? request.sortOrder() : 0);
    }

    private ProductResponse toResponse(ProductEntity entity) {
        return new ProductResponse(
            entity.getId(),
            entity.getName(),
            entity.getPriceArs(),
            entity.getDescription(),
            entity.getCategory(),
            entity.getImageUrl(),
            entity.isFeatured(),
            entity.getSortOrder(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );
    }
}
