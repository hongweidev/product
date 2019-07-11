package com.example.product.service;

import com.example.product.domain.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类目
 * @author msi
 */
public interface CategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
