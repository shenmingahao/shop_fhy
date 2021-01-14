package com.fh.shop_fhy.dao;

import com.fh.shop_fhy.model.Attribute;
import com.fh.shop_fhy.vo.AttributeParams;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AttributeDao {

    @Select("<script>select count(*) from shop_attr where 1=1 and isDel=0 " +
            "<if test='name != null and name != &quot;&quot;'> and name like CONCAT('%',#{name},'%')</if>" +
            "</script>")
    Long queryAttributeCount(AttributeParams params);

    @Select("<script>select id,name,nameCH,typeId,type,isSkU,isDel,createDate,updateDate,author from shop_attr where 1=1 and isDel=0 " +
            "<if test='name != null and name != &quot;&quot;'> and name like CONCAT('%',#{name},'%')</if>" +
            "</script>")
    List<Attribute> queryAttribute(AttributeParams params);

    @Insert("insert into shop_attr (name,nameCH,typeId,type,isSkU,isDel,createDate,updateDate,author) " +
            "value (#{name},#{nameCH},#{typeId},#{type},#{isSkU},#{isDel},#{createDate},#{updateDate},#{author})")
    @Options(useGeneratedKeys = true ,keyProperty = "id")
    void addAttribute(Attribute attribute);
}
