package com.example.product.service.impl;

import com.example.product.dao.ProductCategoryMapper;
import com.example.product.domain.ProductCategory;
import com.example.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author msi
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryMapper.findByCategoryTypeIn(categoryTypeList);
    }
}
