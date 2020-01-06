package com.erebonk.elasticsearch.service.product;

import com.erebonk.elasticsearch.domain.Product;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import java.util.List;
import java.util.Optional;

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
