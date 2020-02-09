package com.erebonk.elasticsearch.service.processing.impl;

import com.erebonk.elasticsearch.domain.Product;
import com.erebonk.elasticsearch.repository.ProductRepository;
import com.erebonk.elasticsearch.service.processing.ProductRepositoryService;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Product repository services
 *
 * @author ilya
 * @version 1.4
 */
@Component
@RequiredArgsConstructor
public class ProductRepositoryServiceImpl implements ProductRepositoryService {

    private final ProductRepository productRepository;

    private Semaphore semaphore = new Semaphore(40);

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public long amount() {
        return productRepository.count();
    }

    @Override
    public Page<Product> search(String text) {
        try {
            semaphore.acquire();

            var pageable = PageRequest.of(0, 20);

            var qb = QueryBuilders.multiMatchQuery(text)
                    .field("name")
                    .field("rusName")
                    .field("vendor")
                    .type(MultiMatchQueryBuilder.Type.PHRASE_PREFIX);

            return productRepository.search(qb, pageable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return Page.empty();
    }

    @Override
    public List<Product> findAllByName(String name) {
        return productRepository.findAllByName(name);
    }

}
