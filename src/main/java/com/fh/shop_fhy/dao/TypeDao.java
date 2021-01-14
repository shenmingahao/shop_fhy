package com.fh.shop_fhy.dao;

import com.fh.shop_fhy.model.Type;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TypeDao {

    @Select("select id,name,pid,createDate,updateDate,isDel,author from shop_type where isDel=0")
    List<Type> getData();

    @Select("select id,name,pid,createDate,updateDate,isDel,author from shop_type where pid = #{pid} and isDel=0")
    List<Type> getDataByPid(Integer pid);

    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @Insert("insert into shop_type (name,pid,createDate,updateDate,isDel,author) value (#{name},#{pid},#{createDate},#{updateDate},#{isDel},#{author})")
    void add(Type type);

    @Select("select id,name,pid,createDate,updateDate,isDel,author from shop_type where id = #{id}")
    Type queryDataById(Integer id);

    @Update("update shop_type set name=#{name},pid=#{pid},updateDate=#{updateDate},isDel=#{isDel},author=#{author} where id=#{id}")
    void update(Type tp);
}
