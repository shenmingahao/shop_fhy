package com.fh.shop_fhy.dao;

import com.fh.shop_fhy.model.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

public interface ProductDao {

    @Insert("insert into shop_product (name,title,brandId,typeId,productdecs,price,imgPath,stocks,sortNum,createDate,isDel,author)" +
            " value (#{name},#{title},#{brandId},#{typeId},#{productdecs},#{price},#{imgPath},#{stocks},#{sortNum},#{createDate},#{isDel},#{author})")
    @Options(useGeneratedKeys = true ,keyProperty = "id")
    void addProduct(Product product);
}
