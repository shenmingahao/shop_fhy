package com.fh.shop_fhy.dao;

import com.fh.shop_fhy.model.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ProductDao {

    @Insert("insert into shop_product (name,title,brandId,typeId,productdecs,price,imgPath,stocks,sortNum,createDate,isDel,author)" +
            " value (#{name},#{title},#{brandId},#{typeId},#{productdecs},#{price},#{imgPath},#{stocks},#{sortNum},#{createDate},#{isDel},#{author})")
    @Options(useGeneratedKeys = true ,keyProperty = "id")
    void addProduct(Product product);

    @Select("select name,title,brandId,typeId,productdecs,price,imgPath,stocks,sortNum,createDate,updateDate,isDel,author from shop_product where id = #{id}")
    Product huixaian(Integer id);

    @Update("update shop_product set name=#{name},title=#{title},brandId=#{brandId},typeId=#{typeId},productdecs=#{productdecs},price=#{price},imgPath=#{imgPath},stocks=#{stocks},sortNum=#{sortNum},updateDate=#{updateDate},author=#{author} " +
            "where id = #{id}")
    void updateProduct(Product product);

    @Update("update shop_product set isdel = 1 where id = #{id}")
    void deleteProduct(Integer id);
}
