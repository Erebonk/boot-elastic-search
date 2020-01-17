package com.erebonk.elasticsearch.service.product;

import com.erebonk.elasticsearch.domain.Product;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepositoryService {

    Mono<Product> save(Product product);

    Mono<Long> amount();


//    Flux<Product> search(SearchQuery searchQuery);

}
