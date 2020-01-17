package com.erebonk.elasticsearch.controller;

import com.erebonk.elasticsearch.domain.Product;
import com.erebonk.elasticsearch.service.product.ProductRepositoryService;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import javax.validation.constraints.NotNull;

/**
 * Product controller
 *
 *  -> First: find by product's name
 *  -> Second: find products where text is in name, rusName or vendor
 *
 *
 * @author ilya
 * @version 1.1
 */
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepositoryService productRepositoryService;

//    @GetMapping("/search")
//    public Flux<Product> searchByText(@NotNull @RequestParam String text) {
//        var sq = new NativeSearchQueryBuilder()
//                .withQuery(QueryBuilders.multiMatchQuery(text)
//                .field("name")
//                .field("rusName")
//                .field("vendor")
//                .type(MultiMatchQueryBuilder.Type.BEST_FIELDS))
//                .build();
//        return productRepositoryService.search(sq);
//    }

}
