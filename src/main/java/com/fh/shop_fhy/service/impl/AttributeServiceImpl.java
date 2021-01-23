package com.fh.shop_fhy.service.impl;

import com.fh.shop_fhy.dao.AttrValueDao;
import com.fh.shop_fhy.dao.AttributeDao;
import com.fh.shop_fhy.model.AttrValue;
import com.fh.shop_fhy.model.Attribute;
import com.fh.shop_fhy.service.AttributeService;
import com.fh.shop_fhy.vo.AttributeParams;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class AttributeServiceImpl implements AttributeService {
    @Resource
    private AttributeDao attributeDao;
    @Resource
    private AttrValueDao attrValueDao;

    //查询
    public Object queryAttribute(AttributeParams params) {
        //查询总数据的条数
        Long count = attributeDao.queryAttributeCount(params);
        //计算出下标
        params.setStartIndex((params.getPage()-1)*params.getLimit());
        List<Attribute> attributeList = attributeDao.queryAttribute(params);
        Map map = new HashMap();
        map.put("count",count);
        map.put("data",attributeList);
        return map;
    }

    //新增
    public Object addAttribute(Attribute attribute) {
        attribute.setCreateDate(new Date());
        attribute.setAuthor("admin");
        attributeDao.addAttribute(attribute);
        return attribute.getId();
    }

    //回显
    public Object huixian(Integer id) {
        Attribute attribute = attributeDao.huixian(id);
        return attribute;
    }

    //修改
    public Object updateAttribute(Attribute attribute) {
        attribute.setUpdateDate(new Date());
        attribute.setAuthor("admin");
        attributeDao.updateAttribute(attribute);
        return null;
    }

    //删除
    public Object deleteAttribute(Integer id) {
        attributeDao.deleteAttribute(id);
        return null;
    }

    //根据typeId查询所有数据
    public Object queryAttrByTypeId(Integer typeId) {
        List<Attribute> attributeList = attributeDao.queryAttrByTypeId(typeId);
        return attributeList;
    }

    //根据typeId查询所有数据
    public Object queryAttrDataByTypeId(Integer typeId) {
        //声明返回的数据
        Map map = new HashMap();
        //查询出所有的属性数据
        List<Attribute> attrs = attributeDao.queryAttrDataByTypeId(typeId);
        //声明skuDatas
        List<Attribute> skuDatas = new ArrayList<>();
        //声明attrDatas
        List<Attribute> attrDatas = new ArrayList<>();

        //遍历所有的属性数据
        for (int i = 0; i < attrs.size(); i++) {
            //得到一个具体数据
            Attribute attribute = attrs.get(i);
            //判断此属性是否为sku数据
            if (attribute.getIsSkU() == 2){
                //判断此属性的类型  如果是input则没有values
                if (attribute.getType() != 3){
                    //查询此属性  对应的选项值
                    List<AttrValue> attrValues = attrValueDao.queryAllDataByAid(attribute.getId());
                    attribute.setValues(attrValues);
                }
                attrDatas.add(attribute);
            }else {
                //是sku数据
                //判断此属性的类型  如果是input则没有values
                if (attribute.getType() != 3){
                    //查询此属性  对应的选项值
                    List<AttrValue> attrValues = attrValueDao.queryAllDataByAid(attribute.getId());
                    attribute.setValues(attrValues);
                }
                skuDatas.add(attribute);
            }
        }
        //sku数据
        map.put("skuDatas",skuDatas);
        //非sku数据
        map.put("attrDatas",attrDatas);
        return map;
    }
}
