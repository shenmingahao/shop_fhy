package com.fh.shop_fhy.service;

import com.fh.shop_fhy.model.Product;

public interface ProductService {
    Object addProduct(Product product , String attr , String sku);

    Object huixian(Integer id);

    Object updateProduct(Product product);

    Object deleteProduct(Integer id);
}
