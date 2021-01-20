package com.fh.shop_fhy.controller;

import com.fh.shop_fhy.model.Product;
import com.fh.shop_fhy.service.ProductService;
import com.fh.shop_fhy.vo.ReponseData;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("api/product")
public class ProductController {
    @Resource
    private ProductService productService;

    //新增
    @PostMapping("addProduct")
    public ReponseData addProduct(Product product){
        if (product == null){
            return ReponseData.error("数据不能为空");
        }
        return ReponseData.success(productService.addProduct(product));
    }
}
