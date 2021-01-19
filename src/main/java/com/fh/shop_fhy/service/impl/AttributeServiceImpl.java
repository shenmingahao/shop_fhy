package com.fh.shop_fhy.service.impl;

import com.fh.shop_fhy.dao.AttributeDao;
import com.fh.shop_fhy.model.Attribute;
import com.fh.shop_fhy.service.AttributeService;
import com.fh.shop_fhy.vo.AttributeParams;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AttributeServiceImpl implements AttributeService {
    @Resource
    private AttributeDao attributeDao;

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
}
