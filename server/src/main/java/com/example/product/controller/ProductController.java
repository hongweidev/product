package com.example.product.controller;

import com.example.product.common.DecreaseStockInput;
import com.example.product.common.ProductInfoOutput;
import com.example.product.domain.ProductCategory;
import com.example.product.domain.ProductInfo;
import com.example.product.dto.CartDto;
import com.example.product.service.CategoryService;
import com.example.product.service.ProductService;
import com.example.product.utils.ResultVoUtil;
import com.example.product.vo.ProductInfoVo;
import com.example.product.vo.ProductVo;
import com.example.product.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author msi
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productInfoService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 1. 查询所有在架的商品
     * 2. 获取类目type列表
     * 3. 从数据库查询类目
     * 4. 构造数据
     *
     * @return
     */
    @GetMapping("list")
    public ResultVo<ProductVo> list() {
        // 1. 查询所有在架的商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        // 2. 获取类目type列表
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(productInfo -> productInfo.getCategoryType())
                .collect(Collectors.toList());
        // 3. 从数据库查询类目
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        // 4. 构造数据
        List<ProductVo> productVoList = new ArrayList<>();
        for (ProductCategory productCategory : categoryList) {
            ProductVo productVo = new ProductVo();
            productVo.setCategoryName(productCategory.getCategoryName());
            productVo.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVo> productInfoVoList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVoList);
            productVoList.add(productVo);
        }
        return ResultVoUtil.success(productVoList);
    }

    /**
     * 获取商品列表（给订单服务用的）
     * @param prodictIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfoOutput> listForOrder(@RequestBody List<String> prodictIdList){
        return productInfoService.findList(prodictIdList);
    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList){
        productInfoService.decreaseStock(decreaseStockInputList);
    }
}
