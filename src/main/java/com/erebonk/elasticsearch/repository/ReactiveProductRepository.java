package com.erebonk.elasticsearch.repository;

import com.erebonk.elasticsearch.domain.Product;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

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
