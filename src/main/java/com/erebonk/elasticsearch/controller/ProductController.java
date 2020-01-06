package com.erebonk.elasticsearch.controller;

import com.erebonk.elasticsearch.domain.Product;
import com.erebonk.elasticsearch.service.product.ProductRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Product controller
 *
 * @author ilya
 * @version 1.0
 */
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepositoryService productRepositoryService;

//    @GetMapping
//    public List<Product> findAllByName(@NotNull String name) {
//        return productRepositoryService.findAllByName(name);
//    }

    @GetMapping
    public List<Product> findAll() {
        List<Product> actualList = new ArrayList<>();
        var productsIterator = productRepositoryService.findAll();
        productsIterator.forEach(actualList::add);
        return actualList;
    }

}
