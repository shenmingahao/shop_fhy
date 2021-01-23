package com.fh.shop_fhy.service;

import com.fh.shop_fhy.model.Product;
import com.fh.shop_fhy.vo.ProductParams;

public interface ProductService {
    Object addProduct(Product product , String attr , String sku);

    Object huixian(Integer id);

    Object updateProduct(Product product);

    Object deleteProduct(Integer id);

    Object queryProduct(ProductParams params);

    Object queryProductAttrDatasByProId(Integer proId);
}
