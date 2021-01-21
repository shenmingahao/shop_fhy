package com.fh.shop_fhy.dao;

import com.fh.shop_fhy.model.ProductAttrDatas;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface ProductAttrDatasDao {

    @Insert("<script>insert into shop_product_attrdatas (proId,attrData,storcks,price) " +
            "values <foreach collection='list' item='a' separator=','> (#{a.proId},#{a.attrData},#{a.storcks},#{a.price}) </foreach> </script>")
    void adds(List<ProductAttrDatas> padList);
}
