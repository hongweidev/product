package com.example.product.enums;

import lombok.Getter;

/**
 * @author hongwei
 * @date 2019/7/15 23:12
 */
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(1, "商品不存在"),

    PRODUCT_STOCK_ERROR(2, "库存有误"),
    ;
    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
