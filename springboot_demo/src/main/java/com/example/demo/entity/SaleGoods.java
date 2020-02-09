package com.example.demo.entity;

import lombok.Data;

/**
 * @author SanKai
 * @since 2020-02-07
 */
@Data
public class SaleGoods {

    private Integer id;

    private String goodsName;

    private float weight;

    private int type;

    private Boolean onSale;

}
