package com.fh.shop_fhy.dao;

import com.fh.shop_fhy.model.AttrValue;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AttrValueDao {
    @Select("select id,name,nameCH,isDel,attrId from shop_attr_value where attrId = #{attrId} and isDel = 0")
    List<AttrValue> queryAttrValue(Integer attrId);

    @Insert("insert into shop_attr_value (name,nameCH,isDel,attrId) value (#{name},#{nameCH},#{isDel},#{attrId})")
    @Options(useGeneratedKeys = true ,keyProperty = "id")
    void addAttrValue(AttrValue attrValue);
}
