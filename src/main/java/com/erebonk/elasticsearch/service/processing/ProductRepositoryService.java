package com.erebonk.elasticsearch.service.processing;

import com.erebonk.elasticsearch.domain.Product;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Product repository
 *
 * @author ilya
 * @version 1.1
 */
public interface ProductRepositoryService {

    Product save(Product product);

    long amount();

    Page<Product> search(String text);

    List<Product> findAllByName(String name);

}
