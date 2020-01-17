package com.erebonk.elasticsearch.service.product.impl;

import com.erebonk.elasticsearch.domain.Product;
import com.erebonk.elasticsearch.repository.ReactiveProductRepository;
import com.erebonk.elasticsearch.service.product.ProductRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Product repository services
 *
 * @author ilya
 * @version 1.1
 */
@Component
@RequiredArgsConstructor
public class ProductRepositoryServiceImpl implements ProductRepositoryService {

    private final ReactiveProductRepository reactiveProductRepository;

    @Override
    public Mono<Product> save(Product product) {
        return reactiveProductRepository.save(product);
    }

    @Override
    public Mono<Long> amount() {
        return reactiveProductRepository.count();
    }

    @Override
    public Flux<Product> findAllByName(String name) {
        return reactiveProductRepository.findByName(name);
    }

//
//    @Override
//    public Flux<Product> search(SearchQuery searchQuery) {
//        return reactiveProductRepository.search(searchQuery);
//    }
}
