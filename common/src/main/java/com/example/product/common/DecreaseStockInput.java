package com.example.product.common;

import lombok.Data;

/**
 * @author hongwei
 * @date 2019/7/16 23:20
 */
@Data
public class DecreaseStockInput {
    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
