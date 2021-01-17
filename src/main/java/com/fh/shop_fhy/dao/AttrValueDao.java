package com.fh.shop_fhy.dao;

import com.fh.shop_fhy.model.AttrValue;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AttrValueDao {
    @Select("select id,name,nameCH,attrId from shop_attr_value where attrId = #{attrId}")
    List<AttrValue> queryAttrValue(Integer attrId);
}
