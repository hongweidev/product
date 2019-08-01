package com.example.product.common;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author hongwei
 * @date 2019/7/16 23:12
 */
@Data
public class ProductInfoOutput {
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Byte productStatus;

    private Integer categoryType;
}
