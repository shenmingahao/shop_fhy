package com.fh.shop_fhy.controller;

import com.fh.shop_fhy.model.Product;
import com.fh.shop_fhy.service.ProductService;
import com.fh.shop_fhy.vo.ProductParams;
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
    public ReponseData addProduct(Product product , String attr , String sku){
        if (product == null){
            return ReponseData.error("数据不能为空");
        }
        if (attr == null){
            return ReponseData.error("数据不能为空");
        }
        if (sku == null){
            return ReponseData.error("数据不能为空");
        }
        return ReponseData.success(productService.addProduct(product , attr , sku));
    }

    //回显
    @PostMapping("huixian")
    public ReponseData huixian(Integer id){
        if (id == null){
            return ReponseData.error("id不能为空");
        }
        return ReponseData.success(productService.huixian(id));
    }

    //修改
    @PostMapping("updateProduct")
    public ReponseData updateProduct(Product product){
        if (product == null){
            return ReponseData.error("数据不能为空");
        }
        return ReponseData.success(productService.updateProduct(product));
    }

    //删除
    @PostMapping("deleteProduct")
    public ReponseData deleteProduct(Integer id){
        if (id == null){
            return ReponseData.error("id不能为空");
        }
        return ReponseData.success(productService.deleteProduct(id));
    }

    //查询
    @PostMapping("queryProduct")
    public ReponseData queryProduct(ProductParams params){
        if (params.getPage() == null){
            return ReponseData.error("page和limit不能为空");
        }
        if (params.getLimit() == null){
            return ReponseData.error("page和limit不能为空");
        }
        return ReponseData.success(productService.queryProduct(params));
    }

    //根据proId查询商品属性值的数据
    @PostMapping("queryProductAttrDatasByProId")
    public ReponseData queryProductAttrDatasByProId(Integer proId){
        if (proId == null){
            return ReponseData.error("proId不能为空");
        }
        return ReponseData.success(productService.queryProductAttrDatasByProId(proId));
    }

}
