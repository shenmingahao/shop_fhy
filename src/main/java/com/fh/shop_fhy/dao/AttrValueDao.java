package com.fh.shop_fhy.dao;

import com.fh.shop_fhy.model.AttrValue;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AttrValueDao {
    @Select("select av.id,av.name,av.nameCH,av.isDel,av.attrId,ar.name as attrName from shop_attr_value av left join shop_attr ar " +
            "on av.attrId=ar.id where av.attrId = #{attrId} and av.isDel = 0")
    List<AttrValue> queryAttrValue(Integer attrId);

    @Insert("insert into shop_attr_value (name,nameCH,isDel,attrId) value (#{name},#{nameCH},#{isDel},#{attrId})")
    @Options(useGeneratedKeys = true ,keyProperty = "id")
    void addAttrValue(AttrValue attrValue);

    @Select("select id,name,nameCH,isDel,attrId from shop_attr_value where id = #{id}")
    AttrValue huixian(Integer id);

    @Update("update shop_attr_value set name=#{name},nameCH=#{nameCH},isDel=#{isDel} where id = #{id}")
    void updateAttrValue(AttrValue attrValue);

    @Update("update shop_attr_value set isDel=1 where id = #{id}")
    void deleteAttrValue(Integer id);
}
