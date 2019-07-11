package com.example.product.vo;

import lombok.Data;

/**
 * HTTP返回的最外层对象
 * @author msi
 */
@Data
public class ResultVo<T> {
    private Integer code;

    private String msg;

    private T data;
}
