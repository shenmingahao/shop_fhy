package com.fh.shop_fhy.dao;

import com.fh.shop_fhy.model.Attribute;
import com.fh.shop_fhy.vo.AttributeParams;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    @Select("select id,name,nameCH,typeId,type,isSkU,isDel,createDate,updateDate,author from shop_attr where id = #{id}")
    Attribute huixian(Integer id);

    @Update("update shop_attr set name=#{name},nameCH=#{nameCH},typeId=#{typeId},type=#{type},isSkU=#{isSkU}," +
            "updateDate=#{updateDate},author=#{author} where id = #{id}")
    void updateAttribute(Attribute attribute);

    @Update("update shop_attr set isDel = 1 where id = #{id}")
    void deleteAttribute(Integer id);

    @Select("select id,name,nameCH,typeId,type,isSkU,isDel,createDate,updateDate,author from shop_attr where typeId = #{typeId}")
    List<Attribute> queryAttrByTypeId(Integer typeId);
}
