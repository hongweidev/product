package com.example.product.service.impl;

import com.example.product.dao.ProductInfoMapper;
import com.example.product.domain.ProductInfo;
import com.example.product.enums.ProductStatusEnum;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author msi
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoMapper.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
