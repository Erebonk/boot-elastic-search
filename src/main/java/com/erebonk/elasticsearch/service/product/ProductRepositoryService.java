package com.erebonk.elasticsearch.service.product;

import com.erebonk.elasticsearch.domain.Product;
import org.springframework.data.domain.Page;

/**
 * Product repository services
 *
 * @author ilya
 * @version 1.0
 */
public interface ProductRepositoryService {

    Product save(Product product);

    long amount();

    Page<Product> search(String text);

}
