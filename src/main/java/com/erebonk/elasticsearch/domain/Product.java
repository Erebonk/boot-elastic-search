package com.erebonk.elasticsearch.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Product entity
 *
 * @author ilya
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Product {

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

    private String currencyId;

    private String picture;

    private String name;

    private String warranty;

    private String partnumber;

    private String remote;

    private String nameRus;

    private LocalDateTime updateDate;

    private String model;

    private String vendor;

    private String country;

    private String gtin;

}
