package com.example.product.service;

import com.example.product.common.DecreaseStockInput;
import com.example.product.common.ProductInfoOutput;
import com.example.product.domain.ProductInfo;
import com.example.product.dto.CartDto;

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

    /**
     * 查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfoOutput> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param decreaseStockInputList
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
