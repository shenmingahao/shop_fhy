package com.fh.shop_fhy.service.impl;

import com.fh.shop_fhy.dao.ProductDao;
import com.fh.shop_fhy.model.Product;
import com.fh.shop_fhy.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductDao productDao;

    //新增
    public Object addProduct(Product product) {
        product.setCreateDate(new Date());
        product.setAuthor("admin");
        productDao.addProduct(product);
        return product.getId();
    }

    //回显
    public Object huixian(Integer id) {
        Product product = productDao.huixaian(id);
        return product;
    }
}
