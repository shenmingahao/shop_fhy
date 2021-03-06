package com.fh.shop_fhy.service.impl;

import com.fh.shop_fhy.dao.AttrValueDao;
import com.fh.shop_fhy.model.AttrValue;
import com.fh.shop_fhy.service.AttrValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AttrValueServiceImpl implements AttrValueService {
    @Resource
    private AttrValueDao attrValueDao;

    //查询
    public Object queryAttrValue(Integer attrId) {
        List<AttrValue> attrValueList = attrValueDao.queryAttrValue(attrId);
        return attrValueList;
    }

    //新增
    public Object addAttrValue(AttrValue attrValue) {
        attrValueDao.addAttrValue(attrValue);
        return attrValue.getId();
    }

    //回显
    public Object huixian(Integer id) {
        AttrValue attrValue = attrValueDao.huixian(id);
        return attrValue;
    }

    //修改
    public Object updateAttrValue(AttrValue attrValue) {
        attrValueDao.updateAttrValue(attrValue);
        return null;
    }

    //删除
    public Object deleteAttrValue(Integer id) {
        attrValueDao.deleteAttrValue(id);
        return null;
    }


}
