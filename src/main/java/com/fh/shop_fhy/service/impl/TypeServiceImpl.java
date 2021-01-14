package com.fh.shop_fhy.service.impl;

import com.fh.shop_fhy.dao.TypeDao;
import com.fh.shop_fhy.model.Type;
import com.fh.shop_fhy.service.TypeService;
import com.fh.shop_fhy.vo.ReponseData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Resource
    private TypeDao typeDao;

    //查询
    public Object getData() {
        List<Type> typeList = typeDao.getData();
        return typeList;
    }

    //根据pid查询
    public Object getDataByPid(Integer pid) {
        List<Type> typeList = typeDao.getDataByPid(pid);
        return typeList;
    }

    //新增
    public Object add(Type type) {
        type.setCreateDate(new Date());
        type.setAuthor("admin");
        typeDao.add(type);
        return type.getId();
    }

    //修改
    public Object update(Type type) {
        Type tp = typeDao.queryDataById(type.getId());
        if (type.getPid() != null){
            tp.setPid(type.getPid());
        }else if (type.getName() != null){
            tp.setName(type.getName());
        }else if (type.getIsDel() != 0){
            tp.setIsDel(type.getIsDel());
        }
        tp.setUpdateDate(new Date());
        tp.setAuthor("admin");
        typeDao.update(tp);
        return null;
    }
}
