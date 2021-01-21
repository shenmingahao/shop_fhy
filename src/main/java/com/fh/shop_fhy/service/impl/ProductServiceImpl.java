package com.fh.shop_fhy.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fh.shop_fhy.dao.ProductAttrDatasDao;
import com.fh.shop_fhy.dao.ProductDao;
import com.fh.shop_fhy.model.Product;
import com.fh.shop_fhy.model.ProductAttrDatas;
import com.fh.shop_fhy.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.beans.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductDao productDao;
    @Resource
    private ProductAttrDatasDao productAttrDatasDao;

    //新增
    //事务注解
    @Transactional
    public Object addProduct(Product product , String attr , String sku) {
        product.setCreateDate(new Date());
        product.setAuthor("admin");
        productDao.addProduct(product);

        //声明属性数据的对象
        List<ProductAttrDatas> padList = new ArrayList<>();
        //批量新增
        //将attr的json数组字符串  转换为json数组对象
        JSONArray objects = JSONObject.parseArray(attr);
        for (int i = 0; i < objects.size(); i++) {
            //构建属性数据对象
            ProductAttrDatas pads = new ProductAttrDatas();
            //设置对应的商品id
            pads.setProId(product.getId());
            pads.setAttrData(objects.get(i).toString());
            //放入集合
            padList.add(pads);
        }

        //将sku的json数组字符串  转换为json数组字符串
        JSONArray objectssku = JSONObject.parseArray(sku);
        for (int i = 0; i < objectssku.size(); i++) {
            //得到具体一个json对象
            JSONObject o = (JSONObject) objectssku.get(i);
            //构建属性数据对象
            ProductAttrDatas pads = new ProductAttrDatas();
            //设置对象商品的id
            pads.setProId(product.getId());
            pads.setPrice(o.getDouble("price"));
            pads.setStorcks(o.getInteger("storcks"));
            o.remove("price");
            o.remove("storcks");
            pads.setAttrData(objectssku.get(i).toString());
            //放入集合
            padList.add(pads);
        }
        //批量新增
        productAttrDatasDao.adds(padList);

        return product.getId();
    }

    //回显
    public Object huixian(Integer id) {
        Product product = productDao.huixaian(id);
        return product;
    }

    //修改
    public Object updateProduct(Product product) {
        product.setUpdateDate(new Date());
        product.setAuthor("admin");
        productDao.updateProduct(product);
        return null;
    }

    //删除
    public Object deleteProduct(Integer id) {
        productDao.deleteProduct(id);
        return null;
    }
}
