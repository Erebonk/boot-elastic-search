package com.erebonk.elasticsearch.domain;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Product entity
 *
 * @author ilya
 * @version 1.1
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Document(indexName = "product", type = "_doc")
public class Product implements Serializable {

    @Id
    private String id;

    private String uid;

    private String url;

    private BigDecimal priceR;

    private BigDecimal priceB;

    private BigDecimal priceC;

    private BigDecimal priceD;

    private BigDecimal priceE;

    private BigDecimal priceF;

    private BigDecimal priceRrc;

    private String categoryId;

    private String currencyId;

    private String picture;

    private String name;

    private String warranty;

    private String partnumber;

    private String remote;

    private String nameRus;

    private String updateDate;

    private String model;

    private String vendor;

    private String country;

    private String gtin;

}
