package com.erebonk.elasticsearch.service.processing.impl;

import com.erebonk.elasticsearch.domain.Product;
import com.erebonk.elasticsearch.repository.ProductRepository;
import com.erebonk.elasticsearch.service.processing.ProductRepositoryService;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.Semaphore;

/**
 * Product repository services
 *
 * @author ilya
 * @version 1.3
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
            var sq = new NativeSearchQueryBuilder()
                    .withQuery(QueryBuilders.multiMatchQuery(text)
                            .field("name")
                            .field("rusName")
                            .field("vendor")
                            .type(MultiMatchQueryBuilder.Type.BEST_FIELDS))
                    .build();
            return productRepository.search(sq);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return Page.empty();
    }

}
