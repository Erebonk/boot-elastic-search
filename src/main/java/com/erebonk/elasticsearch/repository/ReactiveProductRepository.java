package com.erebonk.elasticsearch.repository;

import com.erebonk.elasticsearch.domain.Product;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * Elasticsearch repository
 *
 * @author ilya
 * @version 1.1
 */
@Repository
public interface ReactiveProductRepository extends ReactiveElasticsearchRepository<Product, String> {

    Flux<Product> findByName(String name);

}
