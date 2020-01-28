package com.erebonk.elasticsearch.service.processing;

import com.erebonk.elasticsearch.domain.Product;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Products services repository
 *
 * @author ilya
 * @version 1.0x
 */
public interface ProductRepositoryService {

    Product save(Product product);

    Iterable<? extends Product> saveAll(Iterable<? extends Product> entities);

    Optional<Product> findProductById(String id);

    Iterable<Product> search(QueryBuilder queryBuilder);

    Page<Product> search(SearchQuery searchQuery);

    Page<Product> search(QueryBuilder queryBuilder, Pageable pageable);

    Iterable<Product> findAll();

    List<Product> findAllByName(String name);

}
