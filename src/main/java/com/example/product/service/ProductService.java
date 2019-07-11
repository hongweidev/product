package com.example.product.service;

import com.example.product.domain.ProductInfo;

import java.util.List;

/**
 * @author msi
 */
public interface ProductService {

    /**
     * 查询所有在架商品列表
     * @return
     */
    List<ProductInfo> findUpAll();
}
