package com.erebonk.elasticsearch.controller;

import com.erebonk.elasticsearch.domain.Product;
import com.erebonk.elasticsearch.service.processing.ProductRepositoryService;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
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

    @GetMapping
    public Iterable<Product> findAll() {
        return productRepositoryService.findAll();
    }

    @GetMapping("/product")
    public List<Product> findAllByName(@NotNull @RequestParam String name) {
        return productRepositoryService.findAllByName(name);
    }

    @GetMapping("/search")
    public Page<Product> searchByText(@NotNull @RequestParam String text) {
        var sq = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.multiMatchQuery(text)
                .field("name")
                .field("rusName")
                .field("vendor")
                .type(MultiMatchQueryBuilder.Type.BEST_FIELDS))
                .build();
        return productRepositoryService.search(sq);
    }

}
