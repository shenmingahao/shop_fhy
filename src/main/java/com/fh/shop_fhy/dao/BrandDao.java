package com.fh.shop_fhy.dao;

import com.fh.shop_fhy.model.Brand;
import com.fh.shop_fhy.vo.BrandParams;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BrandDao {

    @Select("<script> select count(*) from shop_brand where 1=1 and isDel=0 " +
            "<if test='name != null and name != &quot;&quot;'> and name like CONCAT('%',#{name},'%') </if>" +
            "</script>")
    Long queryBrandCount(BrandParams params);

    @Select("<script> select id,name,bandE,imgPath,bandDesc,ord,isDel,createDate,updateDate,author from shop_brand where 1=1 and isDel=0 " +
            "<if test='name != null and name != &quot;&quot;'> and name like CONCAT('%',#{name},'%') </if>" +
            "limit #{startIndex} , #{limit} " +
            "</script>")
    List<Brand> queryBrand(BrandParams params);

    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @Insert("insert into shop_brand (name,bandE,imgPath,bandDesc,ord,isDel,createDate,updateDate,author)" +
            " value (#{name},#{bandE},#{imgPath},#{bandDesc},#{ord},#{isDel},#{createDate},#{updateDate},#{author})")
    void addBrand(Brand brand);

    @Select("select id,name,bandE,imgPath,bandDesc,ord,isDel,createDate,updateDate,author from shop_brand where id = #{id}")
    Brand huixian(Integer id);

    @Update("update shop_brand set name=#{name},bandE=#{bandE},imgPath=#{imgPath},bandDesc=#{bandDesc}," +
            "ord=#{ord},updateDate=#{updateDate},author=#{author}" +
            " where id = #{id}")
    void updateBrand(Brand brand);

    @Update("update shop_brand set isDel=1 where id = #{id}")
    void deleteBrand(Integer id);

    @Select("select id,name,bandE,imgPath,bandDesc,ord,isDel,createDate,updateDate,author from shop_brand")
    List<Brand> queryBrandData();
}
