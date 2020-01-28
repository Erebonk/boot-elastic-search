package com.erebonk.elasticsearch.service.processing.impl;

import com.erebonk.elasticsearch.domain.Product;
import com.erebonk.elasticsearch.repository.ProductRepository;
import com.erebonk.elasticsearch.service.processing.ProductRepositoryService;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Product repository services
 *
 * @author ilya
 * @version 1.1
 */
@Component
@RequiredArgsConstructor
public class ProductRepositoryServiceImpl implements ProductRepositoryService {

    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Iterable<? extends Product> saveAll(Iterable<? extends Product> entities) {
        return productRepository.saveAll(entities);
    }

    @Override
    public Optional<Product> findProductById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Iterable<Product> search(QueryBuilder queryBuilder) {
        return productRepository.search(queryBuilder);
    }

    @Override
    public Page<Product> search(SearchQuery searchQuery) {
        return productRepository.search(searchQuery);
    }

    @Override
    public Page<Product> search(QueryBuilder queryBuilder, Pageable pageable) {
        return productRepository.search(queryBuilder, pageable);
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findAllByName(String name) {
        return productRepository.findAllByName(name);
    }

}
