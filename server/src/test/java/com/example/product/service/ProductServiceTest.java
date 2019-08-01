package com.example.product.service;

import com.example.product.ProductApplicationTests;
import com.example.product.common.DecreaseStockInput;
import com.example.product.common.ProductInfoOutput;
import com.example.product.domain.ProductInfo;
import com.example.product.dto.CartDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@Component
public class ProductServiceTest extends ProductApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    public void findList() {
        List<ProductInfoOutput> list = productService.findList(Arrays.asList("157875196366160022"));
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void decreaseStock() throws Exception {
        DecreaseStockInput decreaseStockInput = new DecreaseStockInput("157875196366160022", 2);
        productService.decreaseStock(Arrays.asList(decreaseStockInput));
    }
}