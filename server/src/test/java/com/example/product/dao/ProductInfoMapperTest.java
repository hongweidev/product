package com.example.product.dao;

import com.example.product.domain.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoMapperTest {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Test
    public void selectByPrimaryKey() {
        ProductInfo info = productInfoMapper.selectByPrimaryKey("157875196366160022");
        Assert.assertTrue(info!=null);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> list = productInfoMapper.findByProductStatus(0);
        Assert.assertTrue(list.size()==2);
    }

    @Test
    public void findByProductIdIn() throws  Exception {
        List<ProductInfo> list = productInfoMapper.findByProductIdIn(Arrays.asList("157875196366160022", "157875227953464068"));
        Assert.assertTrue(list.size()>0);
    }
}