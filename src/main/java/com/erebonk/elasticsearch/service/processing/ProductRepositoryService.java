package com.erebonk.elasticsearch.service.processing;

import com.erebonk.elasticsearch.domain.Product;
import org.springframework.data.domain.Page;

/**
 * Product repository
 *
 * @author ilya
 * @version 1.1
 */
public interface ProductRepositoryService {

    Product save(Product product);

    Page<Product> search(String text);

}
