package com.fh.shop_fhy.service.impl;

import com.fh.shop_fhy.dao.BrandDao;
import com.fh.shop_fhy.model.Brand;
import com.fh.shop_fhy.service.BrandService;
import com.fh.shop_fhy.vo.BrandParams;
import com.fh.shop_fhy.vo.PageResult;
import com.fh.shop_fhy.vo.ReponseData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {
    @Resource
    private BrandDao brandDao;

    //查询
    public ReponseData queryBrand(BrandParams params) {
        //查询总条数
        Long count = brandDao.queryBrandCount(params);
        //计算出下标
        params.setStartIndex((params.getPage()-1)*params.getLimit());
        List<Brand> brandList = brandDao.queryBrand(params);
        Map map = new HashMap();
        map.put("data",brandList);
        map.put("count",count);
        return ReponseData.success(map);
    }

    //新增
    public Object addBrand(Brand brand) {
        brand.setCreateDate(new Date());
        brand.setAuthor("admin");
        brandDao.addBrand(brand);
        return brand.getId();
    }

    //回显
    public Object huixian(Integer id) {
        Brand brand = brandDao.huixian(id);
        return brand;
    }

    //修改
    public Object updateBrand(Brand brand) {
        brand.setUpdateDate(new Date());
        brandDao.updateBrand(brand);
        return null;
    }

    //删除
    public Object deleteBrand(Integer id) {
        brandDao.deleteBrand(id);
        return null;
    }
}
